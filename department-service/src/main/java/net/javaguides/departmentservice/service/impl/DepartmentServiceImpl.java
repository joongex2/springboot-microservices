package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.AutoDepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity (manual)
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );

        // use modelMapper
        // Department department = modelMapper.map(departmentDto, Department.class);

        // use mapstruct
        Department department = AutoDepartmentMapper.MAPPER.departmentDtoToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        // convert department to department dto (manual)
//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );

        // use modelMapper
        // DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        // use mapstruct
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

        // use modelMapper
        // DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        // use mapstruct
        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(department);

        return departmentDto;
    }
}
