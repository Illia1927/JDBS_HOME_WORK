package jdbspractise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "skill_id")
public class Skill {
    private Long skill_id;
    private TypeOfSkill typeOfSkill;
    private SkillLevel skillLevel;
    private Developer developerSkills;

    public enum TypeOfSkill {
        JAVA,
        CPP,
        C_SHARP,
        JAVA_SCRIPT
    }

    public enum SkillLevel {
        JUNIOR,
        MIDDLE,
        SENIOR
    }
}
