package app.crm.repository;

import app.crm.model.Order;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();

    @Query("SELECT orders.id AS id, orders.city AS city, orders.notice AS notice, client.id AS client_id, client.name AS client_name, client.phone AS client_phone, product.id AS product_id, product.trout AS product_trout, product.caviar AS product_caviar, product.cod_liver AS product_cod_liver FROM orders LEFT OUTER JOIN clients client ON client.order_key = orders.id LEFT OUTER JOIN products product ON product.order_key = orders.id WHERE client.phone = :phoneNumber")
    List<Order> findByClientPhoneNumber(@Param("phoneNumber") String phoneNumber);

    List<Order>findAllByCompleted(String complete);

    List<Order>findAllByCity(String city);
}
