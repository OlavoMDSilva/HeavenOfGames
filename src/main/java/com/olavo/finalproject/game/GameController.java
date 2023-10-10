package com.olavo.finalproject.game;

import com.olavo.finalproject.common.entity.EntityController;
import com.olavo.finalproject.company.CompanyDAO;
import com.olavo.finalproject.company.CompanyDTO;
import com.olavo.finalproject.genre.GenreDAO;
import com.olavo.finalproject.genre.GenreDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController extends EntityController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cbCompany;

    @FXML
    private ComboBox<String> cbGenre;

    @FXML
    private TableView<GameDTO> tbShow;

    @FXML
    private TableColumn<GameDTO, String> colCompany;

    @FXML
    private TableColumn<GameDTO, String> colGenre;

    @FXML
    private TableColumn<GameDTO, Integer> colId;

    @FXML
    private TableColumn<GameDTO, String> colIdiom;

    @FXML
    private TableColumn<GameDTO, LocalDate> colLaunched;

    @FXML
    private TableColumn<GameDTO, String> colPlatform;

    @FXML
    private TableColumn<GameDTO, Double> colPrice;

    @FXML
    private TableColumn<GameDTO, String> colTitle;

    @FXML
    private DatePicker dpDate;

    @FXML
    private TextField edtIdiom;

    @FXML
    private TextField edtPlatform;

    @FXML
    private TextField edtPrice;

    @FXML
    private TextField edtName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGenres();
        loadCompanies();
        listAll();
    }

    public void btnRegisterClick(ActionEvent event) {
        if (checkAll()) {
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
        GameDTO gameDTO = new GameDTO();
        GameDAO gameDAO = new GameDAO();
        ArrayList<GenreDTO> genreList = new GenreDAO().findAll();
        ArrayList<CompanyDTO> companyList = new CompanyDAO().findAll();

        int genreIndex = cbGenre.getSelectionModel().getSelectedIndex();
        int companyIndex = cbCompany.getSelectionModel().getSelectedIndex();

        gameDTO.setName(edtName.getText());
        gameDTO.setLaunchedDate(dpDate.getValue());
        gameDTO.setIdiom(edtIdiom.getText());
        gameDTO.setPlatform(edtPlatform.getText());
        gameDTO.setPrice(Double.parseDouble(edtPrice.getText()));
        gameDTO.setCodGenre(genreList.get(genreIndex).getId());
        gameDTO.setCodCompany(companyList.get(companyIndex).getId());

        gameDAO.register(gameDTO);
    }

    private void listAll() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("name"));
        colIdiom.setCellValueFactory(new PropertyValueFactory<>("idiom"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colLaunched.setCellValueFactory(new PropertyValueFactory<>("launchedDate"));
        colPlatform.setCellValueFactory(new PropertyValueFactory<>("platform"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colCompany.setCellValueFactory(new PropertyValueFactory<>("company"));

        ArrayList<GameDTO> list = new GameDAO().findAll();

        tbShow.getItems().clear();
        tbShow.getItems().addAll(list);
    }

    private void update() {
        int index = tbShow.getSelectionModel().getSelectedIndex();
        GameDTO gameDTO = new GameDTO();
        GameDAO gameDAO = new GameDAO();
        ArrayList<GenreDTO> genreList = new GenreDAO().findAll();
        ArrayList<CompanyDTO> companyList = new CompanyDAO().findAll();

        int genreIndex = cbGenre.getSelectionModel().getSelectedIndex();
        int companyIndex = cbCompany.getSelectionModel().getSelectedIndex();

        gameDTO.setId(colId.getCellData(index));
        gameDTO.setName(edtName.getText());
        gameDTO.setLaunchedDate(dpDate.getValue());
        gameDTO.setIdiom(edtIdiom.getText());
        gameDTO.setPlatform(edtPlatform.getText());
        gameDTO.setPrice(Double.parseDouble(edtPrice.getText()));
        gameDTO.setCodGenre(genreList.get(genreIndex).getId());
        gameDTO.setCodCompany(companyList.get(companyIndex).getId());

        gameDAO.update(gameDTO);
    }

    private void delete() {
        int index = tbShow.getSelectionModel().getSelectedIndex();
        GameDTO gameDTO = new GameDTO();
        GameDAO gameDAO = new GameDAO();

        gameDTO.setId(colId.getCellData(index));

        gameDAO.delete(gameDTO);
    }

    private void clear() {
        edtName.setText("");
        edtIdiom.setText("");
        edtPlatform.setText("");
        edtPrice.setText("");
    }

    private void loadGenres() {
        GenreDAO genreDAO = new GenreDAO();

        ArrayList<GenreDTO> list = genreDAO.findAll();

        for (GenreDTO genreDTO : list) {
            cbGenre.getItems().add(genreDTO.getName());
        }
    }

    private void loadCompanies() {
        CompanyDAO companyDAO = new CompanyDAO();

        ArrayList<CompanyDTO> list = companyDAO.findAll();

        for (CompanyDTO companyDTO : list) {
            cbCompany.getItems().add(companyDTO.getName());
        }
    }

    private boolean checkAll() {
        if (!checkName()) return false;
        if (!checkDate()) return false;
        if (!checkIdiom()) return false;
        if (!checkPlatform()) return false;
        if (!checkPrice()) return false;
        if (!checkGenre()) return false;
        return (!checkCompany());
    }

    private boolean checkName() {
        if (edtName.getText().equals("")) {
            edtName.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkDate() {
        if ((dpDate.getValue() == null)) {
            dpDate.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkIdiom() {
        String idiom = edtIdiom.getText();
        if (idiom.matches("[0-9]") || idiom.equals("")) {
            edtIdiom.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkPlatform() {
        String platform = edtPlatform.getText();
        if (platform.matches("[0-9]") || platform.equals("")) {
            edtPlatform.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkPrice() {
        String price = edtPrice.getText();
        if (price.matches("[0-9]") || price.equals("")) {
            edtPrice.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkGenre() {
        if (cbGenre.getSelectionModel().getSelectedIndex() == 0) {
            cbGenre.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkCompany() {
        if (cbCompany.getSelectionModel().getSelectedIndex() == 0) {
            cbCompany.requestFocus();
            return false;
        }
        return true;
    }

}
