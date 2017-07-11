package com.autoparts.dao.interfaces;


import com.autoparts.dao.entity.Autopart;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zms01 on 03.07.2017.
 */
public interface AutopartDAO {
    public void addAutopart(Autopart autopart) throws SQLException;
    public void updateAutopart(Autopart autopart) throws SQLException;
    public Autopart getAutopartById(Long id) throws SQLException;
    public List getAllAutoparts()throws SQLException;
    public void deleteAutopart(Autopart autopart)throws SQLException;
}
