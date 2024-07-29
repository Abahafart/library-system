package com.mistborn.library.system.domain.rest.response;

import lombok.Data;

@Data
public class AddressResponse {

  private String id;
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private String country;

}
