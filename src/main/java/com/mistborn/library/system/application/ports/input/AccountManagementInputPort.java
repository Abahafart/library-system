package com.mistborn.library.system.application.ports.input;

import java.util.List;

import com.mistborn.library.system.application.usecases.AccountManagement;
import com.mistborn.library.system.domain.AccountDO;

public class AccountManagementInputPort implements AccountManagement {

  @Override
  public AccountDO create(AccountDO model) {
    return null;
  }

  @Override
  public AccountDO update(AccountDO model) {
    return null;
  }

  @Override
  public List<AccountDO> findAll(AccountDO model) {
    return List.of();
  }
}
