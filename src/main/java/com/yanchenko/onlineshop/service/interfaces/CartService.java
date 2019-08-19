package com.yanchenko.onlineshop.service.interfaces;

public interface CartService {

    boolean addWareToCart(String name, Integer count);

    boolean removeWareFromCart(String name);

    boolean buyWareInCart();
}
