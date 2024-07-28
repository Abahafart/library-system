package com.mistborn.library.system.infraestructure.output.persistence.data;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "libraries")
public class LibraryData {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private UUID addressId;
  private String name;

}
