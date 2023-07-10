package greene.spring.Springboot.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greene.spring.Springboot.demo.entity.Department;
import greene.spring.Springboot.demo.error.DepartmentNotFoundException;
import greene.spring.Springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not found for id: " + departmentId);
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dept = departmentRepository.findById(departmentId).get();
       //check each field to see if it is null, if it is, then use the old value
        if(department.getDepartmentName() != null && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dept.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress())) {
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode())) {
            dept.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(dept);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);   
    }
    
}
