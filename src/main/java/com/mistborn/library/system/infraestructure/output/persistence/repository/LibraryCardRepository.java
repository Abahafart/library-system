package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.LibraryCardData;

public interface LibraryCardRepository extends JpaRepository<LibraryCardData, UUID> {

}
