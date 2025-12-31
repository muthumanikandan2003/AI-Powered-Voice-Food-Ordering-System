package com.voice_food_order.vfo.repository;

import com.voice_food_order.vfo.model.Order;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import java.util.List;



public interface OrderRepository extends JpaRepository<Order, Long> {
}
