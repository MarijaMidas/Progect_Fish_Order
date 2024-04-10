package app.web.controllers;

import app.crm.model.Order;
import app.crm.service.DBServiceOrder;
import app.dto.OrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OrderController {

    private final DBServiceOrder dbServiceOrder;

    public OrderController(DBServiceOrder dbServiceOrder) {
        this.dbServiceOrder = dbServiceOrder;
    }

    @GetMapping("/order")
    public String orderForm(Model model){
        model.addAttribute("order", new OrderDTO());
        return "order";
    }

    @PostMapping("/order")
    public RedirectView saveOrder(OrderDTO dto) {
        dbServiceOrder.saveOrder(new Order(dto));
        return new RedirectView("/order_thanks");
    }

    @GetMapping("/authenticated")
    public String authenticatedPage() {
        return "authenticated";
    }

    @GetMapping("/order_thanks")
    public String congratulationsPage(){
        return "/order_thanks";
    }


    @GetMapping({"/authenticated/all"})
    public String ordersListView(Model model) {
        if (model.getAttribute("order") == null) {
            model.addAttribute("order", new OrderDTO());
        }
        model.addAttribute("orders", dbServiceOrder.findAll());
        return "authenticated";
    }

    @GetMapping({"/authenticated/order"})
    public String orderListView(@RequestParam String phoneNumber, Model model) {
        if (model.getAttribute("order") == null) {
            model.addAttribute("order", new OrderDTO());
        }
        model.addAttribute("orders", dbServiceOrder.getOrdersByClientPhoneNumber(phoneNumber));
        return "authenticated";
    }

    @GetMapping({"/authenticated/new"})
    public String newOrderListView(Model model) {
        if (model.getAttribute("order") == null) {
            model.addAttribute("order", new OrderDTO());
        }
        model.addAttribute("orders", dbServiceOrder.findAllByCompleted("false"));
        return "authenticated";
    }
    @GetMapping({"/authenticated/complete"})
    public String completeOrderListView(Model model) {
        if (model.getAttribute("order") == null) {
            model.addAttribute("order", new OrderDTO());
        }
        model.addAttribute("orders", dbServiceOrder.findAllByCompleted("true"));
        return "authenticated";
    }

    @GetMapping({"/authenticated/city"})
    public String orderByCityListView(@RequestParam String city, Model model) {
        if (model.getAttribute("order") == null) {
            model.addAttribute("order", new OrderDTO());
        }
        model.addAttribute("orders", dbServiceOrder.findAllByCity(city));
        return "authenticated";
    }

}
