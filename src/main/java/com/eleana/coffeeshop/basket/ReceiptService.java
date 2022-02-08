package com.eleana.coffeeshop.basket;

import com.eleana.coffeeshop.product.Product;

public class ReceiptService {

    public static void getReceipt(Basket basket) {
        StringBuilder output = new StringBuilder()
                .append("---------------- \n")
                .append("PRINTING RECEIPT \n")
                .append("---------------- \n")
                .append("Item          Price \n")
                .append("----          ----- \n");
        for(Product product: basket.getContents()) {
            output.append(product.getProductName())
                    .append(" ")
                    .append("         ")
                    .append(product.getBasePrice().add(product.getAdditionalCost()))
                    .append("\n");
        }
        output.append("              ----- \n")
                .append("Total          ")
                .append(basket.getTotalBasketPrice())
                .append("\n----------------\n");
        System.out.print(output);
    };
}
