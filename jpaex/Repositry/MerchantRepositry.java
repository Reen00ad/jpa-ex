package com.example.jpaex.Repositry;

import com.example.jpaex.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepositry extends JpaRepository<Merchant,Integer> {
}
