package com.example.clientapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> hobbies;
}
