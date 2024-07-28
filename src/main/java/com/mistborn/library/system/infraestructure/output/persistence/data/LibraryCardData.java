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
@Entity(name = "library_cards")
public class LibraryCardData {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private UUID accountId;
  private String cardNumber;
  private String barcode;
  private LocalDate issueAt;
  private boolean active;

}
