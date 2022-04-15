package hu.unideb.inf.model;

import java.util.List;

public interface AdminDataDAOInterface extends AutoCloseable{
    public void setAdminData(AdminData adminData);
    public void deleteAdminData(AdminData adminData);
    public void updateAdminData(AdminData adminData);
    public List<AdminData> getAllData();
}
