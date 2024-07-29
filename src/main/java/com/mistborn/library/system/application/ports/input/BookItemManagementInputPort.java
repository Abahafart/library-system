package com.mistborn.library.system.application.ports.input;

import com.mistborn.library.system.application.ServiceComponent;
import com.mistborn.library.system.application.ports.output.BookItemPersistenceManagement;
import com.mistborn.library.system.application.ports.output.BookPersistenceManagement;
import com.mistborn.library.system.application.usecases.BookItemManagement;
import com.mistborn.library.system.domain.BookItemDO;

@ServiceComponent
public class BookItemManagementInputPort implements BookItemManagement {

  private final BookItemPersistenceManagement persistenceManagement;
  private final BookPersistenceManagement bookPersistenceManagement;

  public BookItemManagementInputPort(BookItemPersistenceManagement persistenceManagement,
      BookPersistenceManagement bookPersistenceManagement) {
    this.persistenceManagement = persistenceManagement;
    this.bookPersistenceManagement = bookPersistenceManagement;
  }

  @Override
  public BookItemDO create(BookItemDO model) {
    if (null == model.getBook().getId() || model.getBook().getId().isEmpty()) {
      model.setBook(bookPersistenceManagement.save(model.getBook()));
    }
    return persistenceManagement.create(model);
  }
}
