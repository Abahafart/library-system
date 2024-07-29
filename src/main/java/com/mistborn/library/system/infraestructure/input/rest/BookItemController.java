package com.mistborn.library.system.infraestructure.input.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mistborn.library.system.application.usecases.BookItemManagement;
import com.mistborn.library.system.domain.BookItemDO;
import com.mistborn.library.system.domain.rest.request.BookItemRequest;
import com.mistborn.library.system.domain.rest.response.BookItemResponse;
import com.mistborn.library.system.infraestructure.mappers.BookItemMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/bookItems")
public class BookItemController {

  private final BookItemManagement bookItemManagement;
  private final BookItemMapper mapper;

  public BookItemController(BookItemManagement bookItemManagement, BookItemMapper mapper) {
    this.bookItemManagement = bookItemManagement;
    this.mapper = mapper;
  }

  @PostMapping
  public BookItemResponse create(@RequestBody BookItemRequest request) {
    log.info("Creating BookItem: {}", request);
    BookItemDO created = bookItemManagement.create(mapper.fromRequest(request));
    log.info("Created BookItem: {}", created);
    return mapper.fromModel(created);
  }

}
