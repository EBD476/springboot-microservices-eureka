package com.rad.microservicetaskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.microservicetaskmanagement.model.Task;
import com.rad.microservicetaskmanagement.model.Transaction;
import com.rad.microservicetaskmanagement.repository.TaskRepository;
import com.rad.microservicetaskmanagement.repository.TransactionRepository;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Task> allTasks() {

        return taskRepository.findAll();        
    }

    @Override
    public Task findTaskById(Long taskId){
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public List<Transaction> findTransactionsOfUser(Long userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    @Override
    public List<Transaction> findTransactionsOfTask(Long taskId) {    
        return  transactionRepository.findAllByTaskId(taskId);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    
    


}
