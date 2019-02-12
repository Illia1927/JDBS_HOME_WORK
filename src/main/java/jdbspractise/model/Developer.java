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
@ToString(exclude = "developer_id")
public class Developer {
    private Long developer_id;
    private String name;
    private Integer age;
    private Double salary;
    private Set<Skill> skills;
    private Set<Project> projects;

    public void addSkill(Skill skill){
        skills.add(skill);
    }

    public void addProject(Project project){
        projects.add(project);
    }
}
