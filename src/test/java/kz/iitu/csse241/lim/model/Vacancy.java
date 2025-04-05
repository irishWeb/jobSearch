package kz.iitu.csse241.lim.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // Название вакансии, например, "Java Developer"

    @Column(columnDefinition = "TEXT")
    private String description; // Описание вакансии

    private LocalDate createdAt; // Дата создания вакансии

    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    private Recruiter recruiter; // Связь с рекрутером

    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.ALL)
    private List<Application> applications; // Заявки на данную вакансию
}
