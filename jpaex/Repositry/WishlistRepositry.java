package com.example.jpaex.Repositry;

import com.example.jpaex.Model.Wishlist;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepositry extends JpaRepository<Wishlist,Integer> {

}
