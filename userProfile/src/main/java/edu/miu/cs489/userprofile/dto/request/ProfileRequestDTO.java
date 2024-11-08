package edu.miu.cs489.userprofile.dto.request;

import java.time.LocalDate;

public record ProfileRequestDTO(String bio, String location, LocalDate dob ) {

}
