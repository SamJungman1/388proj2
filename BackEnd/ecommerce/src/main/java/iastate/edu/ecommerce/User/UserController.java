package iastate.edu.ecommerce.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/User")
class UserController
{
    private HashMap<String,OAuth2AccessToken> tokens = new HashMap<String, OAuth2AccessToken>();

    @Autowired
    UserRepository userRepository;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/New")
    @GeneratedValue
    public String saveAccount(@RequestBody User user) throws EmailAlreadyExistsException {

        if(userRepository.checkLogin(user.getEmail(),user.getPassword()) == 1 || userRepository.checkLogin(user.getEmail(),user.getPassword()) == 0)
        {
            throw new EmailAlreadyExistsException();
        }
        Random rand = new Random();
        int tag = rand.nextInt(10000);
        String hexTag = Integer.toHexString(tag);
        int worstCase = 0;
        while(userRepository.checkTag(user.getUserName(),hexTag) == 0)
        {
            tag = rand.nextInt(10000);
            hexTag = Integer.toHexString(tag);
            worstCase++;
            if(worstCase == 15000)
            {
                throw new IllegalArgumentException("Pick a new username");
            }
        }
        user.setTag(hexTag);
        userRepository.storeNewUser(user.getEmail(),user.getUserName(),user.getPassword(),user.getTag(),user.getFirstName(),
        user.getLastName(),user.getAddress(),user.getCity(),user.getZipCode(),user.getState(),user.getCountry(),user.getPicturePointer());

        return "true";

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/Login",produces = { "application/json"})
    @GeneratedValue
    public String checkLogin(@RequestBody LoginForm form) throws EmailDoesNotExistException, IncorrectPasswordException {
        int result = userRepository.checkLogin(form.getEmail(),form.getPassword());
        if(result == -1 )
        {
            throw new EmailDoesNotExistException();
        }
        else if(result == 0)
        {
            throw new IncorrectPasswordException();
        }
        try {
            Instant week = Instant.now();
            String padding1 = week.toString();
            Random rand = new Random();
            int padding2 = rand.nextInt(10000);

            OAuth2AccessToken userToken = new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER,EncryptName.generateSSHA(((form.getEmail() + padding1).getBytes() + ""+  padding2).getBytes()),week, week.plusSeconds(604800));
            tokens.put(form.getEmail(),userToken);
            return userToken.getTokenValue();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/Search/Username/{uName}",produces = { "application/json"})
    @GeneratedValue
    public List<UserSearch> searchUsers(@PathVariable("uName") String uName)
    {
        List<User> temp = userRepository.searchUsers(uName);
        ArrayList<UserSearch> out = new ArrayList<UserSearch>();
        for(int i = 0; i < temp.size(); i++ )
        {
            User user = temp.get(i);
            out.add(new UserSearch(user.getUserName(),user.getTag(),user.getFirstName(),user.getLastName(),user.getCity(),user.getState(),user.getCountry()));
        }

        return out;
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/Search/Email/{email}",produces = { "application/json"})
    @GeneratedValue
    public UserLite searchUser(@PathVariable("email") String email)
    {
       User temp = userRepository.getUser(email);
       return new UserLite(temp.getEmail(),temp.getUserName(),temp.getTag(),temp.getFirstName(),temp.getLastName(),temp.getAddress(),temp.getCity(),temp.getZipCode(),temp.getState(),temp.getCountry());
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/Delete/Email/{email}",produces = { "application/json"})
    @GeneratedValue
    public void deleteUser(@PathVariable("email") String email) {
        userRepository.deleteUser(email);

    }


}
