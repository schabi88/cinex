package de.cinex.domain;


public class UserData extends PersistentObject {

    /**
     * --------------------VARIABLES----------------------------
     */
    private String username;
    private String lastname;
    private String firstname;
    private String location;
    private String email;
    private String password;
    private String gender;
    private String phonenumber;


    /**
     * -------------------Getter/Setter-------------------------
     */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * -------------------Constructor-------------------------
     */

    public UserData() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' + ", Username='" + username + '\'' +
                '}';
    }
}
