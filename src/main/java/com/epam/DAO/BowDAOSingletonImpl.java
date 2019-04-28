package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.BowForm;
import com.epam.entity.Bow;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BowDAOSingletonImpl implements AmmunitionDAO {
    private static BowDAOSingletonImpl INSTANCE = null;

    private BowDAOSingletonImpl() {

    }

    public Set<Bow> getAll() {
        Set<Bow> bows = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("select id, name, price, tax, weigth, material, form  from equipment.bow ");
            addObjToSet(bows, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return bows;
    }

    public Set<Bow> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Bow> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Bow> bows = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, form" +
                    " from equipment.bow where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            rs = stmt.executeQuery();
            addObjToSet(bows, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
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

    public static BowDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BowDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
