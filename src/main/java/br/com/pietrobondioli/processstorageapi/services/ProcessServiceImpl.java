package br.com.pietrobondioli.processstorageapi.services;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;
import br.com.pietrobondioli.processstorageapi.repositories.ProcessRepository;
import br.com.pietrobondioli.processstorageapi.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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
    public Process createProcess(String firstName,
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
                                 String notes) throws PsBadRequestException, ParseException {
        Date receiptIssueDateConverted = DataUtil.convertStringToSqlDate(receiptIssueDate);
        int processId = processRepository.create(firstName,
                                                  lastName,
                                                  cpf,
                                                  email,
                                                  folder,
                                                  receipt,
                                                  receiptIssueDateConverted,
                                                  address,
                                                  district,
                                                  city,
                                                  state,
                                                  country,
                                                  cep,
                                                  notes);
        return processRepository.findById(processId);
    }

    @Override
    public void updateProcess(Integer processId,
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
    public void deleteProcess(Integer processId) throws PsResourceNotFoundException {

    }

}
