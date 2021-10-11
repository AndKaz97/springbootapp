package de.teclead.springbootapp;

import de.teclead.springbootapp.entity.User;
import de.teclead.springbootapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class SpringbootappApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public SpringbootappApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User(UUID.fromString("20354d7a-e4fe-47af-8ff6-187bca92f3f9"),
            "Bob", "Greenwood", "bob@greenwood.com");
        userRepository.save(user);
        User user2 = new User(UUID.fromString("caa8b54a-eb5e-4134-8ae2-a3946a428ec7"),
            "Andy", "Anderson", "andy@anderson.com");
        userRepository.save(user2);
        User user3 = new User(UUID.fromString("bd2cbad1-6ccf-48e3-bb92-bc9961bc011e"),
            "Mary", "Maryland", "mary@maryland.com");
        userRepository.save(user3);
        User user4 = new User(UUID.fromString("b11c9be1-b619-4ef5-be1b-a1cd9ef265b7"),
            "Mary", "Johnson", "mary@johnson.com");
        userRepository.save(user4);
    }
}
