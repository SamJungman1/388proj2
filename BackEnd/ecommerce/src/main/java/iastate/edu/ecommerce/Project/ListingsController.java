package iastate.edu.ecommerce.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/Listing")
@Service
public class ListingsController {
    @Autowired
    Repo repo;
    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/New")
    @GeneratedValue
    public void saveAccount(@RequestBody ListingsCarrierInput form) throws UnauthorizedAttemptException {
        String token = form.getToken().getVal();
        if(repo.returnVal(token,(int) Instant.now().getEpochSecond()) == 0)
        {
            repo.deleteToken(token);
            throw new UnauthorizedAttemptException("Your token has expired, please re-login");
        }
        String email = repo.returnEmail(token);
        ListingsInputForm input = form.getForm();
        User user = userRepository.getUser(email);
        Listings listings = new Listings();
        listings.setListingName(input.getListingName());
        listings.setUserId(user.getUserId());
        listings.setListingDescription(input.getListingDescription());
        listings.setTimestamp((int) Instant.now().getEpochSecond());
        repo.listingSave(listings);
        int lId = repo.reverseLookupListings(listings.getUserId(),listings.getTimestamp());
        for(int i = 0; i < input.getTags().length; i++)
        {
            String hashtag = input.getTags()[i].getTag();
            if(repo.checkHashTags(hashtag) == 0)
            {
                repo.storeHashTags(hashtag);
            }
            int tagId = repo.getHashtagId(hashtag);
            repo.storeHashTagsToListings(lId,tagId);
        }
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/Search")
    @GeneratedValue
    public List getListingsByList(@RequestBody GetListingInput form) throws UnauthorizedAttemptException
    {
        String token = form.getToken().getVal();
        if(repo.returnVal(token,(int) Instant.now().getEpochSecond()) == 0)
        {
            repo.deleteToken(token);
            throw new UnauthorizedAttemptException("Your token has expired, please re-login");
        }
        return repo.getListByName(form.getName());

    }
}
