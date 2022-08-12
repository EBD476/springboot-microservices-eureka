package com.rad.microservicetaskmanagement.service;

import java.util.List;

import com.rad.microservicetaskmanagement.model.Task;
import com.rad.microservicetaskmanagement.model.Transaction;

public interface TaskService {
    
    public List<Task> allTasks();

    public Task findTaskById(Long taskId);

    public List<Transaction> findTransactionsOfUser(Long userId);

    public List<Transaction> findTransactionsOfTask(Long taskId);

    public Transaction saveTransaction(Transaction transaction);


}
