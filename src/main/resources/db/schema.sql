
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) CHECK (role IN ('APPLICANT', 'RECRUITER')) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE applicants (
                            user_id BIGINT PRIMARY KEY,
                            first_name VARCHAR(100) NOT NULL,
                            last_name VARCHAR(100) NOT NULL,
                            phone VARCHAR(20),
                            FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE recruiters (
                            user_id BIGINT PRIMARY KEY,
                            company_name VARCHAR(255) NOT NULL,
                            website VARCHAR(255),
                            FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE resumes (
                         id BIGSERIAL PRIMARY KEY,
                         applicant_id BIGINT NOT NULL,
                         title VARCHAR(255) NOT NULL,
                         experience TEXT,
                         skills TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (applicant_id) REFERENCES applicants(user_id) ON DELETE CASCADE
);

CREATE TABLE vacancies (
                           id BIGSERIAL PRIMARY KEY,
                           recruiter_id BIGINT NOT NULL,
                           title VARCHAR(255) NOT NULL,
                           description TEXT,
                           salary NUMERIC(10, 2),
                           status VARCHAR(20) CHECK (status IN ('OPEN', 'CLOSED')) DEFAULT 'OPEN',
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (recruiter_id) REFERENCES recruiters(user_id) ON DELETE CASCADE
);

CREATE TABLE applications (
                              id BIGSERIAL PRIMARY KEY,
                              resume_id BIGINT NOT NULL,
                              vacancy_id BIGINT NOT NULL,
                              status VARCHAR(20) CHECK (status IN ('PENDING', 'REJECTED', 'ACCEPTED')) DEFAULT 'PENDING',
                              applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (resume_id) REFERENCES resumes(id) ON DELETE CASCADE,
                              FOREIGN KEY (vacancy_id) REFERENCES vacancies(id) ON DELETE CASCADE
);
