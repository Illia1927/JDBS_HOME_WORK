package jdbspractise.dao;

import jdbspractise.model.Developer;
import jdbspractise.model.Skill;

import java.util.Set;

public interface DeveloperDao {

    //create
    void addDeveloper(Developer developer);

    //read
    Developer getDeveloperById(Long id);

    //upate
    void updateDeveloper(Developer developer);

    //delete
    void removeDeveloper(Long id);

    Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel);
}
