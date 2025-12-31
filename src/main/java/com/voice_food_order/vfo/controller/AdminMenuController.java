package com.voice_food_order.vfo.controller;

import com.voice_food_order.vfo.dto.AdminLoginRequest;
import com.voice_food_order.vfo.model.Menu;
import com.voice_food_order.vfo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin

public class AdminMenuController {

        @Autowired
        private MenuRepository repo;
    @PostMapping("/login")
    public boolean adminLogin(@RequestBody AdminLoginRequest request) {
        return "admin".equals(request.getUsername())
                && "admin123".equals(request.getPassword());
    }

        @PostMapping("/menu")
        public Menu addMenu(@RequestBody Menu menu) {
            return repo.save(menu);
        }

        @GetMapping("/menu")
        public List<Menu> getMenu() {
            return repo.findAll();
        }
    @PutMapping("/menu/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        Menu existing = repo.findById(id).orElseThrow();
        existing.setName(menu.getName());
        existing.setPrice(menu.getPrice());
        return repo.save(existing);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
