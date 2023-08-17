package com.idat.mzgym.controller;


import com.idat.mzgym.dto.Mensaje;
import com.idat.mzgym.dto.OrderRegisterDto;
import com.idat.mzgym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrdersController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?>createOrder(OrderRegisterDto orderRegisterDto){
        orderService.createOrder(orderRegisterDto);
        return new ResponseEntity(new Mensaje("order created successfully"), HttpStatus.OK);

    }
}
