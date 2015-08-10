package org.kanton.adansa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.kanton.adansa.domain.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
