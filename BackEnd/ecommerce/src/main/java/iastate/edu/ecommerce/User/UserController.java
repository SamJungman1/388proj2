package iastate.edu.ecommerce.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Random;

@RestController
class UserController
{
    private HashMap<String,OAuth2AccessToken> tokens = new HashMap<String, OAuth2AccessToken>();

    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/User/New",produces = { "application/json"})
    @GeneratedValue
    public String saveAccount(@RequestBody User user)
    {

        userRepository.storeNewUser(user.getEmail(),user.getUserName(),user.getPassword(),user.getFirstName(),
        user.getLastName(),user.getAddress(),user.getCity(),user.getZipCode(),user.getState(),user.getCountry(),user.getPicturePointer());


        return "true";

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/User/Login",produces = { "application/json"})
    @GeneratedValue
    public OAuth2AccessToken checkLogin(@RequestBody LoginForm form) throws EmailDoesNotExistException, IncorrectPasswordException {
        int result = userRepository.checkLogin(form.getEmail(),form.getPassword());
        if(result == 0 )
        {
            throw new EmailDoesNotExistException();
        }
        else if(result == -1)
        {
            throw new IncorrectPasswordException();
        }
        try {
            Instant week = Instant.now();
            String padding1 = week.toString();
            Random rand = new Random();
            int padding2 = rand.nextInt(10000);
            week.plusSeconds(604800);
            OAuth2AccessToken userToken = new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER,EncryptName.generateSSHA(((form.getEmail() + padding1).getBytes() + ""+  padding2).getBytes()),Instant.now(),week);
            tokens.put(form.getEmail(),userToken);
            return userToken;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }


}
