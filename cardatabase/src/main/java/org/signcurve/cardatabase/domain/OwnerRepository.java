package org.signcurve.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
      //List<Owner> saveAll(List<Owner> owners);
}
