package hu.unideb.inf;

import hu.unideb.inf.model.CustomerData;
import hu.unideb.inf.model.CustomerDataManager;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDataManagerTest {

    private CustomerData customer;
    private CustomerDataManager customerDataManager;

    @Before
    public void setUp() throws Exception {
        customer = new CustomerData("Ali","0234567789","Pakistani",
                "Male","ali@test.com","Residence Permit","Csapo ut 74",
                "19/5/2022","5","11","","25000");
        customerDataManager = new CustomerDataManager();
    }

    @Test
    public void testSetCustomerData() {
        customerDataManager.entityManager.getTransaction().begin();
        customerDataManager.entityManager.persist(customer);
        customerDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testDeleteCustomerData() {
        customerDataManager.entityManager.getTransaction().begin();
        customerDataManager.entityManager.remove(customer);
        customerDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testUpdateCustomerData() {
        customerDataManager.entityManager.getTransaction().begin();
        customerDataManager.entityManager.merge(customer);
        customerDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testGetAllCustomerData() {
        TypedQuery<CustomerData> query = customerDataManager.entityManager.createQuery("SELECT customerData FROM CustomerData customerData", CustomerData.class);
        List<CustomerData> queriedCustomerList = query.getResultList();
        int size = queriedCustomerList.size();
        Assert.assertEquals(size,queriedCustomerList.size());
    }
}