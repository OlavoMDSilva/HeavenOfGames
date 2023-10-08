package com.olavo.finalproject.company;

import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompanyController extends EntityController implements Initializable {

    @FXML
    private TextField edtEmail;

    @FXML
    private TextField edtName;

    @FXML
    private TextField edtPhone;

    @FXML
    private TableView<CompanyDTO> tbShow;

    @FXML
    private TableColumn<CompanyDTO, Integer> colId;

    @FXML
    private TableColumn<CompanyDTO, String> colName;

    @FXML
    private TableColumn<CompanyDTO, String> colEmail;

    @FXML
    private TableColumn<CompanyDTO, String> colPhone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listAll();
    }

    public void btnRegisterClick(ActionEvent event) {
        register();
        clear();
        listAll();
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
        CompanyDTO companyDTO = new CompanyDTO();
        CompanyDAO companyDAO = new CompanyDAO();

        companyDTO.setName(edtName.getText());
        companyDTO.setEmail(edtEmail.getText());
        companyDTO.setPhone(edtPhone.getText());

        companyDAO.register(companyDTO);
    }

    private void listAll() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        ArrayList<CompanyDTO> list = new CompanyDAO().findAll();

        tbShow.getItems().clear();
        tbShow.getItems().addAll(list);
    }

    private void delete() {
        int index = tbShow.getSelectionModel().getSelectedIndex();
        CompanyDTO companyDTO = new CompanyDTO();
        CompanyDAO companyDAO = new CompanyDAO();

        companyDTO.setId(colId.getCellData(index));

        companyDAO.delete(companyDTO);
    }

    private void update() {
        int index = tbShow.getSelectionModel().getSelectedIndex();
        CompanyDTO companyDTO = new CompanyDTO();
        CompanyDAO companyDAO = new CompanyDAO();

        companyDTO.setId(colId.getCellData(index));
        companyDTO.setName(edtName.getText());
        companyDTO.setEmail(edtEmail.getText());
        companyDTO.setPhone(edtPhone.getText());

        companyDAO.update(companyDTO);
    }

    private void clear() {
        edtName.setText("");
        edtEmail.setText("");
        edtPhone.setText("");
    }

}
