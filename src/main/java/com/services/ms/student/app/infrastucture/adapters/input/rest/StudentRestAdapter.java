package com.services.ms.student.app.infrastucture.adapters.input.rest;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.infrastucture.adapters.input.rest.mapper.StudentRestMapper;
import com.services.ms.student.app.infrastucture.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastucture.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestAdapter {

    private final StudentServicePort studentServicePort;
    private final StudentRestMapper studentRestMapper;


    @GetMapping("/v1/api")

    public List<StudentResponse> findAll(){
        return studentRestMapper.toStudentResponseList(studentServicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")

    public StudentResponse findById(@PathVariable Long id){
        return studentRestMapper.toStudentResponse(studentServicePort.findById(id));
    }

    @PostMapping("/v1/api/")


    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentRestMapper.
                        toStudentResponse(studentServicePort.save(studentRestMapper.toStudent(studentCreateRequest))));

    }
    @PostMapping("/v1/api/{id}")


    public StudentResponse update(@PathVariable Long id,@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        return studentRestMapper.
                        toStudentResponse(
                                studentServicePort.update(
                                        id,studentRestMapper.toStudent(studentCreateRequest)));

    }

    @DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id){
        studentServicePort.deleteById(id);

    }

}
