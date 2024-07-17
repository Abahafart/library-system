package com.mistborn.library.system.application.ports.input;

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
    return persistenceManagement.save(model);
  }

  @Override
  public BookDO getById(String id) {
    return persistenceManagement.getById(id);
  }

  @Override
  public List<BookDO> findByTitleOrAuthorOrSubjectOrPublicationDate(
      Map<String, String> queryParams) {
    return persistenceManagement.findByTitleOrAuthorOrSubjectOrPublicationDate(queryParams);
  }

  @Override
  public void deleteById(String id) {
    persistenceManagement.deleteById(id);
  }

  @Override
  public BookDO update(BookDO bookDO) {
    return null;
  }
}
