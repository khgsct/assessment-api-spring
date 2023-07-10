package com.gosoft.assessmentapi.user;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDbSeedRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UserDbSeedRunner.class);
    private final Faker faker = new Faker();
    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;
    private final UserPasswordService userPasswordService;

    public UserDbSeedRunner(UserRepository userRepository, JdbcTemplate jdbcTemplate, UserPasswordService userPasswordService) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.userPasswordService = userPasswordService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("executing : database seed runner");
        this.seedUsers();
        log.info("executed : database seed runner");
    }

    private void seedUsers(){
        var userTestMail = "kuankeehan@gosoft.co.th";
        if (!this.userRepository.findOptionalByEmail(userTestMail).isPresent()) {
            var userTest = new User();
            userTest.setEmail(userTestMail);
            userTest.setPassword(
                    this.userPasswordService.encode("1234")
            );
            userTest.setCreatedAt(LocalDateTime.now());
            userTest.setUpdatedAt(LocalDateTime.now());
            this.userRepository.save(userTest);
        }
    }
}
