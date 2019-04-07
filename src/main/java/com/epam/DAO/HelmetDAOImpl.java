package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.entity.Helmet;
import com.epam.ammunitionTypes.HelmetForm;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class HelmetDAOImpl implements AmmunitionDAO {

    public Set<Helmet> getAll() {
        Set<Helmet> helmets = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, weigth, material, form  from equipment.helmet ");
            addObjToSet(helmets, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e);
        }
        return helmets;
    }

    public Set<Helmet> getByPrice() {
        double[] priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Helmet> getByPassedPrice(double[] priceRange) {
        Set<Helmet> helmets = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, weigth, material, form" +
                    " from equipment.helmet where price between ? and ?");
            stmt.setDouble(1, priceRange[0]);
            stmt.setDouble(2, priceRange[1]);
            ResultSet rs = stmt.executeQuery();
            addObjToSet(helmets, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return helmets;
    }

    private static void addObjToSet(Set<Helmet> priceRangeChainArmor, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeChainArmor.add(new Helmet(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), HelmetForm.valueOf(rs.getString("form"))));
        }
    }
}
