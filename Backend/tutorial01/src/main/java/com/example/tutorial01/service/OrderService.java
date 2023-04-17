package com.example.tutorial01.service;

import com.example.tutorial01.dto.OrderDTO;
import com.example.tutorial01.entity.Order;
import com.example.tutorial01.repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepo orderRepo;



    public OrderDTO saveOrder(OrderDTO orderDTO){
        Order A = modelMapper.map(orderDTO, Order.class);
        Order savedOrder2 =orderRepo.save(A);
        return orderDTO;
    }
    public List<OrderDTO> getAllOrders(){
        List<Order> order2List =orderRepo.findAll();
        return modelMapper.map(order2List,new TypeToken<List<OrderDTO>>(){}.getType());
    }
    public OrderDTO updateOrder(OrderDTO orderDTO){
        orderRepo.save(modelMapper.map(orderDTO, Order.class));
        return orderDTO;
    }
    public boolean deleteOrder(OrderDTO orderDTO){
        orderRepo.delete(modelMapper.map(orderDTO, Order.class));
        return true;
    }
}
