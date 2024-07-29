package com.mistborn.library.system.application.ports.output;

import com.mistborn.library.system.domain.LibraryDO;

public interface LibraryPersistenceManagement {

  LibraryDO create(LibraryDO libraryDO);
  LibraryDO getById(String id);
  LibraryDO getByName(String name);

}
