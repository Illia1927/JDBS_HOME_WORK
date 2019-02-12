package jdbspractise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "customer_id")
public class Customer {
    private Long customer_id;
    private String name;
    private Set<Project> projects = new HashSet<>();

    public void addProject(Project project){
        projects.add(project);
    }
}
