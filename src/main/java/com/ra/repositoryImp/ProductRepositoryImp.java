package com.ra.repositoryImp;


import com.ra.model.Product;
import com.ra.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public List<Product> findByName(String productName) {
        return entityManager.createQuery("select p from Product  p where p.productName like :productName")
                .setParameter("productName","%"+productName+"%").getResultList();
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
