package com.codesquad.library.domain.repositories;

import com.codesquad.library.domain.Featured;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FeaturedRepository extends CrudRepository<Featured, Long> {

    Optional<Featured> findByTitle(String title);

    Optional<Featured> findByFeatureCode(String featureCode);
}
