package com.mistborn.library.system.infraestructure.output.persistence.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "book_items")
public class BookItemData {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private UUID bookId;
  private UUID libraryId;
  private String barcode;
  private boolean referenceOnly;
  private LocalDate borrowed;
  private LocalDate dueDate;
  private BigDecimal price;
  private String format;
  private String status;
  private LocalDate dateOfPurchase;
  private LocalDate publicationDate;

}
