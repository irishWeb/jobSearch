-- Вставляем пользователей
INSERT INTO users (email, password, role) VALUES
                                              ('applicant1@example.com', 'password1', 'APPLICANT'),
                                              ('applicant2@example.com', 'password2', 'APPLICANT'),
                                              ('recruiter1@example.com', 'password3', 'RECRUITER'),
                                              ('recruiter2@example.com', 'password4', 'RECRUITER');

-- Вставляем соискателей
INSERT INTO applicants (user_id, first_name, last_name, phone) VALUES
                                                                   (1, 'John', 'Doe', '123-456-7890'),
                                                                   (2, 'Jane', 'Smith', '987-654-3210');

-- Вставляем рекрутеров
INSERT INTO recruiters (user_id, company_name, website) VALUES
                                                            (3, 'TechCorp', 'https://techcorp.com'),
                                                            (4, 'BusinessInc', 'https://businessinc.com');

-- Вставляем резюме
INSERT INTO resumes (applicant_id, title, experience, skills) VALUES
                                                                  (1, 'Junior Developer', '1 year experience in Java', 'Java, Spring Boot, SQL'),
                                                                  (2, 'Data Analyst', '2 years experience in Data Analysis', 'Python, SQL, Data Visualization');

-- Вставляем вакансии
INSERT INTO vacancies (recruiter_id, title, description, salary, status) VALUES
                                                                             (3, 'Backend Developer', 'Work on backend APIs', 70000.00, 'OPEN'),
                                                                             (4, 'Data Scientist', 'Analyze business data', 80000.00, 'OPEN');

-- Вставляем отклики
INSERT INTO applications (resume_id, vacancy_id, status) VALUES
                                                             (1, 1, 'PENDING'),
                                                             (2, 2, 'PENDING');
