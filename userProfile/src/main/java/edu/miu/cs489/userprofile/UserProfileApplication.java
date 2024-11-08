package edu.miu.cs489.userprofile;

import edu.miu.cs489.userprofile.dto.request.ProfileRequestDTO;
import edu.miu.cs489.userprofile.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class UserProfileApplication {

    private final UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(UserProfileApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

            // Create ProfileRequestDTO
            ProfileRequestDTO profileRequestDTO =
                    new ProfileRequestDTO(
                            "I am ...",
                            "Draper",
                            LocalDate.of(2018, 9, 20)


            );
            // Create UserRequestDTO
            UserRequestDTO userRequestDTO =
                    new UserRequestDTO(
                            "alvron",
                            "123",
                            profileRequestDTO
                    );

            // Save the user Object by using UserRequestDTO
            System.out.println("New user: " + userService.createUser(userRequestDTO) + "is created successfully");
        };
    }

}
