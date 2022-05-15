package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoomDataManager implements RoomDataDAOInterface{

    public final EntityManagerFactory entityManagerFactory;
    public final EntityManager entityManager;

    public RoomDataManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagement");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void setRoomData(RoomData roomData) {
        entityManager.getTransaction().begin();
        entityManager.persist(roomData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteRoomData(RoomData roomData) {
        entityManager.getTransaction().begin();
        entityManager.remove(roomData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateRoomData(RoomData roomData) {
        entityManager.getTransaction().begin();
        entityManager.merge(roomData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<RoomData> getAllRoomData() {
        TypedQuery<RoomData> query = entityManager.createQuery("SELECT roomData FROM RoomData roomData", RoomData.class);
        List<RoomData> roomDataList = query.getResultList();
        return roomDataList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
