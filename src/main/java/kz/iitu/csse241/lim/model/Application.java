package kz.iitu.csse241.lim.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate applicationDate; // Дата подачи заявки

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant; // Соискатель, подавший заявку

    @ManyToOne
    @JoinColumn(name = "vacancy_id", nullable = false)
    private Vacancy vacancy; // Вакансия, на которую подана заявка
}
