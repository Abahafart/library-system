package com.mistborn.library.system.application.usecases;

import java.util.List;

/**
 *
 * @param <M> model
 */
public interface GeneralManagement<M> {

  M create(M model);

}
