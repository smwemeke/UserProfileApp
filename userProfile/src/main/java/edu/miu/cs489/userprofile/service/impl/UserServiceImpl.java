package edu.miu.cs489.userprofile.service.impl;

import edu.miu.cs489.userprofile.dto.request.ProfileRequestDTO;
import edu.miu.cs489.userprofile.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofile.dto.response.ProfileResponseDTO;
import edu.miu.cs489.userprofile.dto.response.UserResponseDTO;
import edu.miu.cs489.userprofile.model.Profile;
import edu.miu.cs489.userprofile.model.User;
import edu.miu.cs489.userprofile.repository.UserRepository;
import edu.miu.cs489.userprofile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<UserResponseDTO> createUser(UserRequestDTO userRequestDTO) {
        // Create user using data from UserRequestDTO
        User newUser = new User();
        newUser.setUsername(userRequestDTO.username());
        newUser.setPassword(userRequestDTO.password());
        // Create profile using data from ProfileRequestDTO
        Profile newProfile = new Profile();
        newProfile.setBio(userRequestDTO.profileRequestDTO().bio());
        newProfile.setLocation(userRequestDTO.profileRequestDTO().location());
        newProfile.setDob((userRequestDTO.profileRequestDTO().dob()));
        // Set profile in user
        newUser.setProfile(newProfile);
        // Save user
        User savedUser = userRepository.save(newUser);
        // Construct UserResponseDTO
        ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO(savedUser.getProfile().getBio(), savedUser.getProfile().getLocation());
        UserResponseDTO userResponseDTO = new UserResponseDTO(savedUser.getUsername(), profileResponseDTO);

        return Optional.of(userResponseDTO);
    }
    @Override
    public Optional<UserResponseDTO> getUserByUsername(String username) {
        Optional<User> foundUser= userRepository.findByUsername(username);
        if(foundUser.isPresent()){
            // create ProfileResponseDTO
            ProfileResponseDTO profileResponseDTO =
                    new ProfileResponseDTO(
                            foundUser.get().getProfile().getBio(),
                            foundUser.get().getProfile().getLocation()
                    );
            // Create UserResponseDTO
            UserResponseDTO userResponseDTO =
                    new UserResponseDTO(
                            foundUser.get().getUsername(),
                            profileResponseDTO);
            return Optional.of(userResponseDTO);
        }
        return Optional.empty();
    }
}
