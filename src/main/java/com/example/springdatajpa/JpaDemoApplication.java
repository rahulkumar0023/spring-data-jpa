package com.example.springdatajpa;

import com.example.springdatajpa.entity.Person;
import com.example.springdatajpa.jpa.PersonJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJPARepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        inserRecords();
        personRepository.findAll().stream().sorted((x,y) -> y.getId() - x.getId()).forEach(p -> System.out.println(p));

    }

    private void inserRecords() {
        logger.info("Create new Person -> {} " , personRepository.insert(new Person( "Rahul","Mumbai", new Date())));
        logger.info("Create new Person -> {} " , personRepository.insert(new Person( "James","USA", new Date())));
        logger.info("Create new Person -> {} " , personRepository.insert(new Person( "Robert","Belgium", new Date())));
        logger.info("Create new Person -> {} " , personRepository.insert(new Person( "Gary","UK", new Date())));
        logger.info("Update Person -> {} " , personRepository.insert(new Person( "Janmeet","Utretch", new Date())));
    }
}
