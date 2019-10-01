package com.home.onlineshop.entity;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class Cart {

    private HashMap<Long, Long> wareMap;

    public Cart(HashMap<Long, Long> wareMap) {
        this.wareMap = wareMap;
    }

    public void addWareToCart(Long wareId, Long count) {
        wareMap.put(wareId, count);
    }

    public boolean containsKey(Long wareId) {
        return wareMap.containsKey(wareId);
    }

    public void removeWare(Long wareId) {
        wareMap.remove(wareId);
    }

    public void clear() {
        wareMap.clear();
    }

    public boolean isEmpty() {
        return wareMap.isEmpty();
    }
}
