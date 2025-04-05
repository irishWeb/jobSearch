package kz.iitu.csse241.lim.service;


import kz.iitu.csse241.lim.model.Applicant;
import kz.iitu.csse241.lim.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }


    public Optional<Applicant> getApplicantById(Long id) {
        return applicantRepository.findById(id);
    }


    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }


    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }
}
