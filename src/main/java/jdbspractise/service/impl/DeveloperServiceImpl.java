package jdbspractise.service.impl;

import jdbspractise.dao.DeveloperDao;
import jdbspractise.model.Developer;
import jdbspractise.model.Skill;
import jdbspractise.service.DeveloperService;

import java.util.Set;

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

    @Override
    public Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill) {
        return null;
    }
}
