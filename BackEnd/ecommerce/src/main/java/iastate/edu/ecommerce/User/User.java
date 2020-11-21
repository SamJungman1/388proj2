package iastate.edu.ecommerce.User;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Mimics user table within the database
 */
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @NotFound(action = NotFoundAction.IGNORE)
    private int userId;

    @Column(name = "username")
    @NotFound(action = NotFoundAction.IGNORE)
    private String userName;

    @Column(name = "Password")
    @NotFound(action = NotFoundAction.IGNORE)
    private String password;

    @Column(name = "Tag")
    @NotFound(action = NotFoundAction.IGNORE)
    private String tag;

    @Column(name = "FirstName")
    @NotFound(action = NotFoundAction.IGNORE)
    private String firstName;

    @Column(name = "LastName")
    @NotFound(action = NotFoundAction.IGNORE)
    private String lastName;

    @Column(name = "Email")
    @NotFound(action = NotFoundAction.IGNORE)
    private String email;

    @Column(name = "ZipCode")
    @NotFound(action = NotFoundAction.IGNORE)
    private String zipCode;

    @Column(name = "Address")
    @NotFound(action = NotFoundAction.IGNORE)
    private String address;

    @Column(name = "State")
    @NotFound(action = NotFoundAction.IGNORE)
    private String state;

    @Column(name = "City")
    @NotFound(action = NotFoundAction.IGNORE)
    private String city;

    @Column(name = "Country")
    @NotFound(action = NotFoundAction.IGNORE)
    private String country;

    @Column(name = "PicturePointer")
    @NotFound(action = NotFoundAction.IGNORE)
    private String picturePointer;

    public int getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getPicturePointer() {
        return picturePointer;
    }

    public String getState() {
        return state;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPicturePointer(String picturePointer) {
        this.picturePointer = picturePointer;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserID()
    {
        return this.userId;
    }

    public void setId(int id)
    {
        this.userId = id;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isNew()
    {
        return this.userName.equals(null);
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getZipCode()
    {
        return this.zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }


}
