package com.voice_food_order.vfo.service;

import com.voice_food_order.vfo.exception.OrderException;
import com.voice_food_order.vfo.model.Menu;
import com.voice_food_order.vfo.model.Order;
import com.voice_food_order.vfo.repository.MenuRepository;
import com.voice_food_order.vfo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoiceOrderService {

    @Autowired
    private MenuRepository menuRepo;

    @Autowired
    private OrderRepository orderRepo;

    private Order pendingOrder;
    private double totalAmount;

    // ---------------- ORDER ----------------
    public String processVoiceOrder(String command) {

        command = command.toLowerCase();
        List<Menu> menuList = menuRepo.findAll();

        StringBuilder itemsText = new StringBuilder();
        totalAmount = 0;

        for (Menu item : menuList) {
            if (command.contains(item.getName().toLowerCase())) {
                int qty = extractQuantity(command, item.getName());
                double price = item.getPrice() * qty;
                totalAmount += price;

                itemsText.append(qty)
                        .append(" ")
                        .append(item.getName())
                        .append(", ");
            }
        }

        if (totalAmount == 0) {
            throw new OrderException("No valid food items found in your order");
        }

        pendingOrder = new Order();
        pendingOrder.setItems(itemsText.toString());
        pendingOrder.setTotalAmount(totalAmount);

   return "ADDRESS_REQUIRED|Your order total is rupees " + totalAmount +
                ". Please tell your delivery address";
    }

    // ---------------- ADDRESS ----------------
    public String processAddress(String address) {

        if (pendingOrder == null) {
            return "No pending order found";
        }

        pendingOrder.setAddress(address);
        orderRepo.save(pendingOrder);

        double amount = pendingOrder.getTotalAmount();
        pendingOrder = null;

        return "ORDER_CONFIRMED|Order placed successfully. Total amount is rupees "
                + amount + ". Thank you!";
    }


    // ---------------- QUANTITY ----------------
    private int extractQuantity(String text, String item) {
        Map<String, Integer> numbers = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4
        );

        for (String key : numbers.keySet()) {
            if (text.contains(key + " " + item)) {
                return numbers.get(key);
            }
        }
        return 1;
    }
}
