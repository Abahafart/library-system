package com.mistborn.library.system.domain;

import java.math.BigDecimal;

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
public class FineDO {

  private String id;
  private BigDecimal amount;
  private BookLendingDO bookLending;
  private AccountDO account;

}
