package jdbspractise;

import jdbspractise.Dao.Impl.DeveloperDaoImpl;
import jdbspractise.Model.Developer;
import jdbspractise.Service.DeveloperService;
import jdbspractise.Service.Impl.DeveloperServiceImpl;
import jdbspractise.Utill.ConnectionUtill;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtill.getConnection();
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));

        Developer developerOne = Developer
                .builder()
                .name("Maria")
                .age(18)
                .salary(500D)
                .build();

        Developer developerTwo = Developer
                .builder()
                .name("Illia")
                .age(20)
                .salary(400D)
                .build();

//        developerService.addDeveloper(developerOne);
//        developerService.addDeveloper(developerTwo);
        developerService.removeDeveloper(2L);
    }
}
