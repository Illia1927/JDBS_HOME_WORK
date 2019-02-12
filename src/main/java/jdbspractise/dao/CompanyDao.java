package jdbspractise.dao;

import jdbspractise.model.Company;

public interface CompanyDao {
    //create
    void addCompany(Company company);
    //read
    Company getCompanyById(Long id);
    //upate
    void updateCompany(Company company);
    //delete
    void removeCompany(Long id);

}
