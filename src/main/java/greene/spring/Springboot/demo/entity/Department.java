package greene.spring.Springboot.demo.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add department name")
    @Length(max = 20, min = 2)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode; 
}
