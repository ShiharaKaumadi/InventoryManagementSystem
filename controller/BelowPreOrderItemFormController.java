package lk.ijse.finalproject.controller;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.finalproject.dto.StockDTO;

import java.util.ArrayList;

public class BelowPreOrderItemFormController {
    public AnchorPane paneItem;
    public Label lblItemName;
    public Label lblQty;

    private StockDTO stockAtStore;
    ArrayList <StockDTO> stockAtStoreArrayList = new ArrayList<>();

    public void setPaneItem(AnchorPane paneItem) {
        this.paneItem = paneItem;
    }

    public AnchorPane getPaneItem() {
        return paneItem;
    }

    public void setData(StockDTO stockAtStore){
        this.stockAtStore=stockAtStore;
        if (stockAtStore.getQtyOnHand()<=100) {
            lblItemName.setText(stockAtStore.getItemDescription());
            lblQty.setText(String.valueOf(stockAtStore.getQtyOnHand()));
        }

    }
}
