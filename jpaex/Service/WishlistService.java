package com.example.jpaex.Service;

import com.example.jpaex.Model.Product;
import com.example.jpaex.Model.User;
import com.example.jpaex.Model.Wishlist;
import com.example.jpaex.Repositry.ProductRepositry;
import com.example.jpaex.Repositry.UserRepositry;
import com.example.jpaex.Repositry.WishlistRepositry;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepositry wishlistRepositry;
    private final UserRepositry userRepositry;
    private final ProductRepositry productRepositry;

    public List<Wishlist> getWishlist() {
      return wishlistRepositry.findAll();
    }

    public void addWishlist(Wishlist wishlist) {
         wishlistRepositry.save(wishlist);
    }

    public Boolean deleteWishlist(Integer id){
        Wishlist w=wishlistRepositry.getById(id);
        if(w==null){
            return false;
        }
        wishlistRepositry.delete(w);


        return true;
    }
    public Wishlist addProductToWishlist(Integer userId, Integer productId) {
        Optional<Product> product = productRepositry.findById(productId);

        Wishlist wishlist = new Wishlist();
        wishlist.setUid(userId);
        wishlist.setPid(productId);

        return wishlistRepositry.save(wishlist);
    }
}
