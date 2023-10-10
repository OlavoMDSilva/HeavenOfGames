package com.olavo.finalproject.store;

import com.olavo.finalproject.common.entity.EntityController;
import com.olavo.finalproject.game.GameDAO;
import com.olavo.finalproject.game.GameDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreController extends EntityController implements Initializable {

    @FXML
    private Button btnBuy;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnAdd;

    @FXML
    private TableColumn<GameDTO, Integer> colGenre1;

    @FXML
    private TableColumn<GameDTO, String> colGenre2;

    @FXML
    private TableColumn<GameDTO, Double> colPrice1;

    @FXML
    private TableColumn<GameDTO, Double> colPrice2;

    @FXML
    private TableColumn<GameDTO, String> colTitle1;

    @FXML
    private TableColumn<GameDTO, String> colTitle2;

    @FXML
    private Label lblPrice;

    @FXML
    private TableView<GameDTO> tbBuy;

    @FXML
    private TableView<GameDTO> tbGames;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listAllGames();
    }

    public void btnAddClick(ActionEvent event) {
        addToBuy();
    }

    public void btnCancelClick(ActionEvent event) {
        cancel();
    }

    public void btnBuyClick(ActionEvent event) {
        cancel();
    }

    private void listAllGames() {
        colTitle1.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGenre1.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colPrice1.setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<GameDTO> gameList = new GameDAO().findAll();

        tbGames.getItems().clear();
        tbGames.getItems().addAll(gameList);
    }

    private void addToBuy() {
        colTitle2.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGenre2.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colPrice2.setCellValueFactory(new PropertyValueFactory<>("price"));

        int index = tbGames.getSelectionModel().getSelectedIndex();

        tbBuy.getItems().clear();
        tbBuy.getItems().add(tbGames.getItems().get(index));

        double totalPrice = 0;
        for (int i = 0; i < tbBuy.getItems().size(); i++) {
            totalPrice += colPrice2.getCellData(i);
        }
        lblPrice.setText(Double.toString(totalPrice));
    }

    private void cancel() {
        tbBuy.getItems().clear();
        lblPrice.setText("");
    }

}
