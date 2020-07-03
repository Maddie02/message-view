package com;

import com.conroller.HelloApplication;
import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AccessMongoDBApp /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(AccessMongoDBApp.class, args);
    }
    /*
    @Autowired
    private UserRepo repository;



    @Override
    public void run(String... args) throws Exception {
        //repository.deleteAll();

        // save a couple of customers
        repository.save(new User("Alice", "123"));
        repository.save(new User("Bob", "345"));

        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println();
        //System.out.println(repository.findByUsername("Alice"));
        //System.out.println(repository.findByUsername("Smith"));


    }*/
}
