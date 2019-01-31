package jdbspractise.Service.Impl;

import jdbspractise.Dao.DeveloperDao;
import jdbspractise.Model.Developer;
import jdbspractise.Service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperDao developerDao;

    public DeveloperServiceImpl(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    public void addDeveloper(Developer developer) {
        developerDao.addDeveloper(developer);
    }

    @Override
    public Developer getDeveloperById(Long id) {
        return developerDao.getDeveloperById(id);
    }

    @Override
    public void updateDeveloper(Developer developer) {
        developerDao.updateDeveloper(developer);
    }

    @Override
    public void removeDeveloper(Long id) {
        developerDao.removeDeveloper(id);
    }
}
