package com.mistborn.library.system.application.ports.input;

import java.util.List;

import com.mistborn.library.system.application.ServiceComponent;
import com.mistborn.library.system.application.ports.output.AuthorPersistenceManagement;
import com.mistborn.library.system.application.usecases.AuthorManagement;
import com.mistborn.library.system.domain.AuthorDO;

@ServiceComponent
public class AuthorManagementInputPort implements AuthorManagement {

  private final AuthorPersistenceManagement persistenceManagement;

  public AuthorManagementInputPort(AuthorPersistenceManagement persistenceManagement) {
    this.persistenceManagement = persistenceManagement;
  }

  @Override
  public AuthorDO create(AuthorDO model) {
    return persistenceManagement.save(model);
  }
}
