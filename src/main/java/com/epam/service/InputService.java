package com.epam.service;

import java.util.Map;

public interface InputService {
    Map<String, Double> getPriceRange();

    double getBalance();

    int getOption();

    int getId();

}
