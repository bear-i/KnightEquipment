package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.entity.ArmorPlating;
import com.epam.ammunitionTypes.ArmorPlatingKind;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArmorPlatingDAOImpl implements AmmunitionDAO {

    public Set<ArmorPlating> getAll() {
        Set<ArmorPlating> armorPlating = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, weigth, material, kind  from equipment.armorplating ");
            addObjToSet(armorPlating, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return armorPlating;
    }

    public Set<ArmorPlating> getByPrice() {
        ArrayList<Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<ArmorPlating> getByPassedPrice(ArrayList<Double> priceRange) {
        Set<ArmorPlating> priceRangeArmorPl = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, weigth, material, kind " +
                    " from equipment.armorplating where price between ? and ?");
            stmt.setDouble(1, priceRange.get(0));
            stmt.setDouble(2, priceRange.get(1));
            ResultSet rs = stmt.executeQuery();
            addObjToSet(priceRangeArmorPl, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return priceRangeArmorPl;
    }

    private static void addObjToSet(Set<ArmorPlating> priceRangeArmorPl, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeArmorPl.add(new ArmorPlating(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), ArmorPlatingKind.valueOf(rs.getString("kind"))));
        }
    }
}
