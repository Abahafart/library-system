package com.mistborn.library.system.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mistborn.library.system.domain.BookDO;
import com.mistborn.library.system.domain.rest.request.BookRequest;
import com.mistborn.library.system.domain.rest.response.BookResponse;
import com.mistborn.library.system.infraestructure.config.MappingConfig;
import com.mistborn.library.system.infraestructure.output.persistence.data.BookData;

@Mapper(config = MappingConfig.class)
public interface BookMapper extends GenericMapper<BookDO, BookRequest, BookResponse, BookData> {

  @Override
  @Mapping(target = "author", ignore = true)
  BookDO fromRequest(BookRequest request);
}
