package com.example.userservice.model;

import com.example.userservice.model.enums.UserRoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRoleId implements Serializable {

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "type_user_role")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private UserRoleType role;

    public UserRoleId() {
    }

    public UserRoleId(String email, UserRoleType role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleType getRole() {
        return role;
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId that)) return false;
        return Objects.equals(email, that.email) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role);
    }
}
