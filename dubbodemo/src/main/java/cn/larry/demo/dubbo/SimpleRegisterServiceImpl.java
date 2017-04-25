package cn.larry.demo.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.NotifyListener;
import com.alibaba.dubbo.registry.RegistryService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fugz on 2016/4/12.
 */
public class SimpleRegisterServiceImpl implements RegistryService {

    private static final Map<URL, Set<NotifyListener>> registerCenter = new ConcurrentHashMap<>();

    @Override
    public void register(URL url) {
        if (registerCenter.get(url) == null)
            registerCenter.put(url, new HashSet<>());
    }

    @Override
    public void unregister(URL url) {
        registerCenter.remove(url);
    }

    @Override
    public void subscribe(URL url, NotifyListener listener) {
        Set<NotifyListener> listeners;
        if ((listeners = registerCenter.get(url)) != null)
            listeners.add(listener);
      //  else throw new IllegalArgumentException("服务不存在");
    }

    @Override
    public void unsubscribe(URL url, NotifyListener listener) {
        Set<NotifyListener> listeners;
        if ((listeners = registerCenter.get(url)) != null)
            listeners.remove(listener);
       // else throw new IllegalArgumentException("服务不存在");
    }

    @Override
    public List<URL> lookup(URL url) {
        return null;
    }
}
