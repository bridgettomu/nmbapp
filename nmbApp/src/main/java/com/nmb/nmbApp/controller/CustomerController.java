package com.nmb.nmbApp.controller;

import com.nmb.nmbApp.dto.AddCustomerDTO;
import com.nmb.nmbApp.dto.UpdateCustomerDTO;
import com.nmb.nmbApp.model.Customer;
import com.nmb.nmbApp.service.iface.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody AddCustomerDTO addCustomerDTO){
        Customer customer = modelMapper.map(addCustomerDTO,Customer.class);
        return ResponseEntity.ok(service.add(customer));
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody UpdateCustomerDTO updateCustomerDTO){
        Customer customer = modelMapper.map(updateCustomerDTO,Customer.class);
        return ResponseEntity.ok(service.update(customer));
    }
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
        return service.getAll();
    }


    @DeleteMapping("/one/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneCustomer(@PathVariable("id") Long id){
        service.deleteOne(id);
    }

    @DeleteMapping("/delete-all")
    @ResponseStatus(HttpStatus.OK)
    public void getOneCustomer(){
        service.deleteAll();
    }
}
