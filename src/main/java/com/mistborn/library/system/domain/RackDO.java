package com.mistborn.library.system.domain;

import java.util.List;

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
public class RackDO {

  private String id;
  private int number;
  private String locationIdentifier;
  private List<BookItemDO> bookItems;

}
