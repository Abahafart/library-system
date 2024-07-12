package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.AuthorData;

public interface AuthorRepository extends JpaRepository<AuthorData, UUID> {

  List<AuthorData> findByName(String name);

}
