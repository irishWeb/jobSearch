/*package kz.iitu.csse241.lim.repository;

import kz.iitu.csse241.lim.model.Applicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicantJdbcRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ApplicantJdbcRepository applicantJdbcRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Applicant applicant = new Applicant(1L, "John", "Doe", "123-456-7890");
        when(jdbcTemplate.query(anyString(), any()))
                .thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantJdbcRepository.findAll();

        assertEquals(1, result.size());
        verify(jdbcTemplate, times(1)).query(anyString(), any());
    }

    @Test
    void testFindById() {
        Applicant applicant = new Applicant(1L, "John", "Doe", "123-456-7890");
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any()))
                .thenReturn(applicant);

        Applicant result = applicantJdbcRepository.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
    }

    @Test
    void testInsert() {
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any()))
                .thenReturn(1);

        Applicant applicant = new Applicant(1L, "Jane", "Smith", "987-654-3210");
        int inserted = applicantJdbcRepository.insert(applicant);

        assertEquals(1, inserted);
    }

    @Test
    void testInsertListOfApplicants() {
        when(jdbcTemplate.batchUpdate(anyString(), any(BatchPreparedStatementSetter.class)))
                .thenReturn(new int[]{1, 1});

        Applicant a1 = new Applicant(2L, "Batch1", "User1", "111-222-3333");
        Applicant a2 = new Applicant(3L, "Batch2", "User2", "444-555-6666");

        int[] results = applicantJdbcRepository.insertListOfApplicants(Arrays.asList(a1, a2));

        assertEquals(2, results.length);
    }

    @Test
    void testFindByFirstNameContaining() {
        Applicant applicant = new Applicant(4L, "Johanna", "Doe", "222-333-4444");
        when(jdbcTemplate.query(anyString(), any(Object[].class), any()))
                .thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantJdbcRepository.findByFirstNameContaining("Joh");

        assertEquals(1, result.size());
    }

    @Test
    void testCountApplicants() {
        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class)))
                .thenReturn(5);

        int count = applicantJdbcRepository.countApplicants();

        assertEquals(5, count);
    }

    @Test
    void testFindApplicantsWithPhone() {
        Applicant applicant = new Applicant(5L, "Mark", "Twain", "777-888-9999");
        when(jdbcTemplate.query(anyString(), any()))
                .thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantJdbcRepository.findApplicantsWithPhone();

        assertEquals(1, result.size());
    }

    @Test
    void testFindApplicantsWithResumes() {
        Applicant applicant = new Applicant(6L, "Anna", "Taylor", "333-444-5555");
        when(jdbcTemplate.query(anyString(), any()))
                .thenReturn(Collections.singletonList(applicant));

        List<Applicant> result = applicantJdbcRepository.findApplicantsWithResumes();

        assertEquals(1, result.size());
    }
}*/
