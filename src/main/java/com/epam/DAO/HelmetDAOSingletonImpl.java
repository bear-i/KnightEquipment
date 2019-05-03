package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.entity.Helmet;
import com.epam.ammunitionTypes.HelmetForm;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HelmetDAOSingletonImpl implements AmmunitionDAO {
    private static HelmetDAOSingletonImpl INSTANCE = null;

    private HelmetDAOSingletonImpl() {

    }

    public Set<Helmet> getAll() {
        Set<Helmet> helmets = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, weigth, material, form  from equipment.helmet ");
            addObjToSet(helmets, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed: " + e);
        }
        return helmets;
    }

    public Set<Helmet> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Helmet> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Helmet> helmets = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, weigth, material, form" +
                    " from equipment.helmet where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            ResultSet rs = stmt.executeQuery();
            addObjToSet(helmets, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
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

    public static HelmetDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HelmetDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
