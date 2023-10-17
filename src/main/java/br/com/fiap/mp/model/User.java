package br.com.fiap.mp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public User setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        return this;
    }
}
