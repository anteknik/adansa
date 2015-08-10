package org.kanton.adansa.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.github.dandelion.datatables.core.ajax.ColumnDef;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import org.kanton.adansa.domain.User;

/**
 * Created anan on 8/8/15.
 */
@Repository
public class UserSearchRepositoryImpl implements UserSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findUserWithDatatablesCriterias(
            DatatablesCriterias criterias) {
        StringBuilder queryBuilder = new StringBuilder("SELECT u FROM User u");

        /**
         * Step 1: global and individual column filtering
         */
        queryBuilder.append(ClientRepositoryUtils.getFilterQuery(criterias));

        /**
         * Step 2: sorting
         */
        if (criterias.hasOneSortedColumn()) {

            List<String> orderParams = new ArrayList<String>();
            queryBuilder.append(" ORDER BY ");
            for (ColumnDef columnDef : criterias.getSortingColumnDefs()) {
                orderParams.add("u." + columnDef.getName() + " "
                        + columnDef.getSortDirection());
            }

            Iterator<String> itr2 = orderParams.iterator();
            while (itr2.hasNext()) {
                queryBuilder.append(itr2.next());
                if (itr2.hasNext()) {
                    queryBuilder.append(" , ");
                }
            }
        }

        TypedQuery<User> query = entityManager.createQuery(
                queryBuilder.toString(), User.class);

        /**
         * Step 3: paging
         */
        query.setFirstResult(criterias.getDisplayStart());
        query.setMaxResults(criterias.getDisplaySize());

        return query.getResultList();
    }

    @Override
    public Long getTotalCount() {
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u");
        return (Long) query.getSingleResult();
    }

    @Override
    public Long getFilteredCount(DatatablesCriterias criterias) {
        StringBuilder queryBuilder = new StringBuilder("SELECT u FROM User u");

        queryBuilder.append(UserRepositoryUtils.getFilterQuery(criterias));

        Query query = entityManager.createQuery(queryBuilder.toString());
        return Long.parseLong(String.valueOf(query.getResultList().size()));
    }
}
