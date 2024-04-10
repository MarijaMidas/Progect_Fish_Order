package app.crm.model;

import app.dto.OrderDTO;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table(name = "orders")
public class Order {
    @Id
    private final Long id;

    @Column("date_create")
    private LocalDateTime created;

    @Column("completed")
    private Boolean completed;

    @Nonnull
    private final int city;

    @MappedCollection(idColumn = "order_key")
    private final Client client;

    private final String notice;

    @MappedCollection(idColumn = "order_key")
    private final Product product;

    public Order(OrderDTO dto) {
        this(dto.getId(),
                dto.getCity(),
                new Client(dto.getName(), dto.getPhone()),
                dto.getNotice(),
                new Product(dto.getTrout(),dto.getCaviar(), dto.getCodLiver())
        );
        this.created = LocalDateTime.now();
        this.completed = false;
    }

    @PersistenceCreator
    public Order(Long id, int city, Client client, String notice,Product product) {
        this.id = id;
        this.city = city;
        this.client = client;
        this.notice = notice;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", city=" + city +
                ", client=" + client +
                ", notice='" + notice + '\'' +
                ", product=" + product +
                '}';
    }
}
