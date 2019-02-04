package jdbspractise.service.impl;

import jdbspractise.dao.SkillDao;
import jdbspractise.model.Skill;
import jdbspractise.service.SkillService;

public class SkillServiceImpl implements SkillService {

    private SkillDao skillDao;
    public SkillServiceImpl(SkillDao skillDao){
        this.skillDao = skillDao;
    }

    @Override
    public void addSkill(Skill skill) {
        skillDao.addSkill(skill);
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillDao.getSkillById(id);
    }

    @Override
    public void updateSkill(Skill skill) {
        skillDao.updateSkill(skill);
    }

    @Override
    public void removeSkill(Long id) {
        skillDao.removeSkill(id);
    }
}
