package com.mistborn.library.system.application.usecases;

import java.util.List;

import com.mistborn.library.system.domain.AuthorDO;

public interface AuthorManagement extends GeneralManagement<AuthorDO> {

  List<AuthorDO> getByName(String authorName);

}
