package kz.iitu.csse241.lim.repository;

import kz.iitu.csse241.lim.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
 //JPA
}