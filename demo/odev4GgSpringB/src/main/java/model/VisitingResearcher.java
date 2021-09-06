package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="visiting_researchers")
@Builder
public class VisitingResearcher extends model.User {

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="hourly_salary")
    private int hourlySalary;

    @OneToMany(mappedBy = "visitingResearcher")
    private List<Course> courseList=new ArrayList<>();
}
