package com.mistborn.library.system.domain.rest.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.mistborn.library.system.domain.enums.BookFormat;
import com.mistborn.library.system.domain.enums.BookStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookItemRequest {

  private BookRequest book;
  private String barcode;
  private boolean referenceOnly;
  private LocalDate borrowed;
  private LocalDate dueDate;
  private BigDecimal price;
  private BookFormat format;
  private BookStatus status;
  private LocalDate dateOfPurchase;
  private LocalDate publicationDate;
  private LibraryRequest library;

}
