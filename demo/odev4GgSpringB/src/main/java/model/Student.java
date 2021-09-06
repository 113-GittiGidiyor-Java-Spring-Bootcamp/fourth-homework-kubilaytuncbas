package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Builder
public class Student extends User {

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="gender")
    private String Gender;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Course> studentCourses = new HashSet<>();
}
