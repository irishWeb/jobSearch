package kz.iitu.csse241.lim.service;



import kz.iitu.csse241.lim.model.Applicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import kz.iitu.csse241.lim.repository.ApplicantRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



class ApplicantServiceTest {

    @Mock
    private ApplicantRepository applicantRepository;

    @InjectMocks
    private ApplicantService applicantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetApplicantById() {
        // Arrange
        Long id = 1L;
        Applicant applicant = new Applicant();
        applicant.setId(id);
        applicant.setName("John Doe");

        when(applicantRepository.findById(id)).thenReturn(Optional.of(applicant));

        // Act
        Optional<Applicant> result = applicantService.getApplicantById(id);

        // Assert
        assertEquals(applicant.getName(), result.get().getName());
        verify(applicantRepository, times(1)).findById(id);
    }
}
