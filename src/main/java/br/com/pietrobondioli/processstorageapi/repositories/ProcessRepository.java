package br.com.pietrobondioli.processstorageapi.repositories;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.exceptions.PsBadRequestException;
import br.com.pietrobondioli.processstorageapi.exceptions.PsResourceNotFoundException;

import java.sql.Date;
import java.util.List;

public interface ProcessRepository {

    List<Process> fetchAll();

    Process findById(Integer processId) throws PsResourceNotFoundException;

    Integer create(String firstName,
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
                       String notes) throws PsBadRequestException;

    void update(Integer processId,
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

    void delete(Integer processId) throws PsResourceNotFoundException;

}
