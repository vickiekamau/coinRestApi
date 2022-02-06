package com.jokam.code.Services;

import com.jokam.code.Model.Coin;
import com.jokam.code.Repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> getCoins(){
        return (List<Coin>) coinRepository.findAll();
    }
}
