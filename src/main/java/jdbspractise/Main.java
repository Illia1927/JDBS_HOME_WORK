package jdbspractise;

import jdbspractise.dao.impl.DeveloperDaoImpl;
import jdbspractise.dao.impl.SkillDaoImpl;
import jdbspractise.model.Developer;
import jdbspractise.model.Skill;
import jdbspractise.service.DeveloperService;
import jdbspractise.service.SkillService;
import jdbspractise.service.impl.DeveloperServiceImpl;
import jdbspractise.service.impl.SkillServiceImpl;
import jdbspractise.utill.ConnectionUtill;

import java.sql.Connection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtill.getConnection();
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
        SkillService skillService = new SkillServiceImpl(new SkillDaoImpl(connection));
        Developer developerOne = Developer
                .builder()
                .name("Maria")
                .age(18)
                .salary(500D)
                .build();
//
//        Developer developerTwo = Developer
//                .builder()
//                .name("Illia")
//                .age(20)
//                .salary(400D)
//                .build();

//        developerService.addDeveloper(developerOne);
//        developerService.addDeveloper(developerTwo);
//        developerService.removeDeveloper(2L);
        Skill skill = Skill
                .builder()
                .typeOfSkill(Skill.TypeOfSkill.JAVA)
                .skillLevel(Skill.SkillLevel.JUNIOR)
                .build();


        Developer developerTwo = Developer
                .builder()
                .name("Illia")
                .age(20)
                .salary(400D)
                .skills(new HashSet<>())
                .build();

        skillService.addSkill(skill);

        developerService.addDeveloper(developerTwo);
    }
}
