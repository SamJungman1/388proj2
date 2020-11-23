package iastate.edu.ecommerce.Project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ListingsInputForm {
    //private String userName;
    private String listingName;
    private String listingDescription;
    private Hashtag[] tags;

    public Hashtag[] getTags() {
        return tags;
    }

    public void setTags(Hashtag[] tags) {
        this.tags = tags;
    }

    public String getListingDescription() {
        return listingDescription;
    }

    public String getListingName() {
        return listingName;
    }



    public void setListingDescription(String listingDescription) {
        this.listingDescription = listingDescription;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }
}
