package com.olavo.finalproject.company;

import com.olavo.finalproject.common.entity.EntityDAO;
import com.olavo.finalproject.common.entity.EntityDAOInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyDAO extends EntityDAO implements EntityDAOInterface<CompanyDTO> {

    @Override
    public void register(CompanyDTO companyDTO) {
        String sql = "insert into company (name, email, tel) values (?, ?, ?)";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, companyDTO.getName());
            pstm.setString(2, companyDTO.getEmail());
            pstm.setString(3, companyDTO.getPhone());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }

    @Override
    public ArrayList<CompanyDTO> findAll() {
        ArrayList<CompanyDTO> list = new ArrayList<>();
        String sql = "select * from company order by name";
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

    @Override
    public void update(CompanyDTO companyDTO) {
        String sql = "update company set name = ?, email = ?, tel = ? where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, companyDTO.getName());
            pstm.setString(2, companyDTO.getEmail());
            pstm.setString(3, companyDTO.getPhone());
            pstm.setInt(4, companyDTO.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }

    public void delete(CompanyDTO companyDTO) {
        String sql = "delete from company where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, companyDTO.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }

}
