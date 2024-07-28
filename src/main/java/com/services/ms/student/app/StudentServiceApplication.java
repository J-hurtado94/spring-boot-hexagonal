package com.services.ms.student.app;

import com.services.ms.student.app.infrastucture.adapters.output.persistence.entity.StudentEntity;
import com.services.ms.student.app.infrastucture.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentServiceApplication implements CommandLineRunner {
	private final StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity> entities = Arrays.asList(
				new StudentEntity(null,"Juan","Perez",28,"Calle 1"),
				new StudentEntity(null,"Daniela","Vasquez",29,"Calle 2"),
				new StudentEntity(null,"Isa","Hurtado",11,"Calle 3"),
				new StudentEntity(null,"Carlos","Hurtado",70,"Calle 3")
		);
		repository.saveAll(entities);
	}
}
