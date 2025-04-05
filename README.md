IITU Project for backend advanced web technologies The backend is implemented using Java and Spring Boot.

Tech Stack: Spring Boot, Hibernate (JPA), Gradl, PostgreSQL.

## Features

- User registration with roles: **Applicant** and **Recruiter**.
    
- **Applicants** can:
    
    - Create, update, and delete resumes.
        
    - Apply to job vacancies.
        
- **Recruiters** can:
    
    - Post, update, and delete job vacancies.
        
    - View applicant resumes to find suitable candidates.
        
    - Manage applications submitted to their vacancies.
        
- Management of resumes, job applications, and job vacancies.
    
- CRUD operations for all entities:
    
    - Users (`User`)
        
    - Applicants (`Applicant`)
        
    - Recruiters (`Recruiter`)
        
    - Vacancies (`Vacancy`)
        
    - Resumes (`Resume`)
        
    - Applications (`Application`)
        
- Relationships between entities: `One-to-Many` and `Many-to-One`.


## Clone repository from:

https://github.com/irishWeb/jobSearch.git


==After clone you need to connect database with project, database should be made in format coherent to the database diagram in project folder.==