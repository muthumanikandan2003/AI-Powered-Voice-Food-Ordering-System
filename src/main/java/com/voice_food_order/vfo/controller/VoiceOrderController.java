package com.voice_food_order.vfo.controller;

import com.voice_food_order.vfo.dto.VoiceRequest;
import com.voice_food_order.vfo.service.VoiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/voice")
@CrossOrigin
public class VoiceOrderController {

    @Autowired
    private VoiceOrderService service;
    @PostMapping("/order")
    public String order(@RequestBody VoiceRequest req) {
        return service.processVoiceOrder(req.getCommand());
    }

    @PostMapping("/address")
    public String address(@RequestBody VoiceRequest req) {
        return service.processAddress(req.getCommand());
    }

}
