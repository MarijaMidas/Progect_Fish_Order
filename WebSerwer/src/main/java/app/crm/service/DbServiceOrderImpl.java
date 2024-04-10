package app.crm.service;

import app.crm.model.Order;
import app.crm.repository.OrderRepository;
import app.sessionmanager.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbServiceOrderImpl implements DBServiceOrder {
    private static final Logger log = LoggerFactory.getLogger(DbServiceOrderImpl.class);

    private final TransactionManager transactionManager;
    private final OrderRepository orderRepository;

    public DbServiceOrderImpl(TransactionManager transactionManager, OrderRepository orderRepository) {
        this.transactionManager = transactionManager;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return transactionManager.doInTransaction(() -> {
            var savedOrder = orderRepository.save(order);
            log.info("saved client: {}", savedOrder);
            return savedOrder;
        });
    }

    @Override
    public List<Order> findAll() {
        var orderList = orderRepository.findAll();
        log.info("orderList:{}", orderList);
        return orderList;
    }

    @Override
    public List<Order> getOrdersByClientPhoneNumber(String phoneNumber) {
        return orderRepository.findByClientPhoneNumber(phoneNumber);
    }

    @Override
    public List<Order> findAllByCompleted(String complete) {
        return orderRepository.findAllByCompleted(complete);
    }

    @Override
    public List<Order> findAllByCity(String city) {
        return orderRepository.findAllByCity(city);
    }


}
