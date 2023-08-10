package com.idat.mzgym.service;

import com.idat.mzgym.dto.OrderRegisterDto;
import com.idat.mzgym.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
    @Transactional
    Orders createOrder(OrderRegisterDto orderRequest);

    @Transactional
    void changeState(String orderUuid, String transactionState);

    Orders getOrderById(String ordernUuid);

    @Transactional
    List<Orders> getOrdersByAccountUuid(String accountUuid);
}
