package com.klu.store.dao;

import com.klu.store.util.ProductUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.store.entity.Product;

public class ProductDAO {
  //Create the Record
    public void saveProduct(Product p) {
      try(Session session = ProductUtil.getSessionFactory().openSession()){
        
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        
      }
    } 
    //Reading all the Products
    public List<Product> getProducts(){
      try(Session session = ProductUtil.getSessionFactory().openSession()){
        return session.createQuery("FROM Product", Product.class).list();
      }
    }
    // Get the Record by ProductID
    public Product getByProductId(int pid) {
      try(Session session = ProductUtil.getSessionFactory().openSession()){
        return session.get(Product.class, pid);
      }
    }
    //update the Record
    public boolean updateProduct(Product p) {
      Transaction tx = null;
      try(Session session = ProductUtil.getSessionFactory().openSession()){
        tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        return true;
      }catch(Exception e){
        if( tx != null)
          tx.rollback();
        e.printStackTrace();
        return false;
      }
    }
    //Delete the Record
    public boolean deleteProduct(int pid) {
      Transaction tx = null;
      try(Session session = ProductUtil.getSessionFactory().openSession()){
        tx = session.beginTransaction();
        Product p = session.get(Product.class, pid);
        if(p!=null) {
          session.delete(p);
        }
        tx.commit();
        return true;
      }catch(Exception e) {
        if(tx != null)
          tx.rollback();
        e.printStackTrace();
        return false;
      }
    }

}