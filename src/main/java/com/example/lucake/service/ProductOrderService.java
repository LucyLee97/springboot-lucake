package com.example.lucake.service;

import com.example.lucake.entity.ProductOrder;
import com.example.lucake.entity.ProductOrderDetail;
import com.example.lucake.repository.ProductOrderDetailRepo;
import com.example.lucake.repository.ProductOrderRepo;
import com.example.lucake.service.dto.ProductOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepo productOrderRepo;

    @Autowired
    private ProductOrderDetailRepo productOrderDetailRepo;

    public ProductOrder createOrder(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCustomerId(productOrderDto.getCustomerId());
        productOrder.setStatus(1);

        List<ProductOrderDetail> newDetailList = new ArrayList<>();
        productOrderDto.getProductOrderDetailDtoList().forEach(d -> {
            ProductOrderDetail cod = new ProductOrderDetail();
            cod.setProductId(d.getProductId());
            cod.setQuantity(d.getQuantity());
            cod.setProductOrder(productOrder);
            newDetailList.add(cod);
        });

        productOrder.setProductOrderDetailList(newDetailList);
        return productOrderRepo.save(productOrder);
    }

    public ProductOrder getProductOrder(String id) {
        return productOrderRepo.findById(id).orElse(new ProductOrder());
    }

    @Transactional
    public ProductOrder updateOrder(ProductOrderDto productOrderDto) {
        Optional<ProductOrder> productOrderOptional = productOrderRepo.findById(productOrderDto.getId());
        if (productOrderOptional.isPresent()) {
            ProductOrder productOrder = productOrderOptional.get();

            productOrderDetailRepo.deleteByProductOrder(productOrder);

            List<ProductOrderDetail> newDetailList = new ArrayList<>();
            productOrderDto.getProductOrderDetailDtoList().forEach(d -> {
                ProductOrderDetail cod = new ProductOrderDetail();
                cod.setProductId(d.getProductId());
                cod.setQuantity(d.getQuantity());
                cod.setProductOrder(productOrder);
                newDetailList.add(cod);
            });

            productOrder.setProductOrderDetailList(newDetailList);
            productOrder.setStatus(2);
            return productOrderRepo.save(productOrder);
        }
        return new ProductOrder();
    }
}
