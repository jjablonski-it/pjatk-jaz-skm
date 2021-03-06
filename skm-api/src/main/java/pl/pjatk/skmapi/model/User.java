package pl.pjatk.skmapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetails;
import pl.pjatk.skmapi.service.DbEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User implements DbEntity, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String authority;

    public User(String login, String password, String authority) {
        this.login = login;
        this.password = password;
        this.authority = authority;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(authority);
        return Arrays.stream(this.authority.split(",")).map(String::trim).filter(authority -> !authority.equals("")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public void addAuthority(GrantedAuthority authority) {
        String trimmedAuthority = authority.getAuthority().trim();
        String currentAuthority = this.authority == null ? "" : (this.authority + ",");
        this.authority = currentAuthority + trimmedAuthority;
    }

    public void removeAuthority(GrantedAuthority authority) {
        String auth = authority.getAuthority().trim();
        String newAuthority = this.authority.replace(auth, "").replace(",,", "").trim();
        this.authority = newAuthority;
    }

    public void setStringAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
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

    @Override
    public Long getId() {
        return this.id;
    }
}
