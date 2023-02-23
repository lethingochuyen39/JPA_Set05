package com.aptech.student1318434.services;

import com.aptech.student1318434.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class ProductBean {

    private final EntityManager entiManager;
    public ProductBean(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entiManager = entityManagerFactory.createEntityManager();
    }

    public List<Product> findAll(){
        return entiManager.createQuery("Select e from Product e", Product.class).getResultList();
    }

    public Product getProductId(int id) {
        return entiManager.find(Product.class, id);
    }

    public boolean deleteProduct(int id) {
        try{
            entiManager.getTransaction().begin();
            entiManager.remove(getProductId(id));
            entiManager.getTransaction().commit();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

}
