package jdbspractise.service;

import jdbspractise.model.Developer;
import jdbspractise.model.Skill;

import java.util.Set;

public interface DeveloperService {
    //create
    void addDeveloper(Developer developer);
    //read
    Developer getDeveloperById(Long id);
    //upate
    void updateDeveloper(Developer developer);
    //delete
    void removeDeveloper(Long id);

//    void getAllByTypeOfSkill(Skill skill);

    Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel);


    Set<Developer> findAllByLevelOfSkill(String skillLevel);
}
