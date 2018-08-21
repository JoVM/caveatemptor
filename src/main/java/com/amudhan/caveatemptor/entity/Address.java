package com.amudhan.caveatemptor.entity;

import com.amudhan.caveatemptor.constant.AddressQueries;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = AddressQueries.GETALLADDRESSES, query = AddressQueries.GETALLADDRESSES_Q)
})
@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_sequence")
//	@SequenceGenerator(initialValue= 1, name="address_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "building", nullable = false)
    private String building;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "zipcode", nullable = false)
    private String zipCode;
    @Column(name = "city", nullable = false)
    private String city;
    @Enumerated(EnumType.STRING)
    @Column(name = "addresstype")
    @NotNull
    private AddressType addressType;
    @ManyToOne
    @JoinColumn(name = "userid")
    @NotNull
    private User user;

    public enum AddressType {BILLING, SHIPPING, HOME}

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(long id) {
        this.id = id;
    }
}
