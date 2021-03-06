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

import java.awt.event.WindowAdapter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

@Repository
public class ProcessRepositoryImpl implements ProcessRepository {

    private static final String SQL_CREATE = "INSERT INTO process(process_id, first_name, last_name, cpf, email, " +
            "folder, receipt, receipt_issue_date, address, district, city, state, country, cep, notes) " +
            "VALUES(NEXTVAL('process_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM process WHERE process_id = ?;";
    private static final String SQL_FETCH_ALL = "SELECT * FROM process ORDER BY receipt_issue_date DESC;";
    private static final String SQL_UPDATE = "UPDATE process SET first_name = ?, last_name = ?, " +
            "cpf = ?, email = ?, folder = ?, receipt = ?, receipt_issue_date = ?, address = ?, district = ?, " +
            "city = ?, state = ?, country = ?, cep = ?, notes = ? WHERE process_id = ?;";
    private static final String SQL_DELETE = "DELETE FROM process WHERE process_id = ?;";

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
    public Integer create(Process process) throws PsBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, process.getFirstName());
                ps.setString(2, process.getLastName());
                ps.setString(3, process.getCpf());
                ps.setString(4, process.getEmail());
                ps.setInt(5, process.getFolder());
                ps.setString(6, process.getReceipt());
                try {
                    ps.setDate(7, process.getReceiptIssueDate());
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                ps.setString(8, process.getAddress());
                ps.setString(9, process.getDistrict());
                ps.setString(10, process.getCity());
                ps.setString(11, process.getState());
                ps.setString(12, process.getCountry());
                ps.setString(13, process.getCep());
                ps.setString(14, process.getNotes());
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("process_id");
        }
        catch (Exception e) {
            throw new PsBadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer processId,
                       Process process) throws PsBadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, process.getFirstName(),
                                process.getLastName(),
                                process.getCpf(),
                                process.getEmail(),
                                process.getFolder(),
                                process.getReceipt(),
                                process.getReceiptIssueDate(),
                                process.getAddress(),
                                process.getDistrict(),
                                process.getCity(),
                                process.getState(),
                                process.getCountry(),
                                process.getCep(),
                                process.getNotes(),
                                processId);
        } catch (Exception e) {
            throw new PsBadRequestException("Invalid request");
        }
    }

    @Override
    public void delete(Integer processId) throws PsResourceNotFoundException {
        jdbcTemplate.update(SQL_DELETE, processId);
    }

    private final RowMapper<Process> processRowMapper = ((rs, rowNum) -> new Process(
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
    ));
}
