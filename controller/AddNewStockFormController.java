package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.StockBO;
import lk.ijse.finalproject.bo.custom.impl.StockBoImpl;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.custom.impl.StockDAOImpl;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;
import rex.utils.S;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

public class AddNewStockFormController {

    public JFXComboBox<String> cmbBrandName;
    public JFXButton btnHamburger;
    public BorderPane brdrStoreDashboard;
    public JFXButton btnBrowseImage;
    public JFXTextField txtImagePath;
    public ImageView imgSrc;
    public Label lblUnits;
    public Label lblSub;
    public Label lblBrand;
    public Label lblCategory;
    @FXML
    private BorderPane brdrPaneAddNewStock;

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
    private JFXComboBox<String> cmbCategory;

    @FXML
    private JFXComboBox<String> cmbSubCategory;

    private FileInputStream fileInputStream;

    private File file;


    @FXML
    private JFXComboBox<String> cmbMeasuredUnits;
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);

    public void initialize() {
        ObservableList<String> unitsList = FXCollections.observableArrayList("Nos", "Kilogram", "Liters", "Meters", "Packets");
        cmbMeasuredUnits.setItems(unitsList);

        ObservableList<String> categoryList = FXCollections.observableArrayList("Grocery", "Dairy", "Homeware", "Meat and Fish", "Personal Care", "Baby Needs", "Frozen Items", "Fruits and Vegetables");
        cmbCategory.setItems(categoryList);

        cmbCategory.setOnAction(actionEvent -> {
            if (cmbCategory.getSelectionModel().getSelectedItem().equals("Grocery")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Condiments", "Spices", "Biscuits", "Confectionary", "Rice", "Pasta", "Milk Powder", "Sauce");
                cmbSubCategory.setItems(subCategoryList);
                System.out.println("Grocery");
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Dairy")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Cheese", "Milk", "Butter", "Chilled Milk", "Dessert");
                cmbSubCategory.setItems(subCategoryList);

            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Homeware")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Sports", "Stationary", "Brooms", "Mats", "Kitchen");
                cmbSubCategory.setItems(subCategoryList);

            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Meat and Fish")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Meat", "Fish");
                cmbSubCategory.setItems(subCategoryList);
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Personal Care")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Shampoo and conditioner", "Deodorant", "Personal Needs", "Face and Cleaning", "Creams");
                cmbSubCategory.setItems(subCategoryList);
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Baby Needs")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Baby Food", "Baby Sanity");
                cmbSubCategory.setItems(subCategoryList);
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Frozen Items")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Ice cream");
                cmbSubCategory.setItems(subCategoryList);
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Fruits and Vegetables")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Fruits", "Vegetables");
                cmbSubCategory.setItems(subCategoryList);
            } else if (cmbCategory.getSelectionModel().getSelectedItem().equals("Confectionary")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Chocalate", "Cake", "Sweets");
                cmbSubCategory.setItems(subCategoryList);
            }


        });

        cmbSubCategory.setOnAction(actionEvent -> {
            if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Biscuits")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Maliban", "Munchee", "Little Lion");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Condiments")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("McCurrie", "Kist", "MD", "Maggie", "Heinz", "Mayura", "Colmans", "Renuka");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Spices")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("McCurrie", "Ruhunu", "Wijaya", "Nature", "Dil", "MA's Kitchen", "Rich");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Rice")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Nipuna", "Rathna", "Araliya", "Hiru", "Hansana");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Pasta")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Prima", "Harischandra", "Raigam", "Roza", "Pastaricco", "Colavita");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Milk Powder")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Bonlac", "Anlene", "Palwatte", "Maliban", "Anchor", "Raththi", "Nesle");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Sauce")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("KVC", "Kist", "MD", "Heinz", "Edin", "Fortune");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Stationary")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Acron", "Maped", "Atlas", "Nataraj", "Richard", "Link", "Weerodara");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Kitchen")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Morphy Richard", "Panasonic", "Olan");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Meat")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Not Applicable");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Fish")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Not Applicable");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Shampoo and Conditioner")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Dandex", "Head and Shoulders", "Lifebouy", "Panteene", "Nature Secrets");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Deodorant")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Janet", "Dettol", "Capri", "Enchanter");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Personal Needs")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Forever", "Dettol", "Capri", "Enchanter");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Cheese")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Kothmale", "Palwatte", "Happy Cow", "Anchor");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Milk")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Kothmale", "RichLife", "Daily Active", "Anchor");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Chilled Milk")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("RichLife", "Highland", "Kothmale");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Dessert")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Highland", "Kothmale", "Newdale", "Anchor");
                cmbBrandName.setItems(subCategoryList);
            } else if (cmbSubCategory.getSelectionModel().getSelectedItem().equals("Confectionary")) {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Revello", "Ritzberry", "Ferrero", "Kandos", "Cadberry", "Tiyara", "Delta");
                cmbBrandName.setItems(subCategoryList);

            } else {
                ObservableList<String> subCategoryList = FXCollections.observableArrayList("Not Applicable");
                cmbSubCategory.setItems(subCategoryList);
            }
        });

    }

    @FXML
    void BtnSupplierDirectoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY, brdrPaneAddNewStock);
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INVENTORY, brdrPaneAddNewStock);
    }

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.HAM_STORE, brdrPaneAddNewStock);
    }

    @FXML
    void btnEnterOnAction(ActionEvent event) throws SQLException {
        String stockCode = txtStockCode.getText();
        boolean isStockCodeMatched = stockCode.matches("^I-\\d{4}$");
        String itemDescription = txtItemDescription.getText();
        boolean isItemDescriptionMatched = itemDescription.matches("(^[a-zA-Z][a-zA-Z\\s]{0,40}$)");
        double qtyOnHand = Double.parseDouble(txtQtyOnHand.getText());
        boolean isQtyOnHandMatched = String.valueOf(qtyOnHand).matches("^[1-9][\\d]{1,}(.){1,}$");
        String measuredUnits = cmbMeasuredUnits.getSelectionModel().getSelectedItem().toString();
        double unitRate = Double.parseDouble(txtUnitRate.getText());
        boolean isUnitRateMatched = String.valueOf(unitRate).matches("^[1-9][\\d]{1,4}.[0-9]{1,2}$");
        String category = cmbCategory.getSelectionModel().getSelectedItem().toString();
        String subCategory = cmbSubCategory.getSelectionModel().getSelectedItem().toString();
        String brand = cmbBrandName.getSelectionModel().getSelectedItem().toString();
        byte[] bytes = txtImagePath.getText().getBytes();
        Blob img = new SerialBlob(bytes);

        StockDTO stockAtStore = new StockDTO(stockCode, itemDescription, qtyOnHand, measuredUnits, unitRate, category, subCategory, brand,img);
        if (img!=null) {
            if (isStockCodeMatched) {
                if (isItemDescriptionMatched) {
                    if (isQtyOnHandMatched) {
                        if (measuredUnits != null) {
                            if (isUnitRateMatched) {
                                if (category != null) {
                                    if (subCategory != null) {
                                        if (brand != null) {
                                            try {
                                                boolean isAdded = stockBOImpl.addNewStock(stockAtStore);
                                                if (isAdded) {
                                                    Notifications notifications = Notifications.create().text("Stock Added Successfully").title("Add Stock").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                                                    notifications.showInformation();
                                                }
                                            } catch (SQLException e) {
                                                throw new RuntimeException(e);
                                            } catch (ClassNotFoundException e) {
                                                throw new RuntimeException(e);
                                            }

                                        } else {
                                            lblBrand.setText("Select Brand");
                                        }
                                    } else {
                                        lblSub.setText("Select Sub Category");
                                    }
                                } else {
                                    lblCategory.setText("Select Category");
                                }
                            } else {
                                txtUnitRate.setFocusColor(Paint.valueOf("Red"));
                                txtUnitRate.requestFocus();
                            }
                        } else {
                            lblUnits.setText("Select Measured Units");
                        }
                    } else {
                        txtQtyOnHand.setFocusColor(Paint.valueOf("Red"));
                        txtQtyOnHand.requestFocus();
                    }
                } else {
                    txtItemDescription.setFocusColor(Paint.valueOf("Red"));
                    txtItemDescription.requestFocus();
                }
            } else {
                txtStockCode.setFocusColor(Paint.valueOf("Red"));
                txtStockCode.requestFocus();
            }
        }else{
            txtImagePath.setFocusColor(Paint.valueOf("Red"));
            txtImagePath.requestFocus();
        }


    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD, brdrPaneAddNewStock);
    }

    @FXML
    void btnInventoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INVENTORY, brdrPaneAddNewStock);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Conformation");
        alert.setContentText("Do you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)) {
            Navigation.navigate(Routes.NEW_STOCK, brdrPaneAddNewStock);
        } else if (result.get() == ButtonType.OK) {
            Navigation.navigate(Routes.LOGIN, brdrPaneAddNewStock);
        } else if (result.get() == ButtonType.CANCEL) {
            Navigation.navigate(Routes.CASHIER_DASHBOARD, brdrPaneAddNewStock);
        }
    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES, brdrPaneAddNewStock);
    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) {

    }

    public void cmbCategorySelection(ActionEvent actionEvent) {

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


    public void btnBrowseImageOnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) brdrPaneAddNewStock.getScene().getWindow();

            file = fileChooser.showOpenDialog(stage);
            if (file!=null) {
                txtImagePath.setText(file.getAbsolutePath());
             }
            try {
                fileInputStream = new FileInputStream(txtImagePath.getText());

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Image image = new Image(fileInputStream);
            imgSrc.setImage(image);




//        final DirectoryChooser dir = new DirectoryChooser();
//        Stage stage = (Stage) brdrPaneAddNewStock.getScene().getWindow();
//        File file1 =dir.showDialog(stage);
//        if (file1!=null){
//            txtImagePath.setText(file1.getAbsolutePath());
//        }
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdrPaneAddNewStock);
    }

    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdrPaneAddNewStock);
    }
}



