package com.example.jpaex.Controller;

import com.example.jpaex.Model.Product;
import com.example.jpaex.Model.User;
import com.example.jpaex.Model.Wishlist;
import com.example.jpaex.Repositry.ProductRepositry;
import com.example.jpaex.Repositry.UserRepositry;
import com.example.jpaex.Service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/wishlist")
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/get")
    public ResponseEntity getWishlist(){
        return ResponseEntity.status(200).body(wishlistService.getWishlist());
    }


    @PostMapping("/add/{uid}/{pid}")
    public ResponseEntity<Wishlist> add(@PathVariable Integer uid,@PathVariable Integer pid){
        Wishlist wishlist=wishlistService.addProductToWishlist(uid,pid);
       return ResponseEntity.status(200).body(wishlist);
    }
}
