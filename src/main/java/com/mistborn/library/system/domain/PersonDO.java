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
public class PersonDO {

  private String id;
  private String name;
  private AddressDO address;
  private String email;
  private String phone;

}
