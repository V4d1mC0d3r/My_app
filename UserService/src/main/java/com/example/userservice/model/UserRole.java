package com.example.userservice.model;

import com.example.userservice.model.enums.UserRoleType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("email")
    @JoinColumn(name = "email")
    private User user;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt = LocalDateTime.now();

    public UserRole() {
    }

    public UserRole(User user, UserRoleType role) {
        this.user = user;
        this.id = new UserRoleId(user.getEmail(), role);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRoleId getId() {
        return id;
    }

    public void setId(UserRoleId id) {
        this.id = id;
    }

    public String getEmail() {
        return id != null ? id.getEmail() : null;
    }

    public UserRoleType getRole() {
        return id != null ? id.getRole() : null;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
}
