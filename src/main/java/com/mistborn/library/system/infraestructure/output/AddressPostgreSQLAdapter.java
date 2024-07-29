package com.mistborn.library.system.infraestructure.output;

import org.springframework.stereotype.Repository;

import com.mistborn.library.system.application.ports.output.AddressPersistenceManagement;
import com.mistborn.library.system.domain.AddressDO;
import com.mistborn.library.system.infraestructure.mappers.AddressMapper;
import com.mistborn.library.system.infraestructure.output.persistence.data.AddressData;
import com.mistborn.library.system.infraestructure.output.persistence.repository.AddressRepository;

@Repository
public class AddressPostgreSQLAdapter implements AddressPersistenceManagement {

  private final AddressRepository repository;
  private final AddressMapper mapper;

  public AddressPostgreSQLAdapter(AddressRepository repository, AddressMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public AddressDO create(AddressDO addressDO) {
    AddressData data = mapper.toEntity(addressDO);
    return mapper.fromEntity(repository.save(data));
  }
}
