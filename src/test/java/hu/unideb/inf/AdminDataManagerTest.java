package hu.unideb.inf;

import hu.unideb.inf.model.AdminData;
import hu.unideb.inf.model.AdminDataManager;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AdminDataManagerTest extends TestCase {

    private AdminData admin;
    private AdminDataManager adminDataManager;

    @Before
    public void setUp() throws Exception {
        admin = new AdminData(1, "ali", "ali@test.com", "123");
        adminDataManager = new AdminDataManager();
    }

    @Test
    public void testSetAdminData() {
        adminDataManager.entityManager.getTransaction().begin();
        adminDataManager.entityManager.persist(admin);
        adminDataManager.entityManager.getTransaction().commit();
    }

    public void testDeleteAdminData() {
    }

    public void testUpdateAdminData() {
    }

    public void testGetAllData() {
    }
}