package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.BookItemData;

public interface BookItemRepository extends JpaRepository<BookItemData, UUID> {

  List<BookItemData> findByPublicationDate(LocalDate publicationDate);

}
