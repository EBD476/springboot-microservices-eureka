package com.rad.microservicetaskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rad.microservicetaskmanagement.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
    
}
