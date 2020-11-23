package iastate.edu.ecommerce.Project;

public class UserSearch {
    private String username;
    private String tag;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;

    UserSearch(String username, String tag, String firstName, String lastName, String city,String state,String country)
    {
        this.username = username;
        this.tag = tag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
