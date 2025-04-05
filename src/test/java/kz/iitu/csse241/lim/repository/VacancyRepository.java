package kz.iitu.csse241.lim.repository;


import kz.iitu.csse241.lim.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByRecruiterId(Long recruiterId);
}