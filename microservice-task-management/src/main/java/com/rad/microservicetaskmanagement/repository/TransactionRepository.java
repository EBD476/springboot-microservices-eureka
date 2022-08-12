package com.rad.microservicetaskmanagement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rad.microservicetaskmanagement.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

    
    List<Transaction> findAllByUserId(Long userId);

    List<Transaction> findAllByTaskId(Long taskId);    
    
}
