package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.custom.impl.StockDAOImpl;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.StockAtStore;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class ClickHamburgerAddNewStockFormController {
    public JFXTextField txtBrandName;
    @FXML
    private BorderPane brdrPaneClickAddNewStock;

    @FXML
    private Pane leftPane;

    @FXML
    private Circle userProfile;

    @FXML
    private Label lblUserName;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnProfileSettings;

    @FXML
    private JFXButton btnSupplierDirectory;

    @FXML
    private JFXButton btnViewNotes;

    @FXML
    private JFXButton btnViewStatics;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnInventory;

    @FXML
    private JFXButton btnHamburger;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtStockCode;

    @FXML
    private JFXTextField txtItemDescription;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXTextField txtUnitRate;

    @FXML
    private JFXButton btnEnter;

    @FXML
    private JFXComboBox<String> cmbMeasuredUnits;

    @FXML
    private JFXComboBox<String> cmbSubCategory;

    @FXML
    private JFXComboBox<String> cmbBrandName;
    AddNewStockFormController addNewStockFormController = new AddNewStockFormController();

    @FXML
    private JFXComboBox<String> cmbCategory;
    StockDAOImpl stockDAOImpl = new StockDAOImpl();
    public void initialize(){
        ObservableList <String> unitsList = FXCollections.observableArrayList("Nos","Kilogram","Liters","Meters","Packets");
        cmbMeasuredUnits.setItems(unitsList);

        ObservableList <String> categoryList = FXCollections.observableArrayList("Grocery","Dairy","Homeware","Meat and Fish","Personal Care","Baby Needs","Frozen Items","Fruits and Vegetables");
        cmbCategory.setItems(categoryList);

        cmbCategory.setOnAction(actionEvent -> {
            if (cmbCategory.getSelectionModel().getSelectedItem().equals("Grocery")){
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Condiments","Spices","Biscuits","Confectionary","Rice","Pasta","Milk Powder","Sauce");
                cmbSubCategory.setItems(subCategoryList);
                System.out.println("Grocery");
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Dairy")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Cheese" ,"Milk","Butter","Chilled Milk","Dessert");
                cmbSubCategory.setItems(subCategoryList);

            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Homeware")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Sports","Stationary","Brooms","Mats","Kitchen");
                cmbSubCategory.setItems(subCategoryList);

            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Meat and Fish")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Meat","Fish");
                cmbSubCategory.setItems(subCategoryList);
            }else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Personal Care")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Shampoo and conditioner","Deodorant","Personal Needs","Face and Cleaning","Creams");
                cmbSubCategory.setItems(subCategoryList);
            }else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Baby Needs")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Baby Food", "Baby Sanity");
                cmbSubCategory.setItems(subCategoryList);
            }else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Frozen Items")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Ice cream");
                cmbSubCategory.setItems(subCategoryList);
            }else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Fruits and Vegetables")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Fruits","Vegetables");
                cmbSubCategory.setItems(subCategoryList);
            }else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Confectionary")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Chocalate","Cake","Sweets");
                cmbSubCategory.setItems(subCategoryList);
            }


        });

        cmbSubCategory.setOnAction(actionEvent -> {
            if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Biscuits")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Maliban", "Munchee", "Little Lion");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Condiments")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("McCurrie", "Kist", "MD", "Maggie", "Heinz", "Mayura", "Colmans", "Renuka");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Spices")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("McCurrie", "Ruhunu", "Wijaya","Nature","Dil" ,"MA's Kitchen","Rich");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Rice")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Nipuna","Rathna","Araliya","Hiru","Hansana");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Pasta")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Prima","Harischandra","Raigam","Roza","Pastaricco","Colavita");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Milk Powder")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Bonlac","Anlene","Palwatte","Maliban","Anchor","Raththi","Nesle");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Sauce")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("KVC","Kist","MD","Heinz","Edin","Fortune");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Stationary")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Acron","Maped","Atlas","Nataraj","Richard","Link","Weerodara");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Kitchen")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Morphy Richard","Panasonic","Olan");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Meat")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Not Applicable");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Fish")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Not Applicable");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Shampoo and Conditioner")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Dandex","Head and Shoulders","Lifebouy","Panteene","Nature Secrets");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Deodorant")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Janet","Dettol","Capri","Enchanter");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Personal Needs")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Forever","Dettol","Capri","Enchanter");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Cheese")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Kothmale","Palwatte","Happy Cow","Anchor");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Milk")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Kothmale","RichLife","Daily Active","Anchor");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Chilled Milk")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("RichLife","Highland","Kothmale");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Dessert")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Highland","Kothmale","Newdale","Anchor");
                cmbBrandName.setItems(subCategoryList);
            }else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Confectionary")) {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Revello","Ritzberry","Ferrero","Kandos","Cadberry","Tiyara","Delta");
                cmbBrandName.setItems(subCategoryList);

            }else {
                ObservableList <String> subCategoryList = FXCollections.observableArrayList("Not Applicable");
                cmbSubCategory.setItems(subCategoryList);
            }
        });

    }


    @FXML
    void BtnSupplierDirectoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdrPaneClickAddNewStock);

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdrPaneClickAddNewStock);

    }

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_HAM_STORE,brdrPaneClickAddNewStock);

    }

    @FXML
    void btnEnterOnAction(ActionEvent event) {
        String stockCode = txtStockCode.getText();
        String itemDescription = txtItemDescription.getText();
        double qtyOnHand = Double.parseDouble(txtQtyOnHand.getText());
        String measuredUnits = cmbMeasuredUnits.getSelectionModel().getSelectedItem().toString();
        double unitRate = Double.parseDouble(txtUnitRate.getText());
        String category = cmbCategory.getSelectionModel().getSelectedItem().toString();

        String subCategory = cmbSubCategory.getSelectionModel().getSelectedItem().toString();
        String brand = cmbBrandName.getSelectionModel().getSelectedItem().toString();

        StockDTO stockAtStore = new StockDTO(stockCode,itemDescription,qtyOnHand,measuredUnits,unitRate,category,subCategory,brand);

        try {
            boolean isAdded = stockDAOImpl.add(new StockAtStore(stockAtStore.getStockCode(),stockAtStore.getItemDescription(),stockAtStore.getQtyOnHand(),stockAtStore.getMeasuredUnits(),stockAtStore.getUnitRate(),stockAtStore.getCategory(),stockAtStore.getSubCategory(),stockAtStore.getBrand(),stockAtStore.getImgSrc()));
            if (isAdded){
                Notifications notifications = Notifications.create().text("Stock Added Successfully").title("Add Stock").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                notifications.showInformation();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }




    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_HAM_DASHBOARD,brdrPaneClickAddNewStock);

    }

    @FXML
    void btnInventoryOnAction(ActionEvent event) {


    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_STORE_NOTES,brdrPaneClickAddNewStock);

    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtStockCode.setText("");
        txtItemDescription.setText("");
        txtQtyOnHand.setText("");
        cmbMeasuredUnits.setValue("");
        txtUnitRate.setText("");
        cmbCategory.setAccessibleText("");
        cmbSubCategory.setAccessibleText("");
        cmbBrandName.setAccessibleText("");
    }
}
