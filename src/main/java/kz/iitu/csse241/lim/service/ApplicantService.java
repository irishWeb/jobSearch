package kz.iitu.csse241.lim.service;

import kz.iitu.csse241.lim.model.Applicant;
import kz.iitu.csse241.lim.repository.ApplicantJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantJdbcRepository applicantJdbcRepository;

    @Autowired
    public ApplicantService(ApplicantJdbcRepository applicantJdbcRepository) {
        this.applicantJdbcRepository = applicantJdbcRepository;
    }

    public List<Applicant> getAllApplicants() {
        return applicantJdbcRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantJdbcRepository.findById(id);
    }


    public int insertApplicant(Applicant applicant) {
        return applicantJdbcRepository.insert(applicant);
    }

    public int[] insertApplicantsBatch(List<Applicant> applicants) {
        return applicantJdbcRepository.insertListOfApplicants(applicants);
    }


    public List<Applicant> findApplicantsByName(String namePart) {
        return applicantJdbcRepository.findByFirstNameContaining(namePart);
    }

    public int countAllApplicants() {
        return applicantJdbcRepository.countApplicants();
    }

    public List<Applicant> findApplicantsWithPhone() {
        return applicantJdbcRepository.findApplicantsWithPhone();
    }

    public List<Applicant> findApplicantsWithResumes() {
        return applicantJdbcRepository.findApplicantsWithResumes();
    }
}
