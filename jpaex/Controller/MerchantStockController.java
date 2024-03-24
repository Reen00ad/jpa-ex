package com.example.jpaex.Controller;

import com.example.jpaex.ApiResponce.ApiResponce;
import com.example.jpaex.Model.MerchantStock;
import com.example.jpaex.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
         merchantStockService.addMerchantStock(merchantStock);

            return ResponseEntity.status(200).body(new ApiResponce("MerchantStock added"));}


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id, @RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=merchantStockService.updateMerchantStock(id,merchantStock);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("MerchantStock updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id){
        boolean isdeleted=merchantStockService.deleteMerchantStock(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("MerchantStock deleted"));
        }
        return ResponseEntity.status(400).body("not found");
    }


    @PutMapping("addstock/{productid}/{merchantid}/{add}")
    public ResponseEntity addstock(@PathVariable int productid, @PathVariable int merchantid,@PathVariable int add){

        merchantStockService.addstock(productid,merchantid,add);

            return ResponseEntity.status(200).body(new ApiResponce("stock change"));}


    @GetMapping("/bystock/{stock}")
    public ResponseEntity bystock(@PathVariable int stock){
        List<MerchantStock> s=merchantStockService.bystock(stock);
        if(s==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(s);
    }



}
