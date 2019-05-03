package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.ShieldForm;
import com.epam.entity.Shield;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShieldDAOSingletonImpl implements AmmunitionDAO {
    private static ShieldDAOSingletonImpl INSTANCE = null;

    private ShieldDAOSingletonImpl() {

    }

    public Set<Shield> getAll() {
        Set<Shield> shields = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, tax, weigth, material, form  from equipment.shield ");
            addObjToSet(shields, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return shields;
    }

    public Set<Shield> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Shield> getByPassedPrice(Map<String, Double> priceRange) {
        Set<Shield> shields = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, form" +
                    " from equipment.shield where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            ResultSet rs = stmt.executeQuery();
            addObjToSet(shields, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
        }
        return shields;
    }

    private static void addObjToSet(Set<Shield> priceRangeChainArmor, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeChainArmor.add(new Shield(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), rs.getDouble("tax"),
                    ShieldForm.valueOf(rs.getString("form"))));
        }
    }

    public static ShieldDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ShieldDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
