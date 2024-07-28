package com.mistborn.library.system.infraestructure.output.persistence.data;

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
@Entity(name = "book_lendings")
public class BookLendingData {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private UUID bookItemId;
  private LocalDate creationDate;
  private LocalDate dueDate;
  private LocalDate returnDate;

}
