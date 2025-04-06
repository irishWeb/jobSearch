package kz.iitu.csse241.lim.service;


import kz.iitu.csse241.lim.model.Vacancy;
import kz.iitu.csse241.lim.repository.VacancyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VacancyServiceTest {

    @Mock
    private VacancyRepository vacancyRepository;

    @InjectMocks
    private VacancyService vacancyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVacancies() {
        List<Vacancy> vacancies = List.of(new Vacancy(), new Vacancy());
        when(vacancyRepository.findAll()).thenReturn(vacancies);

        List<Vacancy> result = vacancyService.getAllVacancies();

        assertEquals(2, result.size());
        verify(vacancyRepository).findAll();
    }

    @Test
    void testGetVacancyById() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        when(vacancyRepository.findById(1L)).thenReturn(Optional.of(vacancy));

        Optional<Vacancy> result = vacancyService.getVacancyById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(vacancyRepository).findById(1L);
    }

    @Test
    void testSaveVacancy() {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle("Backend Developer");
        when(vacancyRepository.save(vacancy)).thenReturn(vacancy);

        Vacancy result = vacancyService.saveVacancy(vacancy);

        assertEquals("Backend Developer", result.getTitle());
        verify(vacancyRepository).save(vacancy);
    }

    @Test
    void testDeleteVacancy() {
        Long id = 100L;

        vacancyService.deleteVacancy(id);

        verify(vacancyRepository).deleteById(id);
    }

    @Test
    void testGetVacanciesByRecruiterId() {
        Long recruiterId = 10L;
        List<Vacancy> vacancies = List.of(new Vacancy(), new Vacancy());
        when(vacancyRepository.findByRecruiterId(recruiterId)).thenReturn(vacancies);

        List<Vacancy> result = vacancyService.getVacanciesByRecruiterId(recruiterId);

        assertEquals(2, result.size());
        verify(vacancyRepository).findByRecruiterId(recruiterId);
    }
}

