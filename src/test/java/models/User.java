package models;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User() {}

    public User(String name, String surname, String email, Address address, String phone, String website, Company company) {
        this.name = name;
        this.username = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }
}
