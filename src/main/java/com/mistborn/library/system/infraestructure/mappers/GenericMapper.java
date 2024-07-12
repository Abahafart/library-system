package com.mistborn.library.system.infraestructure.mappers;

/**
 * @param <M> model
 * @param <T> request
 * @param <R> response
 * @param <E> entity
 */
public interface GenericMapper<M, T, R, E> {

  M fromRequest(T request);

  M fromEntity(E entity);

  R fromModel(M model);

  E toEntity(M model);
}
