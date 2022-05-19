package hu.unideb.inf;

import hu.unideb.inf.model.AdminData;
import hu.unideb.inf.model.AdminDataManager;
import hu.unideb.inf.model.BillData;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class AdminDataManagerTest extends TestCase {

    private AdminData admin;
    private AdminDataManager adminDataManager;

    @Before
    public void setUp() throws Exception {
        admin = new AdminData( "ali", "ali@test.com", "123");
        adminDataManager = new AdminDataManager();
    }

    @Test
    public void testSetAdminData() {
        adminDataManager.entityManager.getTransaction().begin();
        adminDataManager.entityManager.persist(admin);
        adminDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testDeleteAdminData() {
        adminDataManager.entityManager.getTransaction().begin();
        adminDataManager.entityManager.remove(admin);
        adminDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testUpdateAdminData() {
        adminDataManager.entityManager.getTransaction().begin();
        adminDataManager.entityManager.merge(admin);
        adminDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testGetAllAdminData() {
        TypedQuery<AdminData> query = adminDataManager.entityManager.createQuery("SELECT adminData FROM AdminData adminData", AdminData.class);
        List<AdminData> queriedAdminList = query.getResultList();
        int size = queriedAdminList.size();
        Assert.assertEquals(size,queriedAdminList.size());
    }
}