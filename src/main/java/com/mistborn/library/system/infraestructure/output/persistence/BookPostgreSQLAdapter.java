package com.mistborn.library.system.infraestructure.output.persistence;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.mistborn.library.system.application.ports.output.BookPersistenceManagement;
import com.mistborn.library.system.domain.BookDO;
import com.mistborn.library.system.domain.exception.InformationNotFoundException;
import com.mistborn.library.system.infraestructure.mappers.BookMapper;
import com.mistborn.library.system.infraestructure.output.persistence.data.BookData;
import com.mistborn.library.system.infraestructure.output.persistence.repository.BookRepository;

@Repository
public class BookPostgreSQLAdapter implements BookPersistenceManagement {

  private final BookRepository repository;
  private final BookMapper mapper;

  public BookPostgreSQLAdapter(BookRepository repository, BookMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public BookDO save(BookDO bookDO) {
    BookData bookData = mapper.toEntity(bookDO);
    bookData.setAuthorId(UUID.fromString(bookDO.getAuthor().getId()));
    repository.save(bookData);
    return mapper.fromEntity(bookData);
  }

  @Override
  public BookDO getById(String id) {
    return mapper.fromEntity(repository.findById(UUID.fromString(id))
        .orElseThrow(() -> new InformationNotFoundException(String.format("Book with id '%s' not found", id))));
  }

  @Override
  public List<BookDO> findByTitleOrAuthorOrSubjectOrPublicationDate(
      Map<String, String> queryParams) {
    return List.of();
  }

  @Override
  public void deleteById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public BookDO update(BookDO bookDO) {
    return null;
  }
}
