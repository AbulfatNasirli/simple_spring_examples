package az.spring.rest.demo.springrestdemo.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private long id;

    //@NotBlank(message = "name can not be null")
    @NotBlank
    private String name;

    @NotBlank
    private String surname;
    private int age;
    private double salary;


}
