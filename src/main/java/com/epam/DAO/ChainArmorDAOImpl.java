package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.RingsSize;
import com.epam.entity.*;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ChainArmorDAOImpl implements AmmunitionDAO {

    public Set<ChainArmor> getAll() {
        Set<ChainArmor> armorPlating = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, price, weigth, material, ringssize  from equipment.chainarmor ");
            addObjToSet(armorPlating, rs);
        } catch (SQLException e) {
            System.out.println("Failed connection: " + e);
        }
        return armorPlating;
    }

    public Set<ChainArmor> getByPrice() {
        double[] priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<ChainArmor> getByPassedPrice(double[] priceRange) {
        Set<ChainArmor> priceRangeChainArmor = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, weigth, material, ringssize" +
                    " from equipment.chainarmor where price between ? and ?");
            stmt.setDouble(1, priceRange[0]);
            stmt.setDouble(2, priceRange[1]);
            ResultSet rs = stmt.executeQuery();
            addObjToSet(priceRangeChainArmor, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
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
}
