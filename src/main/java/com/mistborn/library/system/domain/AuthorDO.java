package com.mistborn.library.system.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDO implements Serializable {

  private String id;
  private String name;
  private String description;

}
