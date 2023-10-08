package com.olavo.finalproject.adm;

import com.olavo.finalproject.common.entity.EntityDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdmDAO extends EntityDAO {

    public ArrayList<AdmDTO> findAll() {
        ArrayList<AdmDTO> list = new ArrayList<>();
        String sql = "select * from adm";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                AdmDTO AdmDTO = new AdmDTO();

                AdmDTO.setId(rs.getInt("adm.id"));
                AdmDTO.setUser(rs.getString("adm.user"));
                AdmDTO.setPassword(rs.getInt("adm.password"));

                list.add(AdmDTO);
            }

        } catch (SQLException e) {
            System.out.println("AdmDAO.findAll: Exception: " + e.getMessage());
            System.out.println("AdmDAO.findAll: SQLState: " + e.getSQLState());
            System.out.println("AdmDAO.findAll: Error: " + e.getErrorCode());
        }
        return list;
    }

}
