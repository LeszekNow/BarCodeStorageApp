package com.leszeknowinski.BarCodeStorageApp.models.services;

import com.leszeknowinski.BarCodeStorageApp.models.BarCodeEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BasketService {
    private List<BarCodeEntity>barCodeEntityList;

    public BasketService(){
        barCodeEntityList = new ArrayList<>();
    }

    public void addProdToList(BarCodeEntity barCodeEntity){
        barCodeEntityList.add(barCodeEntity);
    }

    public void removeProdFromList(int id){
        for(BarCodeEntity entity : barCodeEntityList) {
            if (entity.getId() == id) {
                barCodeEntityList.add(entity);
            }
        }
    }

    public int getBasketSize(){
        return barCodeEntityList.size();
    }

    public List<BarCodeEntity>getBasketList(){
        return barCodeEntityList;
    }

    public boolean isIdOnList(int id){
       return barCodeEntityList.stream().anyMatch(s -> s.getId() == id);
    }
}
