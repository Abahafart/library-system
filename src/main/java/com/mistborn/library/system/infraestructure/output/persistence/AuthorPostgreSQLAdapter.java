package com.mistborn.library.system.infraestructure.output.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.mistborn.library.system.application.ports.output.AuthorPersistenceManagement;
import com.mistborn.library.system.domain.AuthorDO;
import com.mistborn.library.system.domain.exception.InformationNotFoundException;
import com.mistborn.library.system.infraestructure.mappers.AuthorMapper;
import com.mistborn.library.system.infraestructure.output.persistence.data.AuthorData;
import com.mistborn.library.system.infraestructure.output.persistence.repository.AuthorRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AuthorPostgreSQLAdapter implements AuthorPersistenceManagement {

  private final AuthorMapper mapper;
  private final AuthorRepository repository;

  public AuthorPostgreSQLAdapter(AuthorMapper mapper, AuthorRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  @CacheEvict(value = "authors", allEntries = true)// to disable cache when new record comes in
  public AuthorDO save(AuthorDO author) {
    AuthorData authorData = mapper.toEntity(author);
    return mapper.fromEntity(repository.save(authorData));
  }

  @Override
  public AuthorDO getById(String id) {
    return repository.findById(UUID.fromString(id)).map(mapper::fromEntity)
        .orElseThrow(() -> new InformationNotFoundException(
            String.format("Author with id %s not found", id)));
  }

  @Override
  @Cacheable(value = "authors")// cache results, values are invalidated when new author is added
  public List<AuthorDO> findByName(String name) {
    log.info("Reading from database");
    return repository.findByNameContainsIgnoreCase(name).stream().map(mapper::fromEntity).toList();
  }
}
