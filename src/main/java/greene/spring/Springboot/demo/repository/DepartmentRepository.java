package greene.spring.Springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import greene.spring.Springboot.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
