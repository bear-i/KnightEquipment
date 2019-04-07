package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.BowForm;
import com.epam.entity.Bow;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BowDAOImpl implements AmmunitionDAO {

    public Set<Bow> getAll() {
        Set<Bow> bows = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, tax, weigth, material, form  from equipment.bow ");
            addObjToSet(bows, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return bows;
    }

    public Set<Bow> getByPrice() {
        ArrayList<Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Bow> getByPassedPrice(ArrayList<Double> priceRange) {
        Set<Bow> bows = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, form" +
                    " from equipment.bow where price between ? and ?");
            stmt.setDouble(1, priceRange.get(0));
            stmt.setDouble(2, priceRange.get(1));
            ResultSet rs = stmt.executeQuery();
            addObjToSet(bows, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return bows;
    }

    private static void addObjToSet(Set<Bow> priceRangeChainArmor, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeChainArmor.add(new Bow(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), rs.getDouble("tax"),
                    BowForm.valueOf(rs.getString("form"))));
        }
    }
}
