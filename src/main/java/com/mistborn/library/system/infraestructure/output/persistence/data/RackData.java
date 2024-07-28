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
@Entity(name = "racks")
public class RackData {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private int number;
  private String locationIdentifier;

}
