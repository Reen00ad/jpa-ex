package com.example.jpaex.Repositry;

import com.example.jpaex.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantStockRepositry extends JpaRepository<MerchantStock,Integer> {
     List<MerchantStock>findByStockGreaterThanEqual(int min);
     Optional<MerchantStock>findByProductidAndMerchantid(int pid,int mid);
}
