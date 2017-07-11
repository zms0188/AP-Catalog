/**
 * Created by zms01 on 20.06.2017.
 */
import com.autoparts.dao.Factory;
import com.autoparts.dao.entity.Autopart;
import com.autoparts.dao.entity.Country;
import com.autoparts.dao.entity.Manufacturer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        Autopart a1 = new Autopart();
        Autopart a2 = new Autopart();
        Autopart a3 = new Autopart();
        Autopart a4 = new Autopart();
        Autopart a5 = new Autopart();
        Autopart a6 = new Autopart();
        Autopart a7 = new Autopart();
        Autopart a8 = new Autopart();

        a1.setTitle("Вал распределительный"); a1.setPrice(788.00);
        a2.setTitle("Катаколлектор");a2.setPrice(3100.00);
        a3.setTitle("Подушки стабилизатора");a3.setPrice(44.20);
        a4.setTitle("Вал коленчатый");a4.setPrice(2250.74);
        a5.setTitle("Резина 225/50 R 16");a5.setPrice(2100.00);
        a6.setTitle("Глушитель основной");a6.setPrice(678.00);
        a7.setTitle("Уплотнитель багажника");a7.setPrice(210.50);
        a8.setTitle("Ролик ГРМ");a8.setPrice(410.00);



        Factory.getInstance().getAutopartDAO().addAutopart(a1);
        Factory.getInstance().getAutopartDAO().addAutopart(a2);
        Factory.getInstance().getAutopartDAO().addAutopart(a3);
        Factory.getInstance().getAutopartDAO().addAutopart(a4);
        Factory.getInstance().getAutopartDAO().addAutopart(a5);
        Factory.getInstance().getAutopartDAO().addAutopart(a6);
        Factory.getInstance().getAutopartDAO().addAutopart(a7);
        Factory.getInstance().getAutopartDAO().addAutopart(a8);


        List<Autopart> autoparts = Factory.getInstance().getAutopartDAO().getAllAutoparts();
        System.out.println("=======All Autoparts=====");
        for (int i = 0; i < autoparts.size(); i++) {
            System.out.println("Autopart name is: " + autoparts.get(i).getTitle() +"Price is: "+autoparts.get(i).getPrice());
        }
    }
}


