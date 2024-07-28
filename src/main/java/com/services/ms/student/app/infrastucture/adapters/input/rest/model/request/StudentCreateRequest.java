package com.services.ms.student.app.infrastucture.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    @NotBlank(message = "Field firstname cannot be empty or null")
    private String firstname;
    @NotBlank(message = "Field firstname cannot be empty or null")
    private String lastname;
    @NotNull(message = "Field age cannot be null ")
    private Integer age;
    @NotBlank(message = "Field firstname cannot be empty or null")
    private String address;
}
