package jdbspractise.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}
