package com.practice.database.jdbcJPA;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.database.jdbcJPA.entity.Person;
import com.practice.database.jdbcJPA.jdbc.PersonJdbcDAO;
import com.practice.database.jdbcJPA.jpa.PersonJpaRepository;



@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("---ALl users----> {}"+repo.findAll());
		
		logger.info("Find By Id 10001 ----->{}"+repo.findById(10001));
//		logger.info("Delete 10007 ---"+dao.deleteById(10002));
		logger.info("Inserting 10005 ---> {}",repo.insert(new Person("Tara","Berlin",new Date())));
		logger.info("Update 10003 ---> {}",
				repo.update(new Person(10003,"Peter","Berlin",new Date()))) ;
        //logger.info("---ALl users----> {}"+dao.findAllByPersonMapper() );
		
		repo.deleteById(10001);
	}

}
