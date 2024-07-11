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
public class BookDO {

  private String id;
  private String title;
  private String isbn;
  private String subject;
  private String publisher;
  private String language;
  private int numberOfPages;
  private AuthorDO author;

}
