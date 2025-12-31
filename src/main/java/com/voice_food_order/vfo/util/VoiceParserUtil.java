package com.voice_food_order.vfo.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VoiceParserUtil {

    public Map<String, Integer> parse(String command) {
        Map<String, Integer> map = new HashMap<>();
        command = command.toLowerCase();
        String[] parts = command.split("and");

        for (String p : parts) {
            int qty = 1;
            if (p.contains("two")) qty = 2;
            if (p.contains("three")) qty = 3;
            if (p.contains("four")) qty = 4;
            if (p.contains("five")) qty = 5;

            String name = p.replaceAll("order|one|two|three|four|five", "").trim();
            map.put(name, qty);
        }
        return map;
    }
}
