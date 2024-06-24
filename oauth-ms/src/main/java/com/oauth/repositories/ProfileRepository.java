package com.oauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}