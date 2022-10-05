package com.burakerdem.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "Ad soyad alanı boş olamaz")
    @Size(min = 3, max = 255)
    private String teacherNameSurname;

    @NotEmpty(message = "Email alanı boş olamaz")
    @Email(message = "Email hatalı")
    private String teacherEmail;

    @NotEmpty(message = "Şifre alanı boş olamaz")
//    @Min(value = 8, message = "Minimum 8 karakter")
//    @Max(value = 16, message = "Minimum 16 karakter")
    @Size(min = 6, max = 15)
    private String teacherPassword;


}
