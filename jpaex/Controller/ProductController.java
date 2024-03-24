package com.example.jpaex.Controller;

import com.example.jpaex.ApiResponce.ApiResponce;
import com.example.jpaex.Model.Product;
import com.example.jpaex.Repositry.ProductRepositry;
import com.example.jpaex.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;
    private final ProductRepositry productRepositry;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getProduct());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);

            return ResponseEntity.status(200).body(new ApiResponce("product added"));}


    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=productService.updateProduct(id,product);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("product updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        boolean isdeleted=productService.deleteProduct(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("product deleted"));
        }
        return ResponseEntity.status(400).body("not found");
    }

//



    @GetMapping("/bycategory/{categoryid}/{min}")
    public ResponseEntity bycategory(@PathVariable Integer categoryid,@PathVariable Integer min){
        ArrayList<Product> c=productService.bycategory(categoryid,min);
        if(c==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(c);
    }

}
