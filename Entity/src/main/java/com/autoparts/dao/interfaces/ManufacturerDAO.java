package com.autoparts.dao.interfaces;


import com.autoparts.dao.entity.Manufacturer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zms01 on 03.07.2017.
 */
public interface ManufacturerDAO {
    public void addManufacturer(Manufacturer manufacturer) throws SQLException;
    public void updateManufacturer(Manufacturer manufacturer) throws SQLException;
    public Manufacturer getManufacturerById(Long id) throws SQLException;
    public List getAllManufacturers()throws SQLException;
    public void deleteManufacturer(Manufacturer manufacturer)throws SQLException;
}
