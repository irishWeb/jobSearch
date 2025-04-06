package kz.iitu.csse241.lim.service;


import kz.iitu.csse241.lim.model.Resume;
import kz.iitu.csse241.lim.repository.ResumeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResumeServiceTest {

    @Mock
    private ResumeRepository resumeRepository;

    @InjectMocks
    private ResumeService resumeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllResumes() {
        List<Resume> mockResumes = List.of(new Resume(), new Resume());
        when(resumeRepository.findAll()).thenReturn(mockResumes);

        List<Resume> result = resumeService.getAllResumes();

        assertEquals(2, result.size());
        verify(resumeRepository).findAll();
    }

    @Test
    void testGetResumeById() {
        Resume resume = new Resume();
        resume.setId(1L);
        when(resumeRepository.findById(1L)).thenReturn(Optional.of(resume));

        Optional<Resume> result = resumeService.getResumeById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(resumeRepository).findById(1L);
    }

    @Test
    void testSaveResume() {
        Resume resume = new Resume();
        resume.setTitle("Java Developer");
        when(resumeRepository.save(resume)).thenReturn(resume);

        Resume result = resumeService.saveResume(resume);

        assertEquals("Java Developer", result.getTitle());
        verify(resumeRepository).save(resume);
    }

    @Test
    void testDeleteResume() {
        Long id = 42L;

        resumeService.deleteResume(id);

        verify(resumeRepository).deleteById(id);
    }
}
