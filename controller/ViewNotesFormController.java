package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.bo.custom.*;
import lk.ijse.finalproject.dto.CustomDTO;
import lk.ijse.finalproject.dto.MrnDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.MrnConfirmationTM;
import lk.ijse.finalproject.views.tm.MrnTM;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

public class ViewNotesFormController {

        public BorderPane brdrPaneViewNotes;

        public Pane leftPane;

        public Circle userProfile;

        public Label lblUserName;

        public JFXButton btnHome;

        public JFXButton btnProfileSettings;


        public JFXButton btnSupplierDirectory;


        public JFXButton btnViewNotes;


        public JFXButton btnViewStatics;


        public JFXButton btnLogout;


        public JFXButton btnHamburger;


        public Tab tabMrn;


        public AnchorPane anchPaneMrn;


        public Pane paneMrn;


        public JFXDatePicker dtRequestedDate;


        public JFXTextField txtRecommendPersonId;


        public Label lblMrnId;


        public JFXTextField txtSubCategory;


        public JFXDatePicker dtDateRequired;


        public JFXButton btnEnter;


        public JFXTextField txtBrandName;


        public JFXComboBox<?> cmbMrMeasuredUnits;


        public JFXTextField txtQtyRequested;


        public JFXTextField txtStockItemDescription;


        public JFXTextField txtStockCode;


        public JFXTextField txtCategory;


        public TableView<MrnConfirmationTM> tblMRNData;


        public TableColumn<?, ?> colStockCode;


        public TableColumn<?, ?> colStockItemDescription;


        public TableColumn<?, ?> colMeasuredUnits;


        public TableColumn<?, ?> colQtyRequested;


        public TableColumn<?, ?> colRequiredDate;


        public TableColumn<?, ?> colCategory;


        public TableColumn<?, ?> colSubCategory;


        public TableColumn<?, ?> colBrandName;


        public JFXButton btnMrnPrint;


        public Tab tabMin;


        public Pane paneMrn2;


        public JFXDatePicker dtIssueDate;


        public JFXTextField txtRequestPersonId;


        public Label lblMinId;


        public JFXTextField txtPurpose;


        public JFXButton btnMinEnter;


        public JFXComboBox<?> cmbMinCategory;


        public JFXTextField txtQtyIssued;


        public JFXComboBox<?> cmbMinStockCode;


        public JFXComboBox<?> cmbMinStockItemDescription;


        public JFXComboBox<?> cmbMinSubCategory;


        public JFXComboBox<?> cmbMinBrandName;


        public JFXComboBox<?> cmbMinMeasuredUnits;


        public TableView<?> tblMinData;


        public TableColumn<?, ?> colMinStockCode;


        public TableColumn<?, ?> colMinStockItemDescription;


        public TableColumn<?, ?> colMinMeasuredUnits;


        public TableColumn<?, ?> colQtyIssued;


        public TableColumn<?, ?> colIssueDate;


        public TableColumn<?, ?> colMinCategory;


        public TableColumn<?, ?> colMinSubCategory;


        public TableColumn<?, ?> colMinBrandName;


        public TableColumn<?, ?> colMinUnitRate;


        public JFXButton btnMinEdit;


        public JFXButton btnMinRemove;


        public JFXButton btnMinEmail;


        public JFXButton btnMinPrint;


        public Tab tabGrn;


        public Pane paneMrn21;


        public JFXDatePicker dtReceiveDate;


        public Label lblGrnId;


        public JFXDatePicker dtGrnDate;


        public JFXTextField txtStoreKeeperId;


        public JFXComboBox<?> cmbGrnMrnId;


        public JFXComboBox<?> cmbGrnCategory;


        public JFXTextField txtGrnQtyReceived;


        public JFXComboBox<?> cmbReceiveStockCode;


        public JFXComboBox<?> cmbReceiveItem;


        public JFXComboBox<?> cmbGrnSubCategory;


        public JFXComboBox<?> cmbGrMeasuredUnits;


        public JFXTextField txtQtyAccepted;


        public JFXComboBox<?> cmbGrnBrandName;


        public JFXTextField txtGrnUnitPrice;


        public JFXTextField txtReasonerRejection;


        public JFXButton btnGrnEnter;


        public TableView<?> tblGrnData;


        public TableColumn<?, ?> colReceivedStockCode;


        public TableColumn<?, ?> colGrnStockItemDescription;


        public TableColumn<?, ?> colGrnCategory;


        public TableColumn<?, ?> colGrnSubCategory;


        public TableColumn<?, ?> colGrnBrandName;


        public TableColumn<?, ?> colGrnMeasuredUnits;


        public TableColumn<?, ?> colUnitPrice;


        public TableColumn<?, ?> colQtyReceived;


        public TableColumn<?, ?> colQtyAccepted;


        public TableColumn<?, ?> colReasonForRejection;


        public JFXButton btnGrnEdit;


        public JFXButton btnGrnRemove;


        public JFXButton btnGrnEmail;


        public JFXButton btnGrnPrint;
        public JFXButton btnMinAccept;
        public JFXTextField txtMrSubCategory;
        public JFXDatePicker dtMrDateRequired;
        public JFXTextField txtMrBrandName;
        public JFXTextField txtMrQtyRequested;
        public JFXTextField txtMrnStockItemDescription;
        public JFXTextField txtMrCategory;
        public TableColumn <MrnConfirmationTM,String>colMrnID;
        public TableColumn <MrnConfirmationTM,String>colMrStockCode;
        public TableColumn <MrnConfirmationTM,String>colMrStockItemDescription;
        public TableColumn <MrnConfirmationTM,String>colMrMeasuredUnits;
        public TableColumn <MrnConfirmationTM,Double>colMrQtyRequested;
        public TableColumn <MrnConfirmationTM, LocalDate>colMrRequiredDate;
        public TableColumn <MrnConfirmationTM,String>colMrCategory;
        public TableColumn <MrnConfirmationTM,String>colMrSubCategory;
        public TableColumn <MrnConfirmationTM,String>colMrBrandName;
        public TableColumn <MrnConfirmationTM, Button>colMrAccept;
        public TableColumn <MrnConfirmationTM,Button>colMrReject;
        public JFXTextField txtMrMeasuredUnits;
        public TableColumn <MrnConfirmationTM,String>colSupplierID;

        MrnBO mrnBOImpl = (MrnBO) BOFactory.getBoFactory().getBO(BOTypes.MRN);
        QuotationBO quotationBOImpl = (QuotationBO) BOFactory.getBoFactory().getBO(BOTypes.QUOTATION);
        ObservableList<MrnConfirmationTM> tmList = FXCollections.observableArrayList();
        EmployeeBO employeeBOImpl = (EmployeeBO) BOFactory.getBoFactory().getBO(BOTypes.EMPLOYEE);
        BodyPart messageBodyPart1 = new MimeBodyPart();
        // creating MultiPart object
        Multipart multipartObject = new MimeMultipart();


        public void initialize(){
             MrnSetCellValueFactory();
             loadMrnTableData();
        }

        private void loadMrnTableData() {
                ArrayList<MrnDTO> mrn = null;
                try {
                        mrn = mrnBOImpl.getMrnDetails();
                        for (MrnDTO mrn1 : mrn) {
                                Button accept = new Button("Accept");
                                Button reject = new Button("Reject");

                                MrnConfirmationTM tm = new MrnConfirmationTM(mrn1.getMrnId(),mrn1.getStockCode(),mrn1.getStockDescription(),mrn1.getMeasuredUnits(),mrn1.getRequiredDate(),mrn1.getRequestedQty(),mrn1.getCategory(),
                                        mrn1.getSubCategory(),mrn1.getBrandName(),accept,reject,mrn1.getRecommendBy());
                                tmList.add(tm);
                                tblMRNData.setItems(tmList);
                                accept.setOnAction(event -> {
                                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                                        alert.setTitle("Alert");
                                        alert.setContentText("Do you want to accept "+lblMrnId.getText()+" ?");
                                        Optional <ButtonType> result = alert.showAndWait();
                                        try {
                                        if (result.equals(null)){
                                                Navigation.navigate(Routes.MANAGEMENT_NOTES,brdrPaneViewNotes);
                                        } else if (result.get()== ButtonType.OK) {
                                                String email = quotationBOImpl.sendEmailToSupplier(txtRecommendPersonId.getText());
                                                System.out.println(email);
                                                String from = "eshani9544@gmail.com";
                                                String to = email;
//        String email = employeeDAOImpl.SearchPassword(to).getEmail();
                                                String password = employeeBOImpl.SearchPassword(to).getPassword();


                                                //     String text = employeeDAOImpl.SearchPassword(to).toString();
                                                //Get system properties
                                                Properties properties = System.getProperties();
                                                //set up mail server
                                                //simple mail transfer protocol
                                                properties.put("mail.smtp.auth", "true");
                                                properties.put("mail.smtp.starttls.enable", "true");
                                                properties.put("mail.smtp.host", "smtp.gmail.com");
                                                properties.put("mail.smtp.port", "587");
                                                //get the session object
                                                //then pass username password
                                                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                                                        @Override
                                                        protected PasswordAuthentication getPasswordAuthentication() {
                                                                return new PasswordAuthentication("eshani9544@gmail.com", "cijsfysrrmskvntl");
                                                        }
                                                });

                                                //use to debug smtp issues
                                                session.setDebug(true);
                                                try {
                                                        //create a default mimemessage object
                                                        MimeMessage mimeMessage = new MimeMessage(session);
                                                        //set from: set the header feild of header
                                                        mimeMessage.setFrom(new InternetAddress(from));
                                                        //set To:
                                                        mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
                                                        mimeMessage.setSubject("Call Quatations For "+lblMrnId.getText());
                                                        System.out.println(password);
                                                        messageBodyPart1.setText("Please start calling quotation for above MRN "+ "\n\nThank you\nAdmin");
                                                        multipartObject.addBodyPart(messageBodyPart1);
                                                        // set body of the email.
                                                        mimeMessage.setContent(multipartObject);
                                                        Transport.send(mimeMessage);
                                                } catch (MessagingException e) {
                                                        e.printStackTrace();
                                                }

                                        } else if (result.get()==ButtonType.CANCEL) {
                                                Navigation.navigate(Routes.MANAGEMENT_NOTES,brdrPaneViewNotes);
                                        }
                                        } catch (IOException | SQLException | ClassNotFoundException e) {
                                                throw new RuntimeException(e);
                                        }
                                });
                        }
                } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                }
        }

        private void MrnSetCellValueFactory() {
                colMrnID.setCellValueFactory(new PropertyValueFactory<>("mrnId"));
                colMrStockCode.setCellValueFactory(new PropertyValueFactory<>("stockCode"));
                colMrStockItemDescription.setCellValueFactory(new PropertyValueFactory<>("productName"));
                colMrMeasuredUnits.setCellValueFactory(new PropertyValueFactory<>("measuredUnits"));
                colMrQtyRequested.setCellValueFactory(new PropertyValueFactory<>("qtyRequested"));
                colMrRequiredDate.setCellValueFactory(new PropertyValueFactory<>("requiredDate"));
                colMrCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
                colMrSubCategory.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
                colMrBrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
                colMrAccept.setCellValueFactory(new PropertyValueFactory<>("accept"));
                colMrReject .setCellValueFactory(new PropertyValueFactory<>("delete"));
                colSupplierID.setCellValueFactory(new PropertyValueFactory<>("skId"));

        }


        public void BtnSupplierDirectoryOnAction(ActionEvent event) throws IOException {
            Navigation.navigate(Routes.MANAGE_EMPLOYEE,brdrPaneViewNotes);
        }


        public void btnAcceptOnAction(ActionEvent event) {

        }


        public void btnClickHamburgerOnAction(ActionEvent event) {

        }


        public void btnEnterOnAction(ActionEvent event) {

        }


        public void btnGrnEditOnAction(ActionEvent event) {

        }


        public void btnGrnEmailOnAction(ActionEvent event) {

        }


        public void btnGrnEnterOnAction(ActionEvent event) {

        }


        public void btnGrnPrintOnAction(ActionEvent event) {

        }


        public void btnGrnRemoveOnAction(ActionEvent event) {

        }


        public void btnHomeOnAction(ActionEvent event) throws IOException {
            Navigation.navigate(Routes.DASHBOARD,brdrPaneViewNotes);
        }


        public void btnLogoutOnAction(ActionEvent event) {

        }

        public void btnMinEditOnAction(ActionEvent event) {

        }

        public void btnMinEmailOnAction(ActionEvent event) {

        }

        public void btnMinEnterOnAction(ActionEvent event) {

        }

        public void btnMinPrintOnAction(ActionEvent event) {

        }

        public void btnMinRemoveOnAction(ActionEvent event) {

        }

        public void btnMrnPrintOnAction(ActionEvent event) {

        }

        public void btnProfileSettingsOnAction(ActionEvent event) {

        }

        public void btnRejectOnAction(ActionEvent event) {

        }

        public void btnViewNotesOnAction(ActionEvent event) throws IOException {
                Navigation.navigate(Routes.MANAGEMENT_NOTES,brdrPaneViewNotes);
        }


        public void btnViewStaticsOnAction(ActionEvent event) {

        }


        public void cmbGenerateDetailsOnAction(ActionEvent event) {

        }


        public void cmbStockDescriptionOnAction(ActionEvent event) {

        }

         public void btnMrnAcceptOnAction(ActionEvent actionEvent) throws IOException {

         }

        public void btnMrnRejectOnAction(ActionEvent actionEvent) {
        }

        public void btnMinReject(ActionEvent actionEvent) {
        }

        public void rowClickedOnMouseEvent(MouseEvent mouseEvent) {
                MrnConfirmationTM selectedItem = tblMRNData.getSelectionModel().getSelectedItem();
                lblMrnId.setText(String.valueOf(selectedItem.getMrnId()));
                txtStockCode.setText(selectedItem.getStockCode());
                txtMrnStockItemDescription.setText(selectedItem.getProductName());
                dtMrDateRequired.setValue(selectedItem.getRequiredDate());
                txtMrMeasuredUnits.setText(selectedItem.getMeasuredUnits());
                txtMrCategory.setText(selectedItem.getCategory());
                txtMrSubCategory.setText(selectedItem.getSubCategory());
                txtMrBrandName.setText(selectedItem.getBrandName());
                txtMrQtyRequested.setText(String.valueOf(selectedItem.getRequestQty()));
                txtRecommendPersonId.setText(selectedItem.getSupplierID());
        }
}
