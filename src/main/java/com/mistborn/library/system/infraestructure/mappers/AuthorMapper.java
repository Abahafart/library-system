package com.mistborn.library.system.infraestructure.mappers;

import org.mapstruct.Mapper;

import com.mistborn.library.system.domain.AuthorDO;
import com.mistborn.library.system.domain.rest.request.AuthorRequest;
import com.mistborn.library.system.domain.rest.response.AuthorResponse;
import com.mistborn.library.system.infraestructure.config.MappingConfig;
import com.mistborn.library.system.infraestructure.output.persistence.data.AuthorData;

@Mapper(config = MappingConfig.class)
public interface AuthorMapper extends GenericMapper<AuthorDO, AuthorRequest, AuthorResponse, AuthorData> {

}
