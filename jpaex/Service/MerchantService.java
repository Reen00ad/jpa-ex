package com.example.jpaex.Service;

import com.example.jpaex.Model.Merchant;
import com.example.jpaex.Repositry.MerchantRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepositry merchantRepositry;

    public List<Merchant> getMerchant(){
        return merchantRepositry.findAll();
    }

    public void addMerchant(Merchant merchant){
        merchantRepositry.save(merchant);
    }

    public Boolean updateMerchant(Integer id,Merchant merchant) {
        Merchant m = merchantRepositry.getById(id);
        if (m == null) {
            return false;
        }

        m.setName(merchant.getName());

        merchantRepositry.save(m);

        return true;
    }

    public Boolean deleteMerchant(Integer id){
        Merchant m=merchantRepositry.getById(id);
        if(m==null){
            return false;
        }
        merchantRepositry.delete(m);


        return true;
    }
//    public boolean check(int id ){
//       if (merchantRepositry.getById(id)){
//           return true;}
//
//           return false;
//    }
}
