package hu.unideb.inf.RoomAndCustomers;

import javafx.beans.property.SimpleStringProperty;

public class ManageRoomTable {
    private SimpleStringProperty RoomNo = null;
    private SimpleStringProperty roomType = null;
    private SimpleStringProperty bed = null;
    private SimpleStringProperty price = null;
    private SimpleStringProperty status = null;

    public ManageRoomTable(String roomNo, String roomType, String bed, String price, String status) {
        this.RoomNo = new SimpleStringProperty(roomNo);
        this.roomType = new SimpleStringProperty(roomType);
        this.bed = new SimpleStringProperty(bed);
        this.price = new SimpleStringProperty(price);
        this.status = new SimpleStringProperty(status);
    }

    public ManageRoomTable() {
    }

    public String getRoomNo() {
        return RoomNo.get();
    }

    public void setRoomNo(String roomNo) {
        RoomNo = new SimpleStringProperty(roomNo);
    }

    public String getRoomType() {
        return roomType.get();
    }

    public void setRoomType(String roomType) {
        this.roomType = new SimpleStringProperty(roomType);
    }

    public String getBed() {
        return bed.get();
    }

    public void setBed(String bed) {
        this.bed = new SimpleStringProperty(bed);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price = new SimpleStringProperty(price);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status = new SimpleStringProperty(status);
    }
}
