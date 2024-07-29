package com.mistborn.library.system.application.ports.input;

import com.mistborn.library.system.application.ServiceComponent;
import com.mistborn.library.system.application.ports.output.AddressPersistenceManagement;
import com.mistborn.library.system.application.ports.output.LibraryPersistenceManagement;
import com.mistborn.library.system.application.usecases.LibraryManagement;
import com.mistborn.library.system.domain.AddressDO;
import com.mistborn.library.system.domain.LibraryDO;

@ServiceComponent
public class LibraryManagementInputPort implements LibraryManagement {

  private final LibraryPersistenceManagement persistenceManagement;
  private final AddressPersistenceManagement addressPersistenceManagement;

  public LibraryManagementInputPort(LibraryPersistenceManagement persistenceManagement,
      AddressPersistenceManagement addressPersistenceManagement) {
    this.persistenceManagement = persistenceManagement;
    this.addressPersistenceManagement = addressPersistenceManagement;
  }

  @Override
  public LibraryDO create(LibraryDO model) {
    AddressDO createdAddress = addressPersistenceManagement.create(model.getAddress());
    model.setAddress(createdAddress);
    return persistenceManagement.create(model);
  }
}
