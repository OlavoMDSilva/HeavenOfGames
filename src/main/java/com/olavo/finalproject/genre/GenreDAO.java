package com.olavo.finalproject.genre;

import com.olavo.finalproject.common.entity.EntityDAO;
import com.olavo.finalproject.common.entity.EntityDAOInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class GenreDAO extends EntityDAO implements EntityDAOInterface<GenreDTO> {


    @Override
    public void register(GenreDTO entity) {
        String sql = "insert into genre (genre) values (?)";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, entity.getName());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("GenreDAO.register: Exception: " + e.getMessage());
            System.out.println("GenreDAO.register: SQLState: " + e.getSQLState());
            System.out.println("GenreDAO.register: Error: " + e.getErrorCode());
        }
    }

    @Override
    public ArrayList<GenreDTO> findAll() {
        ArrayList<GenreDTO> list = new ArrayList<>();
        String sql = "select * from genre order by genre";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                GenreDTO genreDTO = new GenreDTO();

                genreDTO.setId(rs.getInt("genre.id"));
                genreDTO.setName(rs.getString("genre.genre"));

                list.add(genreDTO);
            }

        } catch (SQLException e) {
            System.out.println("CompanyDAO.findAll: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.findAll: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.findAll: Error: " + e.getErrorCode());
        }
        return list;
    }

    @Override
    public void update(GenreDTO entity) {
        String sql = "update genre set genre = ? where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, entity.getName());
            pstm.setInt(2, entity.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.update: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.update: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.update: Error: " + e.getErrorCode());
        }
    }

    @Override
    public void delete(GenreDTO entity) {
        String sql = "delete from genre where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, entity.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.delete: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.delete: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.delete: Error: " + e.getErrorCode());
        }
    }

}
