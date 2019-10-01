package com.home.onlineshop.service.customer;

import com.home.onlineshop.entity.Cart;

public interface CustomerService {
    boolean addToCart(Cart cart, Long wareNameId, Long count);

    boolean removeFromCart(Cart cart, Long wareNameId);

    void clearCart(Cart cart);

    boolean buyWares(Cart cart);
}