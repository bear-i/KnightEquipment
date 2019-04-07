package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SpearType;
import com.epam.entity.Spear;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SpearDAOImpl implements AmmunitionDAO {

    public Set<Spear> getAll() {
        Set<Spear> spears = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, tax, weigth, material, kind from equipment.spear ");
            addObjToSet(spears, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return spears;
    }

    public Set<Spear> getByPrice() {
        double[] priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Spear> getByPassedPrice(double[] priceRange) {
        Set<Spear> spears = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, kind" +
                    " from equipment.spear where price between ? and ?");
            stmt.setDouble(1, priceRange[0]);
            stmt.setDouble(2, priceRange[1]);
            ResultSet rs = stmt.executeQuery();
            addObjToSet(spears, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return spears;
    }

    private static void addObjToSet(Set<Spear> priceRangeChainArmor, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeChainArmor.add(new Spear(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), rs.getDouble("tax"),
                    SpearType.valueOf(rs.getString("kind"))));
        }
    }
}
