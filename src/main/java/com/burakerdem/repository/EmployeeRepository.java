package com.burakerdem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Jpareepository > CrudRepository
@Repository
public interface EmployeeRepository extends CrudRepository {
}