package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.FineData;

public interface FineRepository extends JpaRepository<FineData, UUID> {

}
