package com.voice_food_order.vfo.repository;

import com.voice_food_order.vfo.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    Menu findByNameIgnoreCase(String name);
}

