package hu.unideb.inf.model;

import java.util.List;

public interface BillDataDAOInterface extends AutoCloseable{
    public void setBillData(BillData billData);
    public void deleteBillData(BillData billData);
    public void updateBillData(BillData billData);
    public List<BillData> getAllBillData();
}
