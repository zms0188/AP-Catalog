/**
 * Created by zms01 on 20.06.2017.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.autoparts.dao.Factory;
import com.autoparts.dao.entity.Automobile;
import com.autoparts.dao.entity.Autopart;
import com.autoparts.dao.entity.Country;
import com.autoparts.dao.entity.Manufacturer;
import org.hibernate.annotations.GenericGenerator;
import com.autoparts.dao.HibernateUtil;

import javax.persistence.*;
import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws SQLException {

        Country country = Factory.getInstance().getCountryDAO().getCountryById((long) 1);
        Manufacturer manufacturer = Factory.getInstance().getManufacturerDAO().getManufacturerById((long) 2);
        Manufacturer manufacturer1 = Factory.getInstance().getManufacturerDAO().getManufacturerById((long) 5);
        Set<Manufacturer> manufacturers = new HashSet<>();
        manufacturers.add(manufacturer);
        manufacturers.add(manufacturer1);


        country.setManufacturers(manufacturers);
        Factory.getInstance().getCountryDAO().updateCountry(country);


        List<Manufacturer> manufacturers2 = Factory.getInstance().getManufacturerDAO().getAllManufacturers();
        System.out.println("=======All Autoparts=====");
        for (int i = 0; i < manufacturers2.size(); i++) {
            System.out.println("Autopart name is: " + manufacturers2.get(i).getTitle() + " Price is: " + manufacturers2.get(i).getCountry());
        }
    }
}






