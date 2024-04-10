package app.crm.service;

import app.crm.model.Order;

import java.util.List;

public interface DBServiceOrder {

    Order saveOrder(Order order);

    List<Order> findAll();

    List<Order> getOrdersByClientPhoneNumber(String phoneNumber);

    List<Order>findAllByCompleted(String complete);

    List<Order>findAllByCity(String city);
}
