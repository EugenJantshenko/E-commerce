package com.home.onlineshop.service.customer;

public interface CustomerService {
    boolean addToCart(Long wareNameId, Long count);
    boolean removeFromCart(Long wareNameId);
    void clearCart();
    boolean buyWares();
}