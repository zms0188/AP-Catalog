package com.autoparts.dao.interfaces;


import com.autoparts.dao.entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zms01 on 03.07.2017.
 */
public interface CategoryDAO {
    public void addCategory(Category category) throws SQLException;
    public void updateCategory(Category category) throws SQLException;
    public Category getCategoryById(Long id) throws SQLException;
    public List getAllCategories()throws SQLException;
    public void deleteCategory(Category category)throws SQLException;
}
