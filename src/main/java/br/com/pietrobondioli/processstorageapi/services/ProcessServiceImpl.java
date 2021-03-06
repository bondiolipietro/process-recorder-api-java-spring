package br.com.pietrobondioli.processstorageapi.services;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;
import br.com.pietrobondioli.processstorageapi.repositories.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessRepository processRepository;

    @Override
    public List<Process> fetchAllProcesses() {
        return processRepository.fetchAll();
    }

    @Override
    public Process fetchProcessById(Integer processId) throws PsResourceNotFoundException {
        return processRepository.findById(processId);
    }

    @Override
    public Integer createProcess(Process process) throws PsBadRequestException, ParseException {
        return processRepository.create(process);
    }

    @Override
    public void updateProcess(Integer processId, Process process) throws PsBadRequestException {
        processRepository.update(processId, process);
    }

    @Override
    public void deleteProcess(Integer processId) throws PsResourceNotFoundException {
        processRepository.delete(processId);
    }

}
