package br.com.pietrobondioli.processstorageapi.resources;

import br.com.pietrobondioli.processstorageapi.domain.Process;
import br.com.pietrobondioli.processstorageapi.services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
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
    public ResponseEntity<Integer> createProcess(@RequestBody Process process) throws ParseException {
        Integer processId = processService.createProcess(process);

        return new ResponseEntity<>(processId, HttpStatus.CREATED);
    }

    @PutMapping("/update/{processId}")
    public ResponseEntity<Map<String, Boolean>> updateProcess(@PathVariable("processId") Integer processId,
                                                              @RequestBody Process process) {
        processService.updateProcess(processId, process);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{processId}")
    public ResponseEntity<Map<String, Boolean>> deleteProcess(@PathVariable("processId") Integer processId) {
        processService.deleteProcess(processId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
