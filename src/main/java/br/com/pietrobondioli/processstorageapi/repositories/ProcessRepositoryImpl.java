package br.com.pietrobondioli.processstorageapi.repositories;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProcessRepositoryImpl implements ProcessRepository {

    private static final String SQL_CREATE = "INSERT INTO process(process_id, first_name, last_name, cpf, email, " +
            "folder, receipt, receipt_issue_date, address, district, city, state, country, cep, notes) VALUES(NEXTVAL" +
            "('process_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM process WHERE process_id = ?;";
    private static final String SQL_FETCH_ALL = "SELECT * FROM process ORDER BY receipt_issue_date DESC;";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Process> fetchAll() throws PsResourceNotFoundException {
        try {
            return jdbcTemplate.query(SQL_FETCH_ALL, processRowMapper);
        } catch(Exception e) {
            throw new PsResourceNotFoundException("Process not found");
        }
    }

    @Override
    public Process findById(Integer processId) throws PsResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, processRowMapper, processId);
        } catch(Exception e) {
           throw new PsResourceNotFoundException("Process not found");
        }
    }

    @Override
    public Integer create(String firstName,
                          String lastName,
                          String cpf,
                          String email,
                          Integer folder,
                          String receipt,
                          Date receiptIssueDate,
                          String address,
                          String district,
                          String city,
                          String state,
                          String country,
                          String cep,
                          String notes) throws PsBadRequestException {
//        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, cpf);
                ps.setString(4, email);
                ps.setInt(5, folder);
                ps.setString(6, receipt);
                ps.setDate(7, receiptIssueDate);
                ps.setString(8, address);
                ps.setString(9, district);
                ps.setString(10, city);
                ps.setString(11, state);
                ps.setString(12, country);
                ps.setString(13, cep);
                ps.setString(14, notes);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("process_id");
//        }
//        catch (Exception e) {
//            throw new PsBadRequestException("Invalid request");
//        }
    }

    @Override
    public void update(Integer processId,
                       String firstName,
                       String lastName,
                       String cpf,
                       String email,
                       Integer folder,
                       String receipt,
                       String receiptIssueDate,
                       String address,
                       String district,
                       String city,
                       String state,
                       String country,
                       String cep,
                       String notes) throws PsBadRequestException {

    }

    @Override
    public void delete(Integer processId) throws PsResourceNotFoundException {

    }

    private final RowMapper<Process> processRowMapper = ((rs, rowNum) -> {
        return new Process(
                rs.getInt("process_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getInt("folder"),
                rs.getString("receipt"),
                rs.getString("receipt_issue_date"),
                rs.getString("address"),
                rs.getString("district"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("country"),
                rs.getString("cep"),
                rs.getString("notes")
        );
    });
}
