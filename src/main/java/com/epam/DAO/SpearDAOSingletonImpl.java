package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SpearType;
import com.epam.entity.Spear;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SpearDAOSingletonImpl implements AmmunitionDAO {
    private static SpearDAOSingletonImpl INSTANCE = null;

    private SpearDAOSingletonImpl() {

    }

    public Set<Spear> getAll() {
        Set<Spear> spears = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("select id, name, price, tax, weigth, material, kind from equipment.spear ");
            addObjToSet(spears, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return spears;
    }

    public Set<Spear> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Spear> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Spear> spears = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, kind" +
                    " from equipment.spear where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            rs = stmt.executeQuery();
            addObjToSet(spears, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
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

    public static SpearDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SpearDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
