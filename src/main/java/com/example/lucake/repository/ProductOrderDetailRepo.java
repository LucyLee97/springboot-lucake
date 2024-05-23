package com.example.lucake.repository;

import com.example.lucake.entity.ProductOrder;
import com.example.lucake.entity.ProductOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDetailRepo extends JpaRepository<ProductOrderDetail, Long> {

    @Modifying
    @Query("delete ProductOrderDetail c where c.productOrder=?1")
    void deleteByProductOrder(ProductOrder productOrder);

//    void deleteByCustomerOrder(CustomerOrder customerOrder);
}
