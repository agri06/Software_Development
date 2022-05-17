package hu.unideb.inf.model;

import javax.persistence.*;

@Entity
@Table(name = "CustomerData")
public class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String mobileNumber;

    @Basic(optional = false)
    private String Nationality;

    @Basic(optional = false)
    private String gender;

    @Basic(optional = false)
    private String email;

    @Basic(optional = false)
    private String idProof;

    @Basic(optional = false)
    private String address;

    @Basic(optional = false)
    private String checkInDate;

    @Basic(optional = false)
    private String numberOfDays;

    @Basic(optional = false)
    private String roomNumber;

    @Basic(optional = false)
    private String petTag;

    @Basic(optional = false)
    private String price;

    public CustomerData() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPetTag() {
        return petTag;
    }

    public void setPetTag(String petTag) {
        this.petTag = petTag;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
