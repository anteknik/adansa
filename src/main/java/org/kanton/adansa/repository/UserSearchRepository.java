package org.kanton.adansa.repository;

import java.util.List;

import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import org.kanton.adansa.domain.User;

public interface UserSearchRepository {

	List<User> findUserWithDatatablesCriterias(DatatablesCriterias criterias);

	Long getTotalCount();

	Long getFilteredCount(DatatablesCriterias criterias);
}
