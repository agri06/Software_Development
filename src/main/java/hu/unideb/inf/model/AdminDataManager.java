package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdminDataManager implements AdminDataDAOInterface{

    public final EntityManagerFactory entityManagerFactory;
    public final EntityManager entityManager;

    public AdminDataManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagement");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void setAdminData(AdminData adminData) {
        entityManager.getTransaction().begin();
        entityManager.persist(adminData);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteAdminData(AdminData adminData) {
        entityManager.getTransaction().begin();
        entityManager.remove(adminData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateAdminData(AdminData adminData) {
        entityManager.getTransaction().begin();
        entityManager.merge(adminData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<AdminData> getAllData() {
        TypedQuery<AdminData> query = entityManager.createQuery("SELECT adminData FROM AdminData adminData", AdminData.class);
        List<AdminData> adminDataList = query.getResultList();
        return adminDataList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
