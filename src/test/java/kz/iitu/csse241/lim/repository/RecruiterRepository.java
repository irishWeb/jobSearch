package kz.iitu.csse241.lim.repository;

import  kz.iitu.csse241.lim.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    //JPA
    @Query("SELECT a FROM Recruiter a WHERE a.company =:companyName")
    List<Recruiter> findByCompany(@Param("companyName") String companyName);
}