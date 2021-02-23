package ru.otus.spring.homework.spring03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;
import ru.otus.spring.homework.spring03.service.PersonTestServiceImpl;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class MainApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(MainApplication.class, args);
		var personTestService = context.getBean(PersonTestServiceImpl.class);
		// Run test
		personTestService.runTest();
	}

}
