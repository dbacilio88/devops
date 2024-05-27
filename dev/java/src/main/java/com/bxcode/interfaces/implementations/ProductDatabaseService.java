package com.bxcode.interfaces.implementations;

import com.bxcode.dto.Product;
import com.bxcode.interfaces.contracts.IGenericDatabaseService;

import java.util.List;

/**
 * ProductDatabaseService
 * <p>
 * ProductDatabaseService class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class ProductDatabaseService implements IGenericDatabaseService<Product> {


    @Override
    public Product getById(long id) {
        return Product.builder()
                .id(1L)
                .name("Product 1")
                .description("Description 1")
                .build();
    }

    @Override
    public List<Product> getAll() {
        return List.of(Product.builder()
                .id(1L)
                .name("Product 1")
                .description("Description 1")
                .build());
    }
}


