package com.example.shaurma.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.example.shaurma.models.ShaurmaOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<ShaurmaOrder, Long> {
    List<ShaurmaOrder> findByDeliveryZip(String deliveryZip);
    List<ShaurmaOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);
}
