package com.mistborn.library.system.domain;

import java.time.LocalDate;

import com.mistborn.library.system.domain.enums.ReservationStatus;

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
public class BookReservationDO {

  private String id;
  private LocalDate creationDate;
  private ReservationStatus status;
  private AccountDO account;
  private BookItemDO bookItem;

}
