package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.entity.ArmorPlating;
import com.epam.ammunitionTypes.ArmorPlatingKind;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArmorPlatingDAOSingletonImpl implements AmmunitionDAO {
    private static ArmorPlatingDAOSingletonImpl INSTANCE = null;

    private ArmorPlatingDAOSingletonImpl() {
    }

    public Set<ArmorPlating> getAll() {
        Set<ArmorPlating> armorPlating = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("select id, name, price, weigth, material, kind  from equipment.armorplating ");
            addObjToSet(armorPlating, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return armorPlating;
    }

    public Set<ArmorPlating> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<ArmorPlating> getByPassedPrice(Map<String, Double> priceRange) {
        Set<ArmorPlating> priceRangeArmorPl = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, weigth, material, kind " +
                    " from equipment.armorplating where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            rs = stmt.executeQuery();
            addObjToSet(priceRangeArmorPl, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
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

    public static ArmorPlatingDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ArmorPlatingDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
