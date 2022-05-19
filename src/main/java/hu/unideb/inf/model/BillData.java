package hu.unideb.inf.model;

import javax.persistence.*;

@Entity
@Table(name = "BillData")
public class BillData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String idProof;

    @Basic(optional = false)
    private String address;

    @Basic(optional = false)
    private String checkInDate;

    @Basic(optional = false)
    private String numberOfDays;

    @Basic(optional = false)
    private String petTag;

    @Basic(optional = false)
    private String price;

    public BillData() {
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
