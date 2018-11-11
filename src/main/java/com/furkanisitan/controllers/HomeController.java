package com.furkanisitan.controllers;

import com.furkanisitan.entities.Customer;
import com.furkanisitan.service.CustomerManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    private CustomerManager customerManager = new CustomerManager();

    @RequestMapping(value = {"/", "/home", "/home/index"})
    public String index(Model model) {
        List<Customer> customers = customerManager.getList();
        model.addAttribute("customers", customers);
        return "home/index";
    }

    @RequestMapping(value = "home/create")
    public String create() {
        return "home/createorupdate";
    }

    @RequestMapping(value = "home/update", params = {"id"})
    public String update(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("customer", customerManager.get(id));
        return "home/createorupdate";
    }

    @PostMapping(value = "/createorupdate")
    public @ResponseBody
    String ajaxcreateorupdate(HttpServletRequest request) {

        Customer customer = new Customer();
        customer.setFirstname(request.getParameter("firstname"));
        customer.setLastname(request.getParameter("lastname"));
        customer.setEmail(request.getParameter("email"));
        customer.setPhoneNumber(request.getParameter("phoneNumber"));
        customer.setDob(request.getParameter("dob"));

        String id = request.getParameter("id");
        System.out.println("id : " + id);

        String msg, method;
        if (id == null || id.isEmpty()) {
            msg = customerManager.insert(customer) ? "OK" : "ERROR";
            method = "CREATE";
        } else {
            customer.setId(Integer.parseInt(id));
            msg = customerManager.update(customer) ? "OK" : "ERROR";
            method = "UPDATE";
        }
        System.out.println(customer.getDob());
        return String.format("{\"msg\":\"%1s\", \"method\":\"%2s\"}", msg, method);
    }

    @PostMapping(value = "/delete")
    public @ResponseBody
    String ajaxpostdelete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String msg = customerManager.delete(id) ? "OK" : "ERROR";
        return String.format("{\"msg\":\"%1s\"}", msg);
    }
}

