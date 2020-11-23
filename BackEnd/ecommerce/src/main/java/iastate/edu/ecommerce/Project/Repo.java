package iastate.edu.ecommerce.Project;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends Repository {
    int returnVal(String token1,int expire);
    void deleteToken(String token1);
    void deleteUserToken(String email1);
    String returnEmail(String token1);
    void save(Tokens token);

    void listingSave(Listings listings);

    int reverseLookupListings(int userId, int timestamp);

    int checkHashTags(String hashtag);

    void storeHashTags(String hashtag);

    int getHashtagId(String hashtag);

    void storeHashTagsToListings(int lId, int tagId);

    List getListByName(String name);
}
