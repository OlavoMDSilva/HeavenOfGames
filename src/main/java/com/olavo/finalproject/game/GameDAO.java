package com.olavo.finalproject.game;

import com.olavo.finalproject.common.entity.EntityDAO;
import com.olavo.finalproject.common.entity.EntityDAOInterface;

import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class GameDAO extends EntityDAO implements EntityDAOInterface<GameDTO> {

    @Override
    public void register(GameDTO entity) {
        String sql = "insert into game (title, launch_date, idiom, platform, price, cod_genre, cod_company) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        try {
            Date launched = Date.valueOf(entity.getLaunchedDate());
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, entity.getName());
            pstm.setDate(2, launched);
            pstm.setString(3, entity.getIdiom());
            pstm.setString(4, entity.getPlatform());
            pstm.setDouble(5, entity.getPrice());
            pstm.setInt(6, entity.getCodGenre());
            pstm.setInt(7, entity.getCodCompany());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("CompanyDAO.register: Exception: " + e.getMessage());
            System.out.println("CompanyDAO.register: SQLState: " + e.getSQLState());
            System.out.println("CompanyDAO.register: Error: " + e.getErrorCode());
        }
    }

    @Override
    public ArrayList<GameDTO> findAll() {
        ArrayList<GameDTO> list = new ArrayList<>();
        String sql = "select * from game";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                GameDTO gameDTO = new GameDTO();

                gameDTO.setId(rs.getInt("game.id"));
                gameDTO.setName(rs.getString("game.title"));
                gameDTO.setLaunchedDate(rs.getDate("game.launch_date").toLocalDate());
                gameDTO.setIdiom(rs.getString("game.idiom"));
                gameDTO.setPlatform(rs.getString("game.platform"));
                gameDTO.setPrice(rs.getDouble("game.price"));
                gameDTO.setCodGenre(rs.getInt("game.cod_genre"));
                gameDTO.setCodCompany(rs.getInt("game.cod_company"));

                list.add(gameDTO);
            }

        } catch (SQLException e) {
            System.out.println("GameDAO.register: Exception: " + e.getMessage());
            System.out.println("GameDAO.register: SQLState: " + e.getSQLState());
            System.out.println("GameDAO.register: Error: " + e.getErrorCode());
        }
        return list;
    }

    @Override
    public void update(GameDTO entity) {
        String sql = "update game set title = ?, launch_date = ?, idiom = ?, platform = ?, " +
                "price = ?, cod_genre = ?, cod_company = ? where id = ?";
        try {
            Date launched = Date.valueOf(entity.getLaunchedDate());
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, entity.getName());
            pstm.setDate(2, launched);
            pstm.setString(3, entity.getIdiom());
            pstm.setString(4, entity.getPlatform());
            pstm.setDouble(5, entity.getPrice());
            pstm.setInt(6, entity.getCodGenre());
            pstm.setInt(7, entity.getCodCompany());
            pstm.setInt(8, entity.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("GameDAO.register: Exception: " + e.getMessage());
            System.out.println("GameDAO.register: SQLState: " + e.getSQLState());
            System.out.println("GameDAO.register: Error: " + e.getErrorCode());
        }
    }

    @Override
    public void delete(GameDTO entity) {
        String sql = "delete from game where id = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, entity.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("GameDAO.register: Exception: " + e.getMessage());
            System.out.println("GameDAO.register: SQLState: " + e.getSQLState());
            System.out.println("GameDAO.register: Error: " + e.getErrorCode());
        }
    }

}
