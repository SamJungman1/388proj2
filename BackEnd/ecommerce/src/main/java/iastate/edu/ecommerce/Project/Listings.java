package iastate.edu.ecommerce.Project;

public class Listings {
    private int userId;
    private String listingName;
    private String listingDescription;
    private int timestamp;

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public void setListingDescription(String listingDescription) {
        this.listingDescription = listingDescription;
    }

    public String getListingName() {
        return listingName;
    }

    public String getListingDescription() {
        return listingDescription;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
