package com.example.adpostingrestapi.Model.Post;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum PostCategory {
    BuyAndSell("Buy and Sell"),
    CarsAndVehicles("Cars and Vehicles"),
    RealEstate("Real Estate"),
    Jobs("Jobs"),
    Services("Services");

    private final String categoryName;
}
