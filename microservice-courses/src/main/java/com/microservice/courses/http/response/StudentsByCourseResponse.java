package com.microservice.courses.http.response;

import com.microservice.courses.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsByCourseResponse {

    private String course;
    private String teacher;
    private List<StudentDTO> studentDTOS;

}
