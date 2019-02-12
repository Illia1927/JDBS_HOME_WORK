package jdbspractise;

import jdbspractise.dao.impl.CompanyDaoImpl;
import jdbspractise.dao.impl.CustomerDaoImpl;
import jdbspractise.dao.impl.DeveloperDaoImpl;
import jdbspractise.dao.impl.ProjectDaoImpl;
import jdbspractise.dao.impl.SkillDaoImpl;
import jdbspractise.model.Company;
import jdbspractise.model.Customer;
import jdbspractise.model.Developer;
import jdbspractise.model.Project;
import jdbspractise.model.Skill;
import jdbspractise.service.CompanyService;
import jdbspractise.service.CustomerService;
import jdbspractise.service.DeveloperService;
import jdbspractise.service.ProjectService;
import jdbspractise.service.SkillService;
import jdbspractise.service.impl.CompanyServiceImpl;
import jdbspractise.service.impl.CustomerServiceImpl;
import jdbspractise.service.impl.DeveloperServiceImpl;
import jdbspractise.service.impl.ProjectServiceImpl;
import jdbspractise.service.impl.SkillServiceImpl;
import jdbspractise.utill.ConnectionUtill;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtill.getConnection();
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
        SkillService skillService = new SkillServiceImpl(new SkillDaoImpl(connection));
        ProjectService projectService = new ProjectServiceImpl(new ProjectDaoImpl(connection));
        CompanyService companyService = new CompanyServiceImpl(new CompanyDaoImpl(connection));
        CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl(connection));
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

//        skillService.addSkill(skill);
//
//        developerService.addDeveloper(developerTwo);
//        Project projectOne = Project
//                .builder()
//                .name("Some")
//                .date(LocalDate.now())
//                .developers(new HashSet<>())
//                .company(companyOne)
//                .cost(2000.00)
//                .build();

//        projectService.addProject(projectOne);

        Company companyOne = Company
                .builder()
                .company_id(1L)
                .name("SuperCompany")
                .projects(new HashSet<>())
                .build();

//     companyService.addCompany(companyOne);

        Customer customerOne = Customer
                .builder()
                .customer_id(1L)
                .name("DELL")
                .projects(new HashSet<>())
                .build();
//        customerService.addCustomer(customerOne);

        Project projectOne = Project
                .builder()
                .name("Some")
                .date(LocalDate.now())
                .developers(new HashSet<>())
                .company(companyOne)
                .customer(customerOne)
                .cost(2000.00)
                .build();

        companyOne.addProject(projectOne);
        customerOne.addProject(projectOne);
        projectService.addProject(projectOne);

    }
}
