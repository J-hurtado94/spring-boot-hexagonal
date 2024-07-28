package com.services.ms.student.app.application.usecases;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.exception.StudenNotFoundException;
import com.services.ms.student.app.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentCase implements StudentServicePort {

    private final StudentPersistencePort studentPersistencePort;


    @Override
    public Student findById(Long id) {
        return studentPersistencePort.findById(id).orElseThrow(StudenNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return studentPersistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentPersistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return studentPersistencePort.findById(id)
                .map(studentSaved ->{
                    studentSaved.setFirstname(student.getFirstname());
                    studentSaved.setLastname(student.getLastname());
                    studentSaved.setAge(student.getAge());
                    studentSaved.setAddress(student.getAddress());

                    return studentPersistencePort.save(studentSaved);

                })
                .orElseThrow(StudenNotFoundException::new);

    }

    @Override
    public void deleteById(Long id) {
        if (studentPersistencePort.findById(id).isEmpty()){
            throw new StudenNotFoundException();
        }
        studentPersistencePort.deleteById(id);

    }
}
