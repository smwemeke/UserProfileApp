package edu.miu.cs489.userprofile.service;

import edu.miu.cs489.userprofile.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofile.dto.response.UserResponseDTO;

import java.util.Optional;

public interface UserService {
    Optional<UserResponseDTO> createUser(UserRequestDTO user);

    Optional<UserResponseDTO> getUserByUsername(String username);
}
