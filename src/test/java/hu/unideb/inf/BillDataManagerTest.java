package hu.unideb.inf;

import hu.unideb.inf.model.BillData;
import hu.unideb.inf.model.BillDataManager;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class BillDataManagerTest extends TestCase {

    private BillData bill;
    private BillDataManager billDataManager;

    @Before
    public void setUp() throws Exception {
        bill = new BillData("Ali","Residence Permit","Csapo ut 74",
                "19/5/2022","5","","25000");
        billDataManager = new BillDataManager();
    }

    @Test
    public void testSetBillData() {
        billDataManager.entityManager.getTransaction().begin();
        billDataManager.entityManager.persist(bill);
        billDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testDeleteBillData() {
        billDataManager.entityManager.getTransaction().begin();
        billDataManager.entityManager.remove(bill);
        billDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testUpdateBillData() {
        billDataManager.entityManager.getTransaction().begin();
        billDataManager.entityManager.merge(bill);
        billDataManager.entityManager.getTransaction().commit();
    }

    @Test
    public void testGetAllBillData() {
        TypedQuery<BillData> query = billDataManager.entityManager.createQuery("SELECT billData FROM BillData billData", BillData.class);
        List<BillData> queriedBillList = query.getResultList();
        int size = queriedBillList.size();
        Assert.assertEquals(size,queriedBillList.size());
    }
}