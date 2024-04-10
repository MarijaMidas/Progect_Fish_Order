package app.crm.model;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "managers")
public class Manager {

    @Id
    private final Long id;

    @Nonnull
    private final String name;

    @Nonnull
    private final String password;



    public Manager(String name, String password){
        this(null, name,password);
    }

    @PersistenceCreator
    public Manager(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;

    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
