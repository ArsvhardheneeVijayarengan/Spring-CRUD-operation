package it.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.company.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value= "SELECT * FROM Employee e WHERE lower(e.emp_name) LIKE %:name%", nativeQuery = true)
	 List<Employee> searchEmployeeNameLike(@Param("name") String str);
     }
