package com.mistborn.library.system.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mistborn.library.system.domain.LibraryDO;
import com.mistborn.library.system.domain.rest.request.LibraryRequest;
import com.mistborn.library.system.domain.rest.response.LibraryResponse;
import com.mistborn.library.system.infraestructure.config.MappingConfig;
import com.mistborn.library.system.infraestructure.output.persistence.data.LibraryData;

@Mapper(config = MappingConfig.class)
public interface LibraryMapper extends GenericMapper<LibraryDO, LibraryRequest, LibraryResponse, LibraryData> {

  @Override
  @Mapping(source = "address.id", target = "addressId")
  LibraryData toEntity(LibraryDO model);

  @Override
  @Mapping(source = "addressId", target = "address.id")
  LibraryDO fromEntity(LibraryData entity);
}
