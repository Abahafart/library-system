package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.LibraryData;

public interface LibraryRepository extends JpaRepository<LibraryData, UUID> {

  Optional<LibraryData> findByName(String title);
}
