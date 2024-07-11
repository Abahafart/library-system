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
public class BookLendingDO {

  private String id;
  private LocalDate creationDate;
  private LocalDate dueDate;
  private LocalDate returnDate;
  private BookItemDO bookItem;

}
