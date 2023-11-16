package com.graduation.graProject.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.graduation.graProject.Offers.OfferEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "_USER_")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cin;
    private String username;
    private String first_name;
    private String last_name;
    private String email;

    @Column(nullable = true)
    private Integer phone;

    @Column(nullable = true)
    private String address;

    private String password;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(nullable = true)
    private Date birthday;

    @Column(nullable = true)
    private String occupation;

    @Column(nullable = true)
    private String establishment;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    @ManyToMany
            @JoinTable(
                    name = "user_offers",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "offer_id")
            )
    @Column(nullable = true)
    List<OfferEntity> offersRelated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
