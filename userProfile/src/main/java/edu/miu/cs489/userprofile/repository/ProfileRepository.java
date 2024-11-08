package edu.miu.cs489.userprofile.repository;

import edu.miu.cs489.userprofile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
