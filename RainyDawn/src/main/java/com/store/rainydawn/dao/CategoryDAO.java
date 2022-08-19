package com.store.rainydawn.dao;

import com.store.rainydawn.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Categories, Integer> {

}
