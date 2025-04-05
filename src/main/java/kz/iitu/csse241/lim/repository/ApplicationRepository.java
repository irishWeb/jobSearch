package kz.iitu.csse241.lim.repository;

import kz.iitu.csse241.lim.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    //JPA


    @Query("SELECT a FROM Application a WHERE a.applicant.id = :applicantId")
    List<Application> findByApplicantId(@Param("applicantId") Long applicantId);
}