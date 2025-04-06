package kz.iitu.csse241.lim.service;


import kz.iitu.csse241.lim.model.Application;
import kz.iitu.csse241.lim.repository.ApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllApplications() {
        List<Application> mockList = List.of(new Application(), new Application());
        when(applicationRepository.findAll()).thenReturn(mockList);

        List<Application> result = applicationService.getAllApplications();

        assertEquals(2, result.size());
        verify(applicationRepository, times(1)).findAll();
    }

    @Test
    void testGetApplicationById() {
        Application application = new Application();
        application.setId(1L);
        when(applicationRepository.findById(1L)).thenReturn(Optional.of(application));

        Optional<Application> result = applicationService.getApplicationById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(applicationRepository).findById(1L);
    }

    @Test
    void testSaveApplication() {
        Application application = new Application();
        when(applicationRepository.save(application)).thenReturn(application);

        Application result = applicationService.saveApplication(application);

        assertEquals(application, result);
        verify(applicationRepository).save(application);
    }

    @Test
    void testDeleteApplication() {
        Long id = 1L;
/// ///
        applicationService.deleteApplication(id);

        verify(applicationRepository).deleteById(id);
    }

    @Test
    void testGetApplicationsByApplicantId() {
        Long applicantId = 5L;
        List<Application> applications = List.of(new Application());
        when(applicationRepository.findByApplicantId(applicantId)).thenReturn(applications);

        List<Application> result = applicationService.getApplicationsByApplicantId(applicantId);

        assertEquals(1, result.size());
        verify(applicationRepository).findByApplicantId(applicantId);
    }
}
