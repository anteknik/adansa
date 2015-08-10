package org.kanton.adansa.service;

import java.util.Set;

import org.kanton.adansa.domain.Authority;

/**
 * Created by anan on 8/8/15.
 */
public interface AuthorityService extends BaseService<Authority, String> {

    Set<Authority> findByUserId(String userId);

}