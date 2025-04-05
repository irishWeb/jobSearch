package kz.iitu.csse241.lim.service;

import  kz.iitu.csse241.lim.model.Recruiter;
import  kz.iitu.csse241.lim.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {


    @Autowired
    private RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }


    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }


    public Optional<Recruiter> getRecruiterById(Long id) {
        return recruiterRepository.findById(id);
    }


    public Recruiter saveRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }


    public void deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
    }


    public List<Recruiter> findRecruitersByCompany(String company) {
        return recruiterRepository.findByCompany(company);
    }
}