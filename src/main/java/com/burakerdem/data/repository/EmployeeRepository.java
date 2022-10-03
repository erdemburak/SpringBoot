package com.burakerdem.data.repository;

import com.burakerdem.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository > CrudRepository
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
