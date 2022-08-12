package com.rad.microservicetaskmanagement.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.rad.microservicetaskmanagement.intercomm.UserClient;
import com.rad.microservicetaskmanagement.model.Transaction;
import com.rad.microservicetaskmanagement.service.TaskService;

@RestController
public class TaskController {
    
    @Autowired
    private UserClient userClient;

    @Autowired
    private TaskService taskService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment env;

    @Value("{spring.application.name}")
    private String serviceId;

    @GetMapping("/service/port")
    public String getPort() {        
        return "Service is working at port : " + env.getProperty("local.server.port");
    }

    @GetMapping("/service/instances")
    public ResponseEntity<?> getInstances() {
        return new ResponseEntity<>(discoveryClient.getInstances(serviceId),HttpStatus.OK);        
    }

    @RequestMapping("/service/user/{userId}")
    public ResponseEntity<?> findTransactionOfUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.findTransactionsOfUser(userId));
    }

    @RequestMapping("/service/all")
    public ResponseEntity<?> findAllTasks() {
        return ResponseEntity.ok(taskService.allTasks());                
    }

    @RequestMapping("/service/enroll")
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {
        transaction.setDateOfIssue(LocalDateTime.now());
        transaction.setTask(taskService.findTaskById(transaction.getTask().getId()));
        return new ResponseEntity<>(taskService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @RequestMapping("/service/task/{taskId}")
    public ResponseEntity<?> findNamesOfTask(@PathVariable Long taskId) {
        List<Transaction> transactions = taskService.findTransactionsOfTask(taskId);
        if (CollectionUtils.isEmpty(transactions)){
            return ResponseEntity.notFound().build();
        }

        List<Long> userIdList = transactions.parallelStream().map(t-> t.getUserId()).collect(Collectors.toList());
        List<String> taskNames = userClient.getUserNames(userIdList);
        return ResponseEntity.ok(taskNames);
        
    }


}
