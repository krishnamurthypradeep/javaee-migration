package com.myapp.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.SUPPORTS)
public class ProductService {

    //@PersistenceContext
    @Inject
    private EntityManager em;

    public Product find(Integer id){
        return em.find(Product.class,id);
    }

    public List<Product> findAll(){
       return em.createQuery("SELECT p FROM Product p ORDER BY p.productName DESC",Product.class)
                .getResultList();
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public Product create(Product product){
        em.persist(product);
        return product;
    }
}
