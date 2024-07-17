package com.mistborn.library.system.application.ports.output;

import java.util.List;
import java.util.Map;

import com.mistborn.library.system.domain.BookDO;

public interface BookPersistenceManagement {

  BookDO save(BookDO bookDO);
  BookDO getById(String id);
  List<BookDO> findByTitleOrAuthorOrSubjectOrPublicationDate(Map<String, String> queryParams);
  void deleteById(String id);
  BookDO update(BookDO bookDO);

}
