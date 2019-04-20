package com.furkanisitan.webUI.controllers;

import com.furkanisitan.business.abstrct.ICustomerService;
import com.furkanisitan.business.concrete.managers.CustomerManager;
import com.furkanisitan.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    private ICustomerService _customerService;

    // TODO Dependency injection
    public HomeController() {
        this._customerService = new CustomerManager();
    }

    @RequestMapping(value = {"/", "/home", "/home/index"})
    public String index(Model model) {
        List<Customer> customers = _customerService.getAll();
        model.addAttribute("customers", customers);
        return "home/index";
    }

    @RequestMapping(value = "home/create")
    public String create() {
        return "home/createorupdate";
    }

    @RequestMapping(value = "home/update", params = {"id"})
    public String update(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("customer", _customerService.getById(id));
        return "home/createorupdate";
    }

    @PostMapping(value = "/createorupdate")
    public @ResponseBody
    String ajaxcreateorupdate(HttpServletRequest request) {

        Customer customer = new Customer();
        customer.setSalary(Integer.parseInt(request.getParameter("salary")));
        customer.setFullname(request.getParameter("fullname"));
        customer.setEmail(request.getParameter("email"));
        customer.setPhoneNumber(request.getParameter("phoneNumber"));
        customer.setDateOfBirth(request.getParameter("dob"));

        String id = request.getParameter("id");

        String msg, method;
        if (id == null || id.isEmpty()) {
            msg = _customerService.add(customer) ? "OK" : "ERROR";
            method = "CREATE";
        } else {
            customer.setId(Integer.parseInt(id));
            msg = _customerService.update(customer) ? "OK" : "ERROR";
            method = "UPDATE";
        }
        return String.format("{\"msg\":\"%1s\", \"method\":\"%2s\"}", msg, method);
    }

    @PostMapping(value = "/delete")
    public @ResponseBody
    String ajaxpostdelete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String msg = _customerService.deleteById(id) ? "OK" : "ERROR";
        return String.format("{\"msg\":\"%1s\"}", msg);
    }
}

