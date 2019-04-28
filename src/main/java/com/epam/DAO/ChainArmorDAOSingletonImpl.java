package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.RingsSize;
import com.epam.entity.*;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChainArmorDAOSingletonImpl implements AmmunitionDAO {
    private static ChainArmorDAOSingletonImpl INSTANCE = null;

    private ChainArmorDAOSingletonImpl() {
    }

    public Set<ChainArmor> getAll() {
        Set<ChainArmor> armorPlating = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("select id, name, price, weigth, material, ringssize  from equipment.chainarmor ");
            addObjToSet(armorPlating, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return armorPlating;
    }

    public Set<ChainArmor> getByPrice() {
        Map<String, Double> priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<ChainArmor> getByPassedPrice(Map<String, Double> priceRange) {
        Set<ChainArmor> priceRangeChainArmor = new HashSet<>();
        try (java.sql.Connection connection = ConnectionFactory.getInstance().getConnection()) {
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, weigth, material, ringssize" +
                    " from equipment.chainarmor where price between ? and ?");
            stmt.setDouble(1, priceRange.get("min"));
            stmt.setDouble(2, priceRange.get("max"));
            rs = stmt.executeQuery();
            addObjToSet(priceRangeChainArmor, rs);
        } catch (SQLException e) {
            System.out.println("ConnectionFactory failed");
        }
        return priceRangeChainArmor;
    }

    private static void addObjToSet(Set<ChainArmor> priceRangeChainArmor, ResultSet rs) throws SQLException {
        while (rs.next()) {
            priceRangeChainArmor.add(new ChainArmor(rs.getInt("id"), rs.getDouble("price"),
                    rs.getInt("weigth"), AmmunitionMaterial.valueOf(rs.getString("material"))
                    , rs.getString("name"), RingsSize.valueOf(rs.getString("ringssize"))));
        }
    }

    public static ChainArmorDAOSingletonImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ArmorPlatingDAOSingletonImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ChainArmorDAOSingletonImpl();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
