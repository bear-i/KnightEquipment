package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.SwordLength;
import com.epam.entity.Sword;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SwordDAOSingletonImpl implements AmmunitionDAO {
    private static SwordDAOSingletonImpl INSTANCE = null;

    private SwordDAOSingletonImpl() {

    }

    public Set<Sword> getAll() {
        Set<Sword> swords = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("select id, name, price, tax, weigth, material, length  from equipment.sword ");
            addObjToSet(swords, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return swords;
    }

    public Set<Sword> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Sword> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Sword> swords = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, length" +
                    " from equipment.sword where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            rs = stmt.executeQuery();
            addObjToSet(swords, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
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

    public static SwordDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SwordDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
