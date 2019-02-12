package jdbspractise.service;

import jdbspractise.model.Company;

public interface CompanyService {
    //create
    void addCompany(Company company);
    //read
    Company getCompanyById(Long id);
    //upate
    void updateCompany(Company company);
    //delete
    void removeCompany(Long id);

}
