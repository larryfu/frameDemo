package com.tencent.lucas.demo.guice.impl;


import com.google.inject.Inject;
import com.tencent.lucas.demo.guice.ItemService;
import com.tencent.lucas.demo.guice.OrderService;
import com.tencent.lucas.demo.guice.PriceService;

/**
 * Created by lucasfu on 2016/8/25.
 */
public class OrderServiceImpl implements OrderService {

    private ItemService itemService;
    private PriceService priceService;

    @Inject
    public OrderServiceImpl(ItemService itemService, PriceService priceService) {
        this.itemService = itemService;
        this.priceService = priceService;
    }
}
