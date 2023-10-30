package com.ra.repositoryImp;

import com.ra.model.Categories;
import com.ra.repository.CategoriesRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CategoriesRepositoryImp implements CategoriesRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Categories> findAll() {
        return entityManager.createQuery("select t from Categories as t",Categories.class).getResultList();
    }

    @Override
    public Categories findById(int catalogId) {
        return (Categories) entityManager.createQuery("select t from Categories as t where t.catalogId = :catId")
                .setParameter("catId",catalogId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Categories catalog) {
        try {
            entityManager.persist(catalog);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Categories catalog) {
        try {
            entityManager.merge(catalog);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int catalogId) {
        try {
            entityManager.remove(findById(catalogId));
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
