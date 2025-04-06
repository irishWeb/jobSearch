package kz.iitu.csse241.lim.service;


import kz.iitu.csse241.lim.model.Recruiter;
import kz.iitu.csse241.lim.repository.RecruiterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecruiterServiceTest {

    @Mock
    private RecruiterRepository recruiterRepository;

    @InjectMocks
    private RecruiterService recruiterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRecruiters() {
        List<Recruiter> mockRecruiters = List.of(new Recruiter(), new Recruiter());
        when(recruiterRepository.findAll()).thenReturn(mockRecruiters);

        List<Recruiter> result = recruiterService.getAllRecruiters();

        assertEquals(2, result.size());
        verify(recruiterRepository).findAll();
    }

    @Test
    void testGetRecruiterById() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(1L);
        when(recruiterRepository.findById(1L)).thenReturn(Optional.of(recruiter));

        Optional<Recruiter> result = recruiterService.getRecruiterById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(recruiterRepository).findById(1L);
    }

    @Test
    void testSaveRecruiter() {
        Recruiter recruiter = new Recruiter();
        recruiter.setName("Alice");
        when(recruiterRepository.save(recruiter)).thenReturn(recruiter);

        Recruiter result = recruiterService.saveRecruiter(recruiter);

        assertEquals("Alice", result.getName());
        verify(recruiterRepository).save(recruiter);
    }

    @Test
    void testDeleteRecruiter() {
        Long id = 10L;

        recruiterService.deleteRecruiter(id);

        verify(recruiterRepository).deleteById(id);
    }

    @Test
    void testFindRecruitersByCompany() {
        String company = "TechCorp";
        List<Recruiter> recruiters = List.of(new Recruiter());
        when(recruiterRepository.findByCompany(company)).thenReturn(recruiters);

        List<Recruiter> result = recruiterService.findRecruitersByCompany(company);

        assertEquals(1, result.size());
        verify(recruiterRepository).findByCompany(company);
    }
}

