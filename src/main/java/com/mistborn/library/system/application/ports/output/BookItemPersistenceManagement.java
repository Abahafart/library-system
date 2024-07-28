package com.mistborn.library.system.application.ports.output;

import java.time.LocalDate;
import java.util.List;

import com.mistborn.library.system.domain.BookItemDO;

public interface BookItemPersistenceManagement {

  List<BookItemDO> findByPublicationDate(LocalDate publicationDate);

  void update(BookItemDO bookItemDO);

  void deleteById(String id);

}
