package jdbspractise.service.impl;

import jdbspractise.dao.CompanyDao;
import jdbspractise.model.Company;
import jdbspractise.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return null;
    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void removeCompany(Long id) {

    }
}
