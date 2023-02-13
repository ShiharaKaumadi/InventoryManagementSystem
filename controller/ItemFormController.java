package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.StockBO;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.StockAtStore;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemFormController {
    public AnchorPane paneItemCard;
    public Pane paneItem;
    public Label lblItemDescription;
    public Label lblItemPrice;
    public ImageView imgItem;
    public JFXButton btnAdd;
    public Label lblItemCode;
    public Label lblAvailability;

    private StockDTO stockAtStore;

    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);

    public void setData(StockDTO stockAtStore) {
        this.stockAtStore=stockAtStore;
        lblItemDescription.setText(stockAtStore.getItemDescription());
        lblItemCode.setText(stockAtStore.getStockCode());
        lblItemPrice.setText(String.valueOf(stockAtStore.getUnitRate()));


        if (stockAtStore.getQtyOnHand()<=100){

           btnAdd.setDisable(true);
           lblAvailability.setText("Not Available");

        }else {
           lblAvailability.setText("Available");

        }
        System.out.println(stockAtStore.getImgSrc());
       // Image image1 = new Image(getClass().getResourceAsStream(stockAtStore.getImgSrc().toString()));
        Image image = new Image("/lk/ijse/finalproject/asset/image/edinMayonnaise.png ");
        imgItem.setImage(image);

    }

    public StockDTO btnAddOnAction(ActionEvent actionEvent) {
        String itemCode =lblItemCode.getText();
        StockDTO stockDTO1;
        try {
            StockDTO stockDTO = stockBOImpl.searchStockDetails(itemCode);
            stockDTO1 = new StockDTO(stockDTO.getStockCode(),stockDTO.getItemDescription(),stockDTO.getQtyOnHand(),stockDTO.getMeasuredUnits(),stockDTO.getUnitRate(),stockDTO.getCategory(),stockDTO.getSubCategory(),stockDTO.getBrand());
            System.out.println(stockDTO1.getItemDescription());
            System.out.println("***************");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stockDTO1;

    }
}
