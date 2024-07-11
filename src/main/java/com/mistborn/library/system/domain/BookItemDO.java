package com.mistborn.library.system.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.mistborn.library.system.domain.enums.BookFormat;
import com.mistborn.library.system.domain.enums.BookStatus;

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
public class BookItemDO {

  private String id;
  private BookDO book;
  private String barcode;
  private boolean referenceOnly;
  private LocalDate borrowed;
  private LocalDate dueDate;
  private BigDecimal price;
  private BookFormat format;
  private BookStatus status;
  private LocalDate dateOfPurchase;
  private LocalDate publicationDate;
  private LibraryDO library;

}
