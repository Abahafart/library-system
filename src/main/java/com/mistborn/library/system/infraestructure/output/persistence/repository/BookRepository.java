package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.BookData;

public interface BookRepository extends JpaRepository<BookData, UUID> {

  List<BookData> findByTitle(String title);
  List<BookData> findBySubject(String subject);
  List<BookData> findByAuthorId(UUID authorId);

}
