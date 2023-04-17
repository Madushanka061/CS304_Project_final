package com.example.tutorial01.Controller;
import com.example.tutorial01.dto.OrderDTO;
import com.example.tutorial01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private  OrderService orderService;

    @GetMapping("/getOrders")
    public List<OrderDTO> getOrder(){
        return orderService.getAllOrders();
    }

    @PostMapping("/saveOrder")
    public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO){

        return orderService.saveOrder(orderDTO);
    }
    @PutMapping("/updateOrder")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/deleteOrder")
    public  boolean deleteOrder(@RequestBody OrderDTO orderDTO){
        return orderService.deleteOrder(orderDTO);
    }
}
