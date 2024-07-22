package com.mistborn.library.system.application.ports.output;

import java.util.List;

import com.mistborn.library.system.domain.BookDO;

public interface BookPersistenceManagement {

  BookDO save(BookDO bookDO);

  BookDO getById(String id);

  List<BookDO> findBySubject(String subject);

  List<BookDO> findByTitle(String title);

  List<BookDO> findByAuthorId(String id);

  void deleteById(String id);

  BookDO update(BookDO bookDO);

}
