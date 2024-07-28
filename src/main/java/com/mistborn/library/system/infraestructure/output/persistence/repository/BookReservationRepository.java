package com.mistborn.library.system.infraestructure.output.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistborn.library.system.infraestructure.output.persistence.data.BookReservationData;

public interface BookReservationRepository extends JpaRepository<BookReservationData, UUID> {

}
