package app.crm.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    private final int trout;
    private final int caviar;
    @Column("cod_liver")
    private final int codLiver;

    public Product(int trout, int caviar, int codLiver) {
        this(null,trout,caviar,codLiver);
    }

    @PersistenceCreator
    public Product(Long id, int trout, int caviar, int codLiver) {
        this.id = id;
        this.trout = trout;
        this.caviar = caviar;
        this.codLiver = codLiver;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", trout=" + trout +
                ", caviar=" + caviar +
                ", codLiver=" + codLiver +
                '}';
    }
}
