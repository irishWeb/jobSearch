package kz.iitu.csse241.lim.service;



import org.springframework.cache.annotation.Cacheable;
import kz.iitu.csse241.lim.model.Vacancy;
import kz.iitu.csse241.lim.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Cacheable("vacancies")
    public List<Vacancy> getAllVacancies() {
        System.out.println(">>> Fetching vacancies from DB...");
        return vacancyRepository.findAll();
    }


    public Optional<Vacancy> getVacancyById(Long id) {
        return vacancyRepository.findById(id);
    }

    public Vacancy saveVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }

    public List<Vacancy> getVacanciesByRecruiterId(Long recruiterId) {
        return vacancyRepository.findByRecruiterId(recruiterId);
    }
}
