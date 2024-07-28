package com.mistborn.library.system.infraestructure.mappers;

/**
 * @param <M> model object
 * @param <D> data object
 */
public interface ModelDataMapper<M, D> {

  M fromEntity(D d);

  D toEntity(M m);

}
