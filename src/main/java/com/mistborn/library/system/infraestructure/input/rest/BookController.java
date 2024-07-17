package com.mistborn.library.system.infraestructure.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mistborn.library.system.application.usecases.BookManagement;
import com.mistborn.library.system.domain.AuthorDO;
import com.mistborn.library.system.domain.BookDO;
import com.mistborn.library.system.domain.rest.request.BookRequest;
import com.mistborn.library.system.domain.rest.response.BookResponse;
import com.mistborn.library.system.infraestructure.mappers.BookMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

  private final BookManagement bookManagement;
  private final BookMapper bookMapper;

  public BookController(BookManagement bookManagement, BookMapper bookMapper) {
    this.bookManagement = bookManagement;
    this.bookMapper = bookMapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookResponse createBook(@RequestBody BookRequest request) {
    log.info("Create book request: {}", request);
    BookDO toCreate = bookMapper.fromRequest(request);
    AuthorDO author = new AuthorDO();
    author.setId(request.getAuthorId().toString());
    toCreate.setAuthor(author);
    BookDO created = bookManagement.create(toCreate);
    log.info("Created book: {}", created);
    return bookMapper.fromModel(created);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public BookResponse getById(@PathVariable String id) {
    return bookMapper.fromModel(bookManagement.getById(id));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable String id) {
    log.info("Delete book: {}", id);
    bookManagement.deleteById(id);
  }
}
