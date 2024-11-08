package edu.miu.cs489.userprofile.service;

import edu.miu.cs489.userprofile.model.Profile;

import java.util.Optional;

public interface ProfileService {
    Optional<Profile> createProfile(Profile profile);
}
