package hu.unideb.inf.model;

import java.util.List;

public interface CustomerDataDAOInterface extends AutoCloseable{
    public void setCustomerData(CustomerData customerData);
    public void deleteCustomerData(CustomerData customerData);
    public void updateCustomerData(CustomerData customerData);
    public List<CustomerData> getAllCustomerData();
}
