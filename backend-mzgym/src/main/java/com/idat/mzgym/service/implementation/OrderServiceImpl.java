package com.idat.mzgym.service.implementation;

import com.idat.mzgym.dto.OrderRegisterDto;
import com.idat.mzgym.model.Memberships;
import com.idat.mzgym.model.Orders;
import com.idat.mzgym.repository.OrderRepository;
import com.idat.mzgym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;
    @Override
    public Orders createOrder(OrderRegisterDto orderRequest) {
        Orders saveOrder=new Orders();
        saveOrder.setAccount(orderRequest.getAccount());
        Memberships membership=orderRequest.getMembership();
        Double total=membership.getPrice();
        saveOrder.setTotal(total);
        saveOrder.setMembership(orderRequest.getMembership());
        saveOrder.setLocation(orderRequest.getLocation());
        saveOrder.setDescription(orderRequest.getDescription());

        orderRepository.save(saveOrder);

        return saveOrder;
    }

    @Override
    public void changeState(String orderUuid, String transactionState) {

    }

    @Override
    public Orders getOrderById(String ordernUuid) {
        return null;
    }

    @Override
    public List<Orders> getOrdersByAccountUuid(String accountUuid) {
        return null;
    }
}
