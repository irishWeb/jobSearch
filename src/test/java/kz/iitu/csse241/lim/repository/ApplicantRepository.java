package kz.iitu.csse241.lim.repository;

import kz.iitu.csse241.lim.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    //JPA



}