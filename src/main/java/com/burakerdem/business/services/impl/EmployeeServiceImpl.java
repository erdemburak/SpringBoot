package com.burakerdem.business.services.impl;

import com.burakerdem.business.dto.EmployeeDto;
import com.burakerdem.business.services.EmployeeServices;
import com.burakerdem.data.entity.EmployeeEntity;
import com.burakerdem.data.repository.EmployeeRepository;
import com.burakerdem.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    //List
    //http:/localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entityList = employeeRepository.findAll();
        for (EmployeeEntity entity : entityList) {
            EmployeeDto employeeDto = EntityToDto(entity);
            listDto.add(employeeDto);
        }
        return listDto;
    }

    //Save
    //http:/localhost:8080/api/v1/employees/
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    // Find
    // http:/localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleyee not exist with id " + id));
        EmployeeDto employeeDto = EntityToDto(employee);
        return ResponseEntity.ok(employeeDto);
    }

    // Update
    // http:/localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails); // ModelMapper
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleyee not exist with id " + id));
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmail(employeeEntity.getEmail());

        EmployeeEntity updateEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updateEmployee);

        return ResponseEntity.ok(employeeDto);
    }

    // Delete
    // http:/localhost:8080/api/v1/employees/1
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist wit id " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //////////////////////////////////////////////////////////////////////////////////
    //ModelMapper
    //Entity --> Dto
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    //Dto --> Entity
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
