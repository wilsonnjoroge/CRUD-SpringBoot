package com.example.Wilson3.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Wilson = new Student(
                    1L,
                    "Wilson wanderi",
                    "wilsonnjoroge@gmail.com",
                    LocalDate.of(1990, Month.AUGUST,12),
                    21
            );
            Student Dennis = new Student(
                    "Dennis Wainaina",
                    "dennis@gmail.com",
                    LocalDate.of(1970, Month.AUGUST,12),
                    21
            );

            repository.saveAll(
                    List.of(Wilson,Dennis)
            );
        };


    }

}
