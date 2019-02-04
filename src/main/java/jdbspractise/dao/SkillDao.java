package jdbspractise.dao;

import jdbspractise.model.Skill;

public interface SkillDao {

    void addSkill(Skill skill);

    Skill getSkillById(Long id);

    void updateSkill(Skill skill);

    void removeSkill(Long id);
}
