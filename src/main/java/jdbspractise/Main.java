package jdbspractise;

import jdbspractise.dao.impl.DeveloperDaoImpl;
import jdbspractise.model.Developer;
import jdbspractise.model.Skill;
import jdbspractise.service.DeveloperService;
import jdbspractise.service.impl.DeveloperServiceImpl;
import jdbspractise.utill.ConnectionUtill;

import java.sql.Connection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtill.getConnection();
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
//        SkillService skillService = new SkillServiceImpl(new SkillDaoImpl(connection));
//        ProjectService projectService = new ProjectServiceImpl(new ProjectDaoImpl(connection));
//        CompanyService companyService = new CompanyServiceImpl(new CompanyDaoImpl(connection));
//        CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl(connection));

        Skill skill = Skill
                .builder()
                .typeOfSkill(Skill.TypeOfSkill.JAVA)
                .skillLevel(Skill.SkillLevel.JUNIOR)
                .build();

        Developer developerOne = Developer
                .builder()
                .name("Maria")
                .age(18)
                .skills(new HashSet<>())
                .salary(500D)
                .build();

        developerOne.addSkill(skill);
        developerService.addDeveloper(developerOne);
        developerService.getDeveloperById(17L);
        developerService.findAllByLevelOfSkill("junior").forEach(System.out::println);
        System.out.println(developerOne.toString());
    }
}
