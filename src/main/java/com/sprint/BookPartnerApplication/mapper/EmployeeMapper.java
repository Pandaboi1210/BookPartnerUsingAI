package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.EmployeeDTO;
import com.sprint.BookPartnerApplication.entity.Employee;
import com.sprint.BookPartnerApplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    
    @Autowired
    private JobRepository jobRepository;
    
    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        return new EmployeeDTO(
            employee.getEmpId(),
            employee.getFname(),
            employee.getMinit(),
            employee.getLname(),
            employee.getJobLvl(),
            employee.getJob() != null ? employee.getJob().getJobId() : null,
            employee.getPubId(),
            employee.getHireDate()
        );
    }
    
    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setEmpId(dto.getEmpId());
        employee.setFname(dto.getFname());
        employee.setMinit(dto.getMinit());
        employee.setLname(dto.getLname());
        employee.setJobLvl(dto.getJobLvl());
        if (dto.getJobId() != null) {
            employee.setJob(jobRepository.findById(dto.getJobId()).orElse(null));
        }
        employee.setPubId(dto.getPubId());
        employee.setHireDate(dto.getHireDate());
        return employee;
    }
}
