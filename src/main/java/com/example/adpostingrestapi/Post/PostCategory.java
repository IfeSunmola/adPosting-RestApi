package com.example.adpostingrestapi.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostCategory {
    BuyAndSell("Buy and Sell"),
    CarsAndVehicles("Cars and Vehicles"),
    RealEstate("Real Estate"),
    Jobs("Jobs"),
    Services("Services");

    private final String categoryName;
}
