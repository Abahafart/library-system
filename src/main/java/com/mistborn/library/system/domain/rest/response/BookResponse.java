package com.mistborn.library.system.domain.rest.response;

import lombok.Data;

@Data
public class BookResponse {

  private String id;
  private String title;
  private String isbn;
  private String subject;
  private String publisher;
  private String language;
  private int numberOfPages;
  private AuthorResponse author;
}
