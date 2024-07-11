package com.mistborn.library.system.domain;

import com.mistborn.library.system.domain.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDO {

  private String id;
  private String password;
  private AccountStatus status;
  private PersonDO person;

}
