package com.mistborn.library.system.infraestructure.output.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mistborn.library.system.application.ports.output.BookItemPersistenceManagement;
import com.mistborn.library.system.domain.BookItemDO;
import com.mistborn.library.system.infraestructure.mappers.BookItemMapper;
import com.mistborn.library.system.infraestructure.output.persistence.repository.BookItemRepository;

@Repository
public class BookItemPostgreSQLAdapter implements BookItemPersistenceManagement {

  private final BookItemRepository repository;
  private final BookItemMapper mapper;

  public BookItemPostgreSQLAdapter(BookItemRepository repository,
      BookItemMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<BookItemDO> findByPublicationDate(LocalDate publicationDate) {
    return repository.findByPublicationDate(publicationDate).stream().map(mapper::fromEntity).toList();
  }

  @Override
  public void update(BookItemDO bookItemDO) {

  }

  @Override
  public void deleteById(String id) {

  }
}
