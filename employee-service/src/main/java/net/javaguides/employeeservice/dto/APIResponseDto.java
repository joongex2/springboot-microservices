package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "API Response Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    @Schema(
            description = "Employee"
    )
    private EmployeeDto employee;

    @Schema(
            description = "Department"
    )
    private DepartmentDto department;

    @Schema(
            description = "Organization"
    )
    private OrganizationDto organization;
}
