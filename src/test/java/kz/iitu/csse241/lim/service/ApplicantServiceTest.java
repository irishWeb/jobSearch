package kz.iitu.csse241.lim.service;

import kz.iitu.csse241.lim.model.Applicant;
import kz.iitu.csse241.lim.repository.ApplicantJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicantServiceTest {

    @Mock
    private ApplicantJdbcRepository applicantJdbcRepository;

    @InjectMocks
    private ApplicantService applicantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllApplicants() {
        Applicant applicant = new Applicant(1L, "John", "Doe", "123-456-7890");
        when(applicantJdbcRepository.findAll()).thenReturn(Collections.singletonList(applicant));

        List<Applicant> applicants = applicantService.getAllApplicants();

        assertEquals(1, applicants.size());
        assertEquals("John", applicants.get(0).getFirstName());
    }

    @Test
    void testGetApplicantById() {
        Applicant applicant = new Applicant(1L, "John", "Doe", "123-456-7890");
        when(applicantJdbcRepository.findById(1L)).thenReturn(applicant);

        Applicant result = applicantService.getApplicantById(1L);

        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }

    @Test
    void testInsertApplicant() {
        Applicant applicant = new Applicant(1L, "Alice", "Johnson", "999-888-7777");
        when(applicantJdbcRepository.insert(applicant)).thenReturn(1);

        int result = applicantService.insertApplicant(applicant);

        assertEquals(1, result);
    }

    @Test
    void testInsertListOfApplicants() {
        Applicant applicant1 = new Applicant(2L, "Bob", "Williams", "111-222-3333");
        Applicant applicant2 = new Applicant(3L, "Carol", "Smith", "444-555-6666");
        List<Applicant> applicants = Arrays.asList(applicant1, applicant2);

        when(applicantJdbcRepository.insertListOfApplicants(applicants)).thenReturn(new int[]{1, 1});

        int[] results = applicantService.insertApplicantsBatch(applicants);

        assertEquals(2, results.length);
    }

    @Test
    void testFindByFirstNameContaining() {
        Applicant applicant = new Applicant(1L, "Johnny", "Walker", "321-654-9870");
        when(applicantJdbcRepository.findByFirstNameContaining("John")).thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantService.findApplicantsByName("John");

        assertEquals(1, result.size());
        assertTrue(result.get(0).getFirstName().contains("John"));
    }

    @Test
    void testCountApplicants() {
        when(applicantJdbcRepository.countApplicants()).thenReturn(5);

        int count = applicantService.countAllApplicants();

        assertEquals(5, count);
    }

    @Test
    void testFindApplicantsWithPhone() {
        Applicant applicant = new Applicant(1L, "Mike", "Tyson", "222-333-4444");
        when(applicantJdbcRepository.findApplicantsWithPhone()).thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantService.findApplicantsWithPhone();

        assertEquals(1, result.size());
        assertNotNull(result.get(0).getPhone());
    }

    @Test
    void testFindApplicantsWithResumes() {
        Applicant applicant = new Applicant(1L, "Lara", "Croft", "555-666-7777");
        when(applicantJdbcRepository.findApplicantsWithResumes()).thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantService.findApplicantsWithResumes();

        assertEquals(1, result.size());
    }
}
