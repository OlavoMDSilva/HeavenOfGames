package com.olavo.finalproject.company;

import com.olavo.finalproject.common.entity.EntityDAO;
import com.olavo.finalproject.common.entity.EntityDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyDAO extends EntityDAO {

    public void register(EntityDTO entityDTO) {
        String sql = "insert into company (name, email, tel) values (?, ?, ?)";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, entityDTO.getName());
            pstm.setString(2, entityDTO.getEmail());
            pstm.setString(3, entityDTO.getPhone());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }

    public ArrayList<CompanyDTO> findAll() {
        ArrayList<CompanyDTO> list = new ArrayList<>();
        String sql = "select * from company";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                CompanyDTO companyDTO = new CompanyDTO();

                companyDTO.setId(rs.getInt("company.id"));
                companyDTO.setName(rs.getString("company.name"));
                companyDTO.setEmail(rs.getString("company.email"));
                companyDTO.setPhone(rs.getString("company.tel"));

                list.add(companyDTO);
            }

        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
        return list;
    }

    public void delete(EntityDTO entityDTO) {
        String sql = "delete from company where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, entityDTO.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }

    public void update(EntityDTO entityDTO) {
        String sql = "update company set name = ?, email = ?, tel = ? where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, entityDTO.getName());
            pstm.setString(2, entityDTO.getEmail());
            pstm.setString(3, entityDTO.getPhone());
            pstm.setInt(4, entityDTO.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }
}
