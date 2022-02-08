package com.eleana.coffeeshop.resources;

public class ProductList {
    private String allProducts = "[\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SMALL\",\n" +
                                 "            \"MEDIUM\",\n" +
                                 "            \"LARGE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"MEDIUM\",\n" +
                                 "        \"basePrice\": 2.55,\n" +
                                 "        \"productId\": 112,\n" +
                                 "        \"productName\": \"Latte\",\n" +
                                 "        \"stockLevel\": 30,\n" +
                                 "        \"additionalCost\": 0.3\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SMALL\",\n" +
                                 "            \"MEDIUM\",\n" +
                                 "            \"LARGE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"LARGE\",\n" +
                                 "        \"basePrice\": 2.55,\n" +
                                 "        \"productId\": 113,\n" +
                                 "        \"productName\": \"Latte\",\n" +
                                 "        \"stockLevel\": 30,\n" +
                                 "        \"additionalCost\": 0.6\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SINGLE\",\n" +
                                 "            \"DOUBLE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"SINGLE\",\n" +
                                 "        \"basePrice\": 1.10,\n" +
                                 "        \"productId\": 131,\n" +
                                 "        \"productName\": \"Espresso\",\n" +
                                 "        \"stockLevel\": 50,\n" +
                                 "        \"additionalCost\": 0\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"basePrice\": 1.80,\n" +
                                 "        \"productId\": 211,\n" +
                                 "        \"productName\": \"Croissant\",\n" +
                                 "        \"stockLevel\": 15,\n" +
                                 "        \"additionalCost\": 0\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SINGLE\",\n" +
                                 "            \"DOUBLE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"DOUBLE\",\n" +
                                 "        \"basePrice\": 1.10,\n" +
                                 "        \"productId\": 132,\n" +
                                 "        \"productName\": \"Espresso\",\n" +
                                 "        \"stockLevel\": 50,\n" +
                                 "        \"additionalCost\": 1.1\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SMALL\",\n" +
                                 "            \"MEDIUM\",\n" +
                                 "            \"LARGE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"SMALL\",\n" +
                                 "        \"basePrice\": 2.75,\n" +
                                 "        \"productId\": 121,\n" +
                                 "        \"productName\": \"Cappuccino\",\n" +
                                 "        \"stockLevel\": 30,\n" +
                                 "        \"additionalCost\": 0\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SMALL\",\n" +
                                 "            \"MEDIUM\",\n" +
                                 "            \"LARGE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"MEDIUM\",\n" +
                                 "        \"basePrice\": 2.75,\n" +
                                 "        \"productId\": 122,\n" +
                                 "        \"productName\": \"Cappuccino\",\n" +
                                 "        \"stockLevel\": 30,\n" +
                                 "        \"additionalCost\": 0.3\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SMALL\",\n" +
                                 "            \"MEDIUM\",\n" +
                                 "            \"LARGE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"LARGE\",\n" +
                                 "        \"basePrice\": 2.75,\n" +
                                 "        \"productId\": 123,\n" +
                                 "        \"productName\": \"Cappuccino\",\n" +
                                 "        \"stockLevel\": 30,\n" +
                                 "        \"additionalCost\": 0.6\n" +
                                 "    },\n" +
                                 "    {\n" +
                                 "        \"availableSizes\": [\n" +
                                 "            \"SMALL\",\n" +
                                 "            \"MEDIUM\",\n" +
                                 "            \"LARGE\"\n" +
                                 "        ],\n" +
                                 "        \"size\": \"SMALL\",\n" +
                                 "        \"basePrice\": 2.55,\n" +
                                 "        \"productId\": 111,\n" +
                                 "        \"productName\": \"Latte\",\n" +
                                 "        \"stockLevel\": 30,\n" +
                                 "        \"additionalCost\": 0\n" +
                                 "    }\n" +
                                 "]";

    public String getProductList() {
        return allProducts;
    }

}
