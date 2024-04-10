package app.crm.model;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "clients")
public class Client {

    @Id
    private final Long id;

    @Nonnull
    private final String name;

    @Nonnull
    private final String phone;


    public Client(String name, String phone) {
        this(null, name, phone);
    }

    @PersistenceCreator
    public Client(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
