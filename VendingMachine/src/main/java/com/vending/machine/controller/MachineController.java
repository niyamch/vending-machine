package com.vending.machine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vending.machine.dto.ChangeDto;
import com.vending.machine.service.MachineService;

@RestController
@RequestMapping("/api/vending-machine")
public class MachineController {
	@Autowired
	private MachineService machineService;
	
	@PostMapping("/insert-coin")
    public String findProductById(@RequestBody String coinType) {
        return machineService.insertCoin(coinType);
    }

    @PutMapping("/buy-product")
    public String buyProduct(@RequestBody String productName) {
        return machineService.buyProduct(productName);
    }
    
    @DeleteMapping("/reset")
    public ChangeDto returnChange() {
        return machineService.returnChange();
    }	
}
