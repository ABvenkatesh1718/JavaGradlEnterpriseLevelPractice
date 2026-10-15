package com.venkatesh.enterpriselevelpractice;

import com.venkatesh.enterpriselevelpractice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnterpriseLevelPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseLevelPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            userRepository.findByGmail("admin@enterprise.com").ifPresent(user -> {
                System.out.println(">>> User ID: " + user.getId());
                System.out.println(">>> Gmail:   " + user.getGmail());
                System.out.println(">>> Active:  " + user.getIsActive());
            });
        };
    }
}
