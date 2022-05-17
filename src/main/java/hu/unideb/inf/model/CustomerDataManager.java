package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDataManager implements CustomerDataDAOInterface{

    public final EntityManagerFactory entityManagerFactory;
    public final EntityManager entityManager;

    public CustomerDataManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagement");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void setCustomerData(CustomerData customerData) {
        entityManager.getTransaction().begin();
        entityManager.persist(customerData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomerData(CustomerData customerData) {
        entityManager.getTransaction().begin();
        entityManager.remove(customerData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCustomerData(CustomerData customerData) {
        entityManager.getTransaction().begin();
        entityManager.merge(customerData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<CustomerData> getAllCustomerData() {
        TypedQuery<CustomerData> query = entityManager.createQuery("SELECT customerData FROM CustomerData customerData", CustomerData.class);
        List<CustomerData> customerDataList = query.getResultList();
        return customerDataList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
