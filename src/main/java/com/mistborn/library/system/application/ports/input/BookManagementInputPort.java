package com.mistborn.library.system.application.ports.input;

import java.util.List;

import com.mistborn.library.system.application.usecases.BookManagement;
import com.mistborn.library.system.domain.BookDO;

public class BookManagementInputPort implements BookManagement {

  @Override
  public BookDO create(BookDO model) {
    return null;
  }

  @Override
  public BookDO update(BookDO model) {
    return null;
  }

  @Override
  public List<BookDO> findAll(BookDO model) {
    return List.of();
  }
}
