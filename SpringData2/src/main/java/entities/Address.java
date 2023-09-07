package entities;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

@Entity(name = "addresses")
public class Address {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "street")
    private String street;
    @Column(name = "street_number")
    private long streetNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "postal_code")
    private long postalCode;

    public Address(){}

    public Address(String street, long streetNumber, String city, String country, int postalCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostCode(String postCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public long getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public long getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
