package com.mistborn.library.system.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mistborn.library.system.domain.BookItemDO;
import com.mistborn.library.system.domain.rest.request.BookItemRequest;
import com.mistborn.library.system.domain.rest.response.BookItemResponse;
import com.mistborn.library.system.infraestructure.config.MappingConfig;
import com.mistborn.library.system.infraestructure.output.persistence.data.BookItemData;

@Mapper(config = MappingConfig.class)
public interface BookItemMapper extends
    GenericMapper<BookItemDO, BookItemRequest, BookItemResponse, BookItemData> {

  @Override
  @Mapping(target = "book.id", source = "bookId")
  BookItemDO fromEntity(BookItemData entity);
}
