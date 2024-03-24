package com.example.jpaex.Controller;

import com.example.jpaex.ApiResponce.ApiResponce;
import com.example.jpaex.Model.Merchant;
import com.example.jpaex.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {


    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getMerchant());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponce("Merchant added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=merchantService.updateMerchant(id,merchant);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("Merchant updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id){
        boolean isdeleted=merchantService.deleteMerchant(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("Merchant deleted"));
        }
        return ResponseEntity.status(400).body("not found");
    }
}
