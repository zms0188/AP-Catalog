package com.autoparts.dao.interfaces;


import com.autoparts.dao.entity.Country;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zms01 on 03.07.2017.
 */
public interface CountryDAO {
    public void addCountry(Country country) throws SQLException;
    public void updateCountry(Country country) throws SQLException;
    public Country getCountryById(Long id) throws SQLException;
    public List getAllCountries()throws SQLException;
    public void deleteCountry(Country country)throws SQLException;
}
