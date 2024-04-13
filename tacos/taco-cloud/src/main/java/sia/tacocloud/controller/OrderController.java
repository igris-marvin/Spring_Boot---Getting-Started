package sia.tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import sia.tacocloud.data.OrderRepository;
import sia.tacocloud.model.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/orders") // handle requests within path '/orders'
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @GetMapping("/current") //this method will handle the GET HTTP requests for path /orders/current
    public String orderForm() {

        return "order_form"; //view
    }

    @PostMapping //this (processOrder) method handles taco_order forms POST request
    public String processOrder(
        @Valid TacoOrder order, 
        Errors errors,
        SessionStatus sessionStatus
    ) {

        if (errors.hasErrors()) {
            return "order_form";
        }

        orderRepository.save(order); // save Taco Order object to database
        sessionStatus.setComplete(); //terminate session

        return "redirect:/";
    }
}
