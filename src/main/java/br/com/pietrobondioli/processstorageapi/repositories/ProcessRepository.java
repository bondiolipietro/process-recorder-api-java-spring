package br.com.pietrobondioli.processstorageapi.repositories;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;

import java.sql.Date;
import java.util.List;

public interface ProcessRepository {

    List<Process> fetchAll();

    Process findById(Integer processId) throws PsResourceNotFoundException;

    Integer create(Process process) throws PsBadRequestException;

    void update(Integer processId, Process process) throws PsBadRequestException;

    void delete(Integer processId) throws PsResourceNotFoundException;

}
