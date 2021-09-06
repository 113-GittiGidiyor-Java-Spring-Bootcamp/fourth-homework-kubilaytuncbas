package com.example.moneyconverter.repository;

import com.example.moneyconverter.model.Money;
import org.springframework.data.repository.CrudRepository;

public interface MoneyDao extends CrudRepository<Money,Integer> {
}
