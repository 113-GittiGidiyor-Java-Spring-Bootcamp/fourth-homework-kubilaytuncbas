package com.example.moneyconverter.service;

import com.example.moneyconverter.repository.MoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService implements IMoney {

    MoneyDao moneyDao;

    @Autowired
    public MoneyService(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }
    public Double exchangeMoney(int id,double money){
        double result=money*(moneyDao.findById(id).get().getFixedRate());
        return result;
    }

}
