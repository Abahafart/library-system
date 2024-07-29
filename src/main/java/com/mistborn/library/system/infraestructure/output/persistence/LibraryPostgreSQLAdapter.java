package com.mistborn.library.system.infraestructure.output.persistence;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.mistborn.library.system.application.ports.output.LibraryPersistenceManagement;
import com.mistborn.library.system.domain.LibraryDO;
import com.mistborn.library.system.domain.exception.InformationNotFoundException;
import com.mistborn.library.system.infraestructure.mappers.LibraryMapper;
import com.mistborn.library.system.infraestructure.output.persistence.data.LibraryData;
import com.mistborn.library.system.infraestructure.output.persistence.repository.LibraryRepository;

@Repository
public class LibraryPostgreSQLAdapter implements LibraryPersistenceManagement {

  private final LibraryMapper mapper;
  private final LibraryRepository repository;

  public LibraryPostgreSQLAdapter(LibraryMapper mapper, LibraryRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  public LibraryDO create(LibraryDO libraryDO) {
    LibraryData data = mapper.toEntity(libraryDO);
    return mapper.fromEntity(repository.save(data));
  }

  @Override
  public LibraryDO getById(String id) {
    return mapper.fromEntity(repository.findById(UUID.fromString(id))
        .orElseThrow(() -> new InformationNotFoundException(String.format("Library with id %s not found", id))));
  }

  @Override
  public LibraryDO getByName(String name) {
    return mapper.fromEntity(repository.findByName(name)
        .orElseThrow(() -> new InformationNotFoundException(String.format("Library with name %s not found", name))));
  }
}
