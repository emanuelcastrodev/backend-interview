package com.store.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	Optional<Car> findByUuid(UUID uuid);
}
