package com.autoparts.dao.interfaces;


import com.autoparts.dao.entity.Automobile;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zms01 on 03.07.2017.
 */
public interface AutomobileDAO {
    public void addAutomobile(Automobile automobile) throws SQLException;
    public void updateAutomobile(Automobile automobile) throws SQLException;
    public Automobile getAutomobileById(Long id) throws SQLException;
    public List getAllAutomobiles()throws SQLException;
    public void deleteAutomobile(Automobile automobile)throws SQLException;
}
