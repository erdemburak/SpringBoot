package com.burakerdem;

import com.burakerdem.data.entity.EmployeeEntity;
import com.burakerdem.data.repository.EmployeeRepository;
import com.burakerdem.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ApplicationTests implements TestCrud {

	@Autowired
	EmployeeRepository employeeRepository;


	@Test
	void contextLoads() {
	}

	// Create
	@Test
	@Override
	public void testCreate() {
		EmployeeEntity employeeEntity = EmployeeEntity.builder().firstName("Burak Test").lastName("Erdem Test").email("test@gmail.com").build();
		employeeRepository.save(employeeEntity);

		//nesne null ise assertionError hatasını göndersin
		assertNotNull(employeeRepository.findById(1L).get());
	}

	// List
	@Override
	public void testList() {
		List<EmployeeEntity> list = employeeRepository.findAll();

		// eğer 0 dan büyükse liste vardır.
		assertThat(list).size().isGreaterThan(0);
	}

	//Findbyid
	@Test
	@Override
	public void testFindById() {
		EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();

		// Burak Test adında kayıt var mı yok mu
		assertEquals("Burak Test", employeeEntity.getFirstName());
	}

	// Update
	@Test
	@Override
	public void testUpdate() {
		EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
		employeeEntity.setFirstName("Burak 12 Test");
		employeeRepository.save(employeeEntity);

		// eşit değilse yani update gerçekleştiyse bir sorun olmayacak eşitse exception fırlatacak
		assertNotEquals("Burak Test", employeeRepository.findById(1L).get().getFirstName());
	}

	//Delete
	@Test
	@Override
	public void testDelete() {
		employeeRepository.deleteById(1L);

		//is False
		assertThat(employeeRepository.existsById(1L)).isFalse();
	}
}
