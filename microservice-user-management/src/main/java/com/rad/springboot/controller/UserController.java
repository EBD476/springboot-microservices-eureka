package com.rad.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rad.springboot.model.User;
import com.rad.springboot.service.UserService;


@RestController
//@RequestMapping("/api/v1/users")
@RequestMapping("/service")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoverClient;

    @Autowired
    private Environment env;

    @Value("${spring.application.name}")
    private String serviceId;

    @GetMapping("/port")
    public String getPort() {
        return "Servie port number : " + env.getProperty("local.server.port");
    }

    @GetMapping("/instances")
    public ResponseEntity<?> getInstances() {
        return new ResponseEntity<>(discoverClient.getInstances(serviceId),HttpStatus.OK);        
    }


    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        return new ResponseEntity<>(discoverClient.getServices(),HttpStatus.OK);        
    }


    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.findAll();
    }
    
    @PostMapping()
    public String saveUser(@RequestBody User user){
        userService.save(user);
        
        return "Added Successfully";
    }

    @DeleteMapping
    public String deleteUser(@PathVariable Long id){

        userService.deleteById(id);
        return "Deleted Successfully";
    }

}
