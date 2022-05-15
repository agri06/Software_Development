package hu.unideb.inf.model;

import java.util.List;

public interface RoomDataDAOInterface extends AutoCloseable{
    public void setRoomData(RoomData roomData);
    public void deleteRoomData(RoomData roomData);
    public void updateRoomData(RoomData roomData);
    public List<RoomData> getAllRoomData();
}
