package com.mistborn.library.system.application.usecases;

import java.util.List;
import java.util.Map;

import com.mistborn.library.system.domain.BookDO;

public interface BookManagement extends GeneralManagement<BookDO> {

  BookDO getById(String id);

  List<BookDO> findByTitleOrAuthorOrSubjectOrPublicationDate(Map<String, String> queryParams);

  void deleteById(String id);

  void update(BookDO bookDO);

}
