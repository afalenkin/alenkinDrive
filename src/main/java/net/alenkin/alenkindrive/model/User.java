package net.alenkin.alenkindrive.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 * <p>
 * Represents the owner of {@link StoredFile} and {@link Event}
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name", columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "role", columnDefinition = "VARCHAR")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "status", columnDefinition = "VARCHAR")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", columnDefinition = "VARCHAR")
    private String password;


    public User(Long id, String name) {
        super(id);
        this.name = name;
    }

    public User(String name) {
        this(null, name);
    }

    public User(String name, Role role, Status status, String password) {
        super();
        this.name = name;
        this.role = role;
        this.status = status;
        this.password = password;
    }
}
