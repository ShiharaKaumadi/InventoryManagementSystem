package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.StockAtStore;

public class ItemRecordFormController {
    public Label lblItemDescription;
    public Label lblUnitPrice;
    public JFXButton btnReduce;
    public TextField txtQty;
    public Label lblItemTotal;
    public JFXButton btnIncrease;
    public Pane paneRecord;
    public Label lblStockCode;

    private StockDTO stockAtStore;

    public void setData(StockDTO stockAtStore) {
        this.stockAtStore=stockAtStore;
        lblItemDescription.setText(stockAtStore.getItemDescription());
        lblStockCode.setText(stockAtStore.getStockCode());
        lblUnitPrice.setText(String.valueOf(stockAtStore.getUnitRate()));
        txtQty.setText("1");
        lblItemTotal.setText(String.valueOf(stockAtStore.getUnitRate()*Double.parseDouble(txtQty.getText())));

    }


}
