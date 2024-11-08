package edu.miu.cs489.userprofile.service.impl;

import edu.miu.cs489.userprofile.model.Profile;
import edu.miu.cs489.userprofile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    @Override
    public Optional<Profile> createProfile(Profile profile) {
        return Optional.empty();
    }
}
