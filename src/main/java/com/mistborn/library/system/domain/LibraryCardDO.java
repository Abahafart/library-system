package com.mistborn.library.system.domain;

import java.time.LocalDate;

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
public class LibraryCardDO {

  private String id;
  private String cardNumber;
  private String barcode;
  private LocalDate issueAt;
  private boolean active;
  private AccountDO account;

}
