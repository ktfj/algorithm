package com.example.controller;

import com.example.logic.OrderLogic;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderCtrl {
    @Autowired
    private OrderLogic orderLogic;

    public void getOrders(){
        orderLogic.getOrders();
    }

}
