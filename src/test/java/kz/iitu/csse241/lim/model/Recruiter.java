package kz.iitu.csse241.lim.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recruiters")
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String company;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<Vacancy> vacancies;
}
