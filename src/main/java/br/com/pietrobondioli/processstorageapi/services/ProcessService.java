package br.com.pietrobondioli.processstorageapi.services;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;

import java.text.ParseException;
import java.util.List;

public interface ProcessService {

    List<Process> fetchAllProcesses();

    Process fetchProcessById(Integer processId) throws PsResourceNotFoundException;

    Process createProcess(String firstName,
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
                          String notes) throws PsBadRequestException, ParseException;

    void updateProcess(Integer processId,
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
                       String notes) throws PsBadRequestException;

    void deleteProcess(Integer processId) throws PsResourceNotFoundException;

}
