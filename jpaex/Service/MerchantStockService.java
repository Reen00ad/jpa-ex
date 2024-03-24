package com.example.jpaex.Service;

import com.example.jpaex.Model.Category;
import com.example.jpaex.Model.Merchant;
import com.example.jpaex.Model.MerchantStock;
import com.example.jpaex.Model.Product;
import com.example.jpaex.Repositry.MerchantRepositry;
import com.example.jpaex.Repositry.MerchantStockRepositry;
import com.example.jpaex.Repositry.ProductRepositry;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    private final MerchantStockRepositry merchantStockRepositry;
    private final MerchantRepositry merchantRepositry;
    private final ProductRepositry productRepositry;


    public List<MerchantStock> getMerchantStock(){
        return merchantStockRepositry.findAll();
    }

    public void addMerchantStock(MerchantStock merchantStock){
        merchantStockRepositry.save(merchantStock);
    }

    public Boolean updateMerchantStock(Integer id,MerchantStock merchantStock) {
        MerchantStock ms = merchantStockRepositry.getById(id);
        if (ms == null) {
            return false;
        }

        ms.setProductid(merchantStock.getProductid());
        ms.setMerchantid(merchantStock.getMerchantid());
        ms.setStock(merchantStock.getStock());

        merchantStockRepositry.save(ms);

        return true;
    }

    public Boolean deleteMerchantStock(Integer id){
        MerchantStock ms=merchantStockRepositry.getById(id);
        if(ms==null){
            return false;
        }
        merchantStockRepositry.delete(ms);


        return true;
    }

    public void addstock(Integer productid, Integer merchantid , Integer add) {

        Optional<MerchantStock> optionalMerchantStock=merchantStockRepositry.findByProductidAndMerchantid(productid,merchantid);
        if(optionalMerchantStock.isPresent()){
            MerchantStock merchantStock=optionalMerchantStock.get();
            int stocks=merchantStock.getStock();
            merchantStock.setStock(stocks+add);
            merchantStockRepositry.save(merchantStock);
        }
        else {
            MerchantStock ms=new MerchantStock();
            ms.setProductid(productid);
            ms.setMerchantid(merchantid);
            ms.setStock(add);
            merchantStockRepositry.save(ms);
        }}



    public List<MerchantStock> bystock(int stock){
       return merchantStockRepositry.findByStockGreaterThanEqual(stock);
//
    }


    }