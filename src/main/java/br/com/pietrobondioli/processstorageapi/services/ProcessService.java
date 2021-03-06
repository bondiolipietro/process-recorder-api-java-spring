package br.com.pietrobondioli.processstorageapi.services;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;

import java.text.ParseException;
import java.util.List;

public interface ProcessService {

    List<Process> fetchAllProcesses();

    Process fetchProcessById(Integer processId) throws PsResourceNotFoundException;

    Integer createProcess(Process process) throws PsBadRequestException, ParseException;

    void updateProcess(Integer processId,
                       Process process) throws PsBadRequestException;

    void deleteProcess(Integer processId) throws PsResourceNotFoundException;

}
