package lk.ijse.finalproject.controller;

import javafx.scene.control.Label;
import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.dto.StockDTO;

public class TopSellingItemFormController {
    public Label lblItemName;
    public Label lblUnitRate;
    private OrderDetailDTO orderDetailDTO;
    public void setData(OrderDetailDTO orderDetailDTO){
        this.orderDetailDTO=orderDetailDTO;
        lblItemName.setText(orderDetailDTO.getDescription());
        lblUnitRate.setText(String.valueOf(orderDetailDTO.getUnitPrice()));
    }
}
