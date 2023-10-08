package com.olavo.finalproject.client;

import com.olavo.finalproject.adm.AdmDTO;
import com.olavo.finalproject.common.entity.EntityDAO;
import com.olavo.finalproject.company.CompanyDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO extends EntityDAO {

    public void register(ClientDTO clientDTO) {
        String sql = "insert into client (name, password, birth_date, email) values (?, ?, ?, ?)";
        try {
            Date born = Date.valueOf(clientDTO.getBorn());
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, clientDTO.getName());
            pstm.setInt(2, clientDTO.getPassword());
            pstm.setDate(3, born);
            pstm.setString(4, clientDTO.getEmail());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("ClientDAO.register: Exception: " + e.getMessage());
            System.out.println("ClientDAO.register: SQLState: " + e.getSQLState());
            System.out.println("ClientDAO.register: Error: " + e.getErrorCode());
        }
    }

    public ArrayList<ClientDTO> findAll() {
        ArrayList<ClientDTO> list = new ArrayList<>();
        String sql = "select * from client";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClientDTO clientDTO = new ClientDTO();

                clientDTO.setId(rs.getInt("client.id"));
                clientDTO.setName(rs.getString("client.name"));
                clientDTO.setUser(rs.getString("client.name"));
                clientDTO.setPassword(rs.getInt("client.password"));
                clientDTO.setBorn(rs.getDate("client.birth_date").toLocalDate());
                clientDTO.setEmail(rs.getString("client.email"));

                list.add(clientDTO);
            }

        } catch (SQLException e) {
            System.out.println("ClientDAO.findAll: Exception: " + e.getMessage());
            System.out.println("ClientDAO.findAll: SQLState: " + e.getSQLState());
            System.out.println("ClientDAO.findAll: Error: " + e.getErrorCode());
        }
        return list;
    }

    public void delete(ClientDTO clientDTO) {
        String sql = "delete from client where email = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, clientDTO.getEmail());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("ClientDAO.delete: Exception: " + e.getMessage());
            System.out.println("ClientDAO.delete: SQLState: " + e.getSQLState());
            System.out.println("ClientDAO.delete: Error: " + e.getErrorCode());
        }
    }

}
