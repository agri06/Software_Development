package hu.unideb.inf;

import hu.unideb.inf.model.RoomData;
import hu.unideb.inf.model.RoomDataManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.*;

public class RoomDataManagerTest {

    private RoomData room;
    private RoomDataManager roomDataManager;

    @Before
    public void setUp() throws Exception {
        room = new RoomData("112","AC","5","12000","AVAILABLE");
        roomDataManager = new RoomDataManager();
    }

    @Test
    public void setRoomData() {
        roomDataManager.entityManager.getTransaction().begin();
        roomDataManager.entityManager.persist(room);
        roomDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void deleteRoomData() {
        roomDataManager.entityManager.getTransaction().begin();
        roomDataManager.entityManager.remove(room);
        roomDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void updateRoomData() {
        roomDataManager.entityManager.getTransaction().begin();
        roomDataManager.entityManager.merge(room);
        roomDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void getAllRoomData() {
        TypedQuery<RoomData> query = roomDataManager.entityManager.createQuery("SELECT roomData FROM RoomData roomData", RoomData.class);
        List<RoomData> queriedRoomList = query.getResultList();
        int size = queriedRoomList.size();
        Assert.assertEquals(size, queriedRoomList.size());
    }
}