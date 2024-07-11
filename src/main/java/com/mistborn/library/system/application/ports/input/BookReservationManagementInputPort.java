package com.mistborn.library.system.application.ports.input;

import java.util.List;

import com.mistborn.library.system.application.usecases.BookReservationManagement;
import com.mistborn.library.system.domain.BookReservationDO;

public class BookReservationManagementInputPort implements BookReservationManagement {

  @Override
  public BookReservationDO create(BookReservationDO model) {
    return null;
  }

  @Override
  public BookReservationDO update(BookReservationDO model) {
    return null;
  }

  @Override
  public List<BookReservationDO> findAll(BookReservationDO model) {
    return List.of();
  }
}
