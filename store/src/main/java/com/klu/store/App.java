package com.klu.store;

import java.util.List;
import com.klu.store.dao.ProductDAO;
import com.klu.store.entity.Product;

public class App {

    // Utility method to print all products
    public static void printAll(ProductDAO dao) {
        List<Product> products = dao.getProducts();
        System.out.println("\n---- PRODUCT TABLE ----");
        for (Product p : products) {
            System.out.println(
                p.getPid() + "  " +
                p.getName() + "  " +
                p.getPrice() + "  " +
                p.getQuantity()
            );
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // Insert
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setDescription("Gaming Laptop");
        p1.setPrice(55000);
        p1.setQuantity(10);
        dao.saveProduct(p1);

        System.out.println("After inserting Laptop:");
        printAll(dao);

        
        Product p2 = new Product();
        p2.setName("Mobile");
        p2.setDescription("Android Phone");
        p2.setPrice(25000);
        p2.setQuantity(20);
        dao.saveProduct(p2);

        System.out.println("After inserting Mobile:");
        printAll(dao);

       
        Product p3 = new Product();
        p3.setName("Headphones");
        p3.setDescription("Wireless Headphones");
        p3.setPrice(3000);
        p3.setQuantity(50);
        dao.saveProduct(p3);

        System.out.println("After inserting Headphones:");
        printAll(dao);

        // Update
        p1.setPrice(58000);
        dao.updateProduct(p1);

        System.out.println("After updating Laptop price:");
        printAll(dao);

        // Delete
        dao.deleteProduct(p3.getPid());

        System.out.println("After deleting Mobile:");
        printAll(dao);
    }
}