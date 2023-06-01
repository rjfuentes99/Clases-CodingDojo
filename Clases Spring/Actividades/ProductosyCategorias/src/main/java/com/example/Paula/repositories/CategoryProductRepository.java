package com.example.Paula.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Paula.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository <CategoryProduct, Long> {
}
