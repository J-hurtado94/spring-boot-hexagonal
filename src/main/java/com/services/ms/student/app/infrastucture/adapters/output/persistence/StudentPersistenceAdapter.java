package com.services.ms.student.app.infrastucture.adapters.output.persistence;

import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infrastucture.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.services.ms.student.app.infrastucture.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor

public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper studentPersistenceMapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id).map(
                studentPersistenceMapper::toStudent

        );
    }

    @Override
    public List<Student> findAll() {
        return studentPersistenceMapper.toStudentList(studentRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return studentPersistenceMapper.toStudent(studentRepository.save(studentPersistenceMapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(long id) {
     studentRepository.deleteById(id);
    }
}
