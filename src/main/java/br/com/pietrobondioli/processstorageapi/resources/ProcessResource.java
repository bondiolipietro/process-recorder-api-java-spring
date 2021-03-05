package br.com.pietrobondioli.processstorageapi.resources;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/processes")
public class ProcessResource {

    @Autowired
    ProcessService processService;

    @GetMapping("")
    public ResponseEntity<List<Process>> getAllProcesses() {
        List<Process> processes = processService.fetchAllProcesses();
        return new ResponseEntity<>(processes, HttpStatus.OK);
    }

    @GetMapping("/{processId}")
    public ResponseEntity<Process> getProcessById(@PathVariable("processId") Integer processId) {
        Process process = processService.fetchProcessById(processId);
        return new ResponseEntity<>(process, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Process> createProcess(@RequestBody Map<String, Object> processMap) throws ParseException {
        String firstName = (String) processMap.get("firstName");
        String lastName = (String) processMap.get("lastName");
        String cpf = (String) processMap.get("cpf");
        String email = (String) processMap.get("email");
        int folder = (Integer) processMap.get("folder");
        String receipt = (String) processMap.get("receipt");
        String receiptIssueDate = (String) processMap.get("receiptIssueDate");
        String address = (String) processMap.get("address");
        String district = (String) processMap.get("district");
        String city = (String) processMap.get("city");
        String state = (String) processMap.get("state");
        String country = (String) processMap.get("country");
        String cep = (String) processMap.get("cep");
        String notes = (String) processMap.get("notes");

        Process process = processService.createProcess(firstName,
                                                       lastName,
                                                       cpf,
                                                       email,
                                                       folder,
                                                       receipt,
                                                       receiptIssueDate,
                                                       address,
                                                       district,
                                                       city,
                                                       state,
                                                       country,
                                                       cep,
                                                       notes);

        return new ResponseEntity<>(process, HttpStatus.CREATED);
    }
}
