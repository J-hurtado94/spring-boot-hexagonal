package com.services.ms.student.app.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;
}