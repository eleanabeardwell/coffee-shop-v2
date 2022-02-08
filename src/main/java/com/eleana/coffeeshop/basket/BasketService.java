package com.eleana.coffeeshop.basket;

import com.eleana.coffeeshop.product.Product;

public class BasketService {

    private Basket basket;

    public BasketService() {
        this.basket = new Basket();
    }

    public void addProduct(Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            basket.addContents(product);
        }
    }

    public void addProduct(Product product) {
            basket.addContents(product);
    }

    public void removeProduct(Product product) {
        basket.removeContents(product);
    }

    public void removeProduct(Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            basket.removeContents(product);
        }
    }

//    public void checkout() {
//        for(Product product: basket.getContents()) {
//            product.depleteStockLevel();
//        }
//        ReceiptService.getReceipt(basket);
//    }

    public Basket getBasket() {
        return basket;
    }
}
