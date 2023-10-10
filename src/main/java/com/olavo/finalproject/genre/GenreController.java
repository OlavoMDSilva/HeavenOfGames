package com.olavo.finalproject.genre;

import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GenreController extends EntityController implements Initializable {

    @FXML
    private TextField edtName;
    
    @FXML
    private TableView<GenreDTO> tbShow;

    @FXML
    private TableColumn<GenreDTO, Integer> colId;

    @FXML
    private TableColumn<GenreDTO, String> colGenre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listAll();
    }

    public void btnRegisterClick(ActionEvent event) {
        if (checkGenre()) {
            register();
            clear();
            listAll();
        }
    }

    public void btnUpdateClick(ActionEvent event) {
        update();
        clear();
        listAll();
    }

    public void btnDeleteClick(ActionEvent event) {
        delete();
        clear();
        listAll();
    }

    private void register() {
        GenreDTO GenreDTO = new GenreDTO();
        GenreDAO GenreDAO = new GenreDAO();

        GenreDTO.setName(edtName.getText());

        GenreDAO.register(GenreDTO);
    }

    private void listAll() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("name"));

        ArrayList<GenreDTO> list = new GenreDAO().findAll();

        tbShow.getItems().clear();
        tbShow.getItems().addAll(list);
    }

    private void delete() {
        int index = tbShow.getSelectionModel().getSelectedIndex();
        GenreDTO GenreDTO = new GenreDTO();
        GenreDAO GenreDAO = new GenreDAO();

        GenreDTO.setId(colId.getCellData(index));

        GenreDAO.delete(GenreDTO);
    }

    private void update() {
        int index = tbShow.getSelectionModel().getSelectedIndex();
        GenreDTO GenreDTO = new GenreDTO();
        GenreDAO GenreDAO = new GenreDAO();

        GenreDTO.setId(colId.getCellData(index));
        GenreDTO.setName(edtName.getText());

        GenreDAO.update(GenreDTO);
    }

    private void clear() {
        edtName.setText("");
    }

    private boolean checkGenre() {
        return !edtName.getText().equals("");
    }

}
