package com.mistborn.library.system.application.ports.input;

import static com.mistborn.library.system.domain.constants.BookConstants.AUTHOR;
import static com.mistborn.library.system.domain.constants.BookConstants.SUBJECT;
import static com.mistborn.library.system.domain.constants.BookConstants.TITLE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mistborn.library.system.application.ServiceComponent;
import com.mistborn.library.system.application.ports.output.AuthorPersistenceManagement;
import com.mistborn.library.system.application.ports.output.BookPersistenceManagement;
import com.mistborn.library.system.application.usecases.BookManagement;
import com.mistborn.library.system.domain.AuthorDO;
import com.mistborn.library.system.domain.BookDO;

@ServiceComponent
public class BookManagementInputPort implements BookManagement {

  private final BookPersistenceManagement persistenceManagement;
  private final AuthorPersistenceManagement authorPersistenceManagement;

  public BookManagementInputPort(BookPersistenceManagement persistenceManagement,
      AuthorPersistenceManagement authorPersistenceManagement) {
    this.persistenceManagement = persistenceManagement;
    this.authorPersistenceManagement = authorPersistenceManagement;
  }

  @Override
  public BookDO create(BookDO model) {
    AuthorDO found = authorPersistenceManagement.getById(model.getAuthor().getId());
    model.setAuthor(found);
    BookDO result = persistenceManagement.save(model);
    result.setAuthor(found);
    return result;
  }

  @Override
  public BookDO getById(String id) {
    return persistenceManagement.getById(id);
  }

  @Override
  public List<BookDO> findByTitleOrAuthorOrSubjectOrPublicationDate(
      Map<String, String> queryParams) {
    List<BookDO> records = new ArrayList<>();
    if (queryParams.containsKey(AUTHOR)) {
      List<AuthorDO> authors = authorPersistenceManagement.findByName(queryParams.get(AUTHOR));
      authors.forEach(author -> records.addAll(persistenceManagement.findByAuthorId(author.getId())));
    }
    if (queryParams.containsKey(TITLE)) {
      records.addAll(persistenceManagement.findByTitle(queryParams.get(TITLE)));
    }
    if (queryParams.containsKey(SUBJECT)) {
      records.addAll(persistenceManagement.findBySubject(queryParams.get(SUBJECT)));
    }
    return records;
  }

  @Override
  public void deleteById(String id) {
    persistenceManagement.deleteById(id);
  }

  @Override
  public BookDO update(BookDO model) {
    AuthorDO authorFound = authorPersistenceManagement.getById(model.getAuthor().getId());
    model.setAuthor(authorFound);
    BookDO bookFound = persistenceManagement.getById(model.getId());
    if (validateString(model.getIsbn())) {
      bookFound.setIsbn(model.getIsbn());
    }
    if (validateString(model.getTitle())) {
      bookFound.setTitle(model.getTitle());
    }
    if (validateString(model.getLanguage())) {
      bookFound.setLanguage(model.getLanguage());
    }
    if (validateString(model.getPublisher())) {
      bookFound.setPublisher(model.getPublisher());
    }
    if (validateString(model.getSubject())) {
      bookFound.setSubject(model.getSubject());
    }
    if (model.getNumberOfPages() > 0 && model.getNumberOfPages() != bookFound.getNumberOfPages()) {
      bookFound.setNumberOfPages(model.getNumberOfPages());
    }
    return persistenceManagement.update(bookFound);
  }

  private boolean validateString(String input) {
    return input != null && !input.isEmpty();
  }
}
