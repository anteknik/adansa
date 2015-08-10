package org.kanton.adansa.service;

import java.util.List;

/**
 * Created by anan on 8/8/15.
 */
public interface BaseService<T, ID> {

    public T findById(ID id);

    public T saveOrUpdate(T entity);

    public void delete(T entity);

    public void deleteById(ID id);

    public Long getTotalData();

    public List<T> getAll();

}
