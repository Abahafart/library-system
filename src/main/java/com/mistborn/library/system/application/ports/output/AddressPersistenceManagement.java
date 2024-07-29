package com.mistborn.library.system.application.ports.output;

import com.mistborn.library.system.domain.AddressDO;

public interface AddressPersistenceManagement {

  AddressDO create(AddressDO addressDO);

}
