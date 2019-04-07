package com.epam.DAO;

import com.epam.ammunitionTypes.AmmunitionMaterial;
import com.epam.ammunitionTypes.ShieldForm;
import com.epam.entity.Shield;
import com.epam.service.InputServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ShieldDAOImpl {

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
        double[] priceRange = new InputServiceImpl().getPriceRange();
        return getByPassedPrice(priceRange);
    }

    public Set<Shield> getByPassedPrice(double[] priceRange) {
        Set<Shield> shields = new HashSet<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select id, name, price, tax, weigth, material, form" +
                    " from equipment.shield where price between ? and ?");
            stmt.setDouble(1, priceRange[0]);
            stmt.setDouble(2, priceRange[1]);
            ResultSet rs = stmt.executeQuery();
            addObjToSet(shields, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
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
}
