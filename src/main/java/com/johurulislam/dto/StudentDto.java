package com.johurulislam.dto;

import com.johurulislam.model.Laptop;
import jakarta.persistence.ManyToMany;
import lombok.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {
    private Integer id;
    private String name;
    private String gender;
    @ManyToMany
    private List<Laptop> laptopList;
}
