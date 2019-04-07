package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SwordLength;
import com.epam.entity.Sword;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SwordDAOImpl implements AmmunitionDAO {

    public Set<Sword> getAll() {
        Set<Sword> swords = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, tax, weigth, material, length  from equipment.sword ");
            addObjToSet(swords, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return swords;
    }

    public Set<Sword> getByPrice() {
        double[] priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Sword> getByPassedPrice(double[] priceRange) {
        Set<Sword> swords = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, length" +
                    " from equipment.sword where price between ? and ?");
            stmt.setDouble(1, priceRange[0]);
            stmt.setDouble(2, priceRange[1]);
            ResultSet rs = stmt.executeQuery();
            addObjToSet(swords, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return swords;
    }

    private static void addObjToSet(Set<Sword> priceRangeChainArmor, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeChainArmor.add(new Sword(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), rs.getDouble("tax"),
                    SwordLength.valueOf(rs.getString("length"))));
        }
    }
}
