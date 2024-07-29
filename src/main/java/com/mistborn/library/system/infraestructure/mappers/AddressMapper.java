package com.mistborn.library.system.infraestructure.mappers;

import org.mapstruct.Mapper;

import com.mistborn.library.system.domain.AddressDO;
import com.mistborn.library.system.domain.rest.request.AddressRequest;
import com.mistborn.library.system.domain.rest.response.AddressResponse;
import com.mistborn.library.system.infraestructure.config.MappingConfig;
import com.mistborn.library.system.infraestructure.output.persistence.data.AddressData;

@Mapper(config = MappingConfig.class)
public interface AddressMapper extends GenericMapper<AddressDO, AddressRequest, AddressResponse, AddressData> {

}
