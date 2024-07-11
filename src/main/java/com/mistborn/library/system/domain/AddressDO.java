package com.mistborn.library.system.domain;

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
public class AddressDO {

  private String id;
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private String country;

}
