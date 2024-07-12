package com.mistborn.library.system.domain.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

  private String title;
  private String isbn;
  private String subject;
  private String publisher;
  private String language;
  private int numberOfPages;
  private AuthorRequest author;

}
