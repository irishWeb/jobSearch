package kz.iitu.csse241.lim.repository;

import kz.iitu.csse241.lim.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;


import java.sql.SQLException;
import java.util.List;

@Repository
public class ApplicantJdbcRepository {

    private final JdbcTemplate jdbcTemplate;



    @Autowired
    public ApplicantJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int[] insertListOfApplicants(List<Applicant> applicants) {
        String sql = "INSERT INTO applicants (user_id, first_name, last_name, phone) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
                Applicant applicant = applicants.get(i);
                ps.setLong(1, applicant.getUserId());
                ps.setString(2, applicant.getFirstName());
                ps.setString(3, applicant.getLastName());
                ps.setString(4, applicant.getPhone());
            }

            @Override
            public int getBatchSize() {
                return applicants.size();
            }
        });
    }

    public List<Applicant> findAll() {
        String sql = "SELECT user_id, first_name, last_name, phone FROM public.applicants";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Applicant(
                        rs.getLong("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone")
                )
        );
    }

    public Applicant findById(Long userId) {
        String sql = "SELECT user_id, first_name, last_name, phone FROM applicants WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) ->
                new Applicant(
                        rs.getLong("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone")
                )
        );
    }

    public int insert(Applicant applicant) {
        String sql = "INSERT INTO applicants (user_id, first_name, last_name, phone) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                applicant.getUserId(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getPhone()
        );
    }

    public List<Applicant> findByFirstNameContaining(String namePart) {
        String sql = "SELECT user_id, first_name, last_name, phone FROM applicants WHERE first_name ILIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + namePart + "%"}, (rs, rowNum) ->
                new Applicant(
                        rs.getLong("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone")
                )
        );
    }

    public int countApplicants() {
        String sql = "SELECT COUNT(*) FROM applicants";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Applicant> findApplicantsWithResumes() {
        String sql = "SELECT DISTINCT a.user_id, a.first_name, a.last_name, a.phone " +
                "FROM applicants a " +
                "JOIN resumes r ON a.user_id = r.applicant_id";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Applicant(
                        rs.getLong("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone")
                )
        );
    }


    public List<Applicant> findApplicantsWithPhone() {
        String sql = "SELECT user_id, first_name, last_name, phone FROM applicants WHERE phone IS NOT NULL";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Applicant(
                        rs.getLong("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone")
                )
        );
    }
}
