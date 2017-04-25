package com.tencent.lucas.demo.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.tencent.lucas.demo.guice.impl.ItemServiceImpl;
import com.tencent.lucas.demo.guice.impl.OrderServiceImpl;

import static com.google.inject.Scopes.SINGLETON;

/**
 * Created by lucasfu on 2016/8/25.
 */
public class AppModule extends AbstractModule {


    @Override
    protected void configure() {
        final Binder binder = binder();
        //TODO: bind interface
        binder.bind(ItemService.class).to(ItemServiceImpl.class).in(SINGLETON);
        binder.bind(OrderService.class).to(OrderServiceImpl.class).in(SINGLETON);
        //TODO: bind self class(without interface or base class)
        binder.bind(PriceService.class).in(SINGLETON);

    }
}
