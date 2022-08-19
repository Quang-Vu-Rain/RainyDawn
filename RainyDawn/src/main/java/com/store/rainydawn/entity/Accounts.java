package com.store.rainydawn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts implements UserDetails {

    protected static final String PK = "id";

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, precision = 10)
    private int id;
    @Column(name = "Username", nullable = false, length = 50)
    private String username;
    @Column(name = "Password", nullable = false, length = 255)
    private String password;
    @Column(name = "Fullname", nullable = false, length = 50)
    private String fullname;
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Column(name = "Photo", nullable = false, length = 50)
    private String photo;

    @OneToMany(mappedBy = "accounts")
    @JsonIgnore
    private Set<Orders> orders;

//    @OneToMany(mappedBy="accounts")
//    @JsonIgnore
//    private Set<AccountsRoles> accountsRoles;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "accounts_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Roles> role = getRoles();
        for (Roles r : role){
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
