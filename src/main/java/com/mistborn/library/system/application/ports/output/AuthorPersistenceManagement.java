package com.mistborn.library.system.application.ports.output;

import java.util.List;

import com.mistborn.library.system.domain.AuthorDO;

public interface AuthorPersistenceManagement {

  AuthorDO save(AuthorDO author);

  AuthorDO getById(String id);

  List<AuthorDO> findByName(String name);

}
