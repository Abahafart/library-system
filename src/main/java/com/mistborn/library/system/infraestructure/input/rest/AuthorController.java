package com.mistborn.library.system.infraestructure.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mistborn.library.system.application.usecases.AuthorManagement;
import com.mistborn.library.system.domain.AuthorDO;
import com.mistborn.library.system.domain.rest.request.AuthorRequest;
import com.mistborn.library.system.domain.rest.response.AuthorResponse;
import com.mistborn.library.system.infraestructure.mappers.AuthorMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthorController {

  private final AuthorManagement authorManagement;
  private final AuthorMapper mapper;

  public AuthorController(AuthorManagement authorManagement, AuthorMapper mapper) {
    this.authorManagement = authorManagement;
    this.mapper = mapper;
  }

  @PostMapping(path = "/authors")
  @ResponseStatus(HttpStatus.CREATED)
  public AuthorResponse create(@RequestBody AuthorRequest authorRequest) {
    log.info("Create author request: {}", authorRequest);
    AuthorDO created = authorManagement.create(mapper.fromRequest(authorRequest));
    log.info("Created author response: {}", created);
    return mapper.fromModel(created);
  }
}
