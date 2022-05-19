package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BillDataManager implements BillDataDAOInterface{
    public final EntityManagerFactory entityManagerFactory;
    public final EntityManager entityManager;

    public BillDataManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagement");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void setBillData(BillData billData) {
        entityManager.getTransaction().begin();
        entityManager.persist(billData);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteBillData(BillData billData) {
        entityManager.getTransaction().begin();
        entityManager.remove(billData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateBillData(BillData billData) {
        entityManager.getTransaction().begin();
        entityManager.merge(billData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<BillData> getAllBillData() {
        TypedQuery<BillData> query = entityManager.createQuery("SELECT billData FROM BillData billData", BillData.class);
        List<BillData> billDataList = query.getResultList();
        return billDataList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
