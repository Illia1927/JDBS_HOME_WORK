package jdbspractise.service;

import jdbspractise.model.Skill;

public interface SkillService {

    void addSkill(Skill skill);

    Skill getSkillById(Long id);

    void updateSkill(Skill skill);

    void removeSkill(Long id);
}
