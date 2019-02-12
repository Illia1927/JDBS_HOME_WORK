package jdbspractise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long projects_id;
    private String name;
    private LocalDate date;
    private Double cost;
    private Company company;
    private Customer customer;
    private Set<Developer> developers;

    public void addDeveloperForProject(Developer developer){
        developers.add(developer);
    }
}
