package app.dto;

import app.crm.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {

    private Long id;
    private String name;
    private String phone;
    private int city;
    private String notice;
    private int trout;
    private int caviar;
    private int codLiver;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.name = order.getClient().getName();
        this.phone = order.getClient().getPhone();
        this.city = order.getCity();
        this.notice = order.getNotice();
        this.trout = order.getProduct().getTrout();
        this.caviar = order.getProduct().getCaviar();
        this.codLiver = order.getProduct().getCodLiver();
    }
}
