package hu.unideb.inf.model;

import javax.persistence.*;

@Entity
@Table(name = "RoomData")
public class RoomData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Basic(optional = false)
    private String roomNo;
    @Basic(optional = false)
    private String roomType;
    @Basic(optional = false)
    private String bed;
    @Basic(optional = false)
    private String price;
    @Basic(optional = false)
    private String status;

    public RoomData() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
