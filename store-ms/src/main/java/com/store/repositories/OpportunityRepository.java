package com.store.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Opportunity;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

	Optional<Opportunity> findByUuid(UUID uuid);
}
