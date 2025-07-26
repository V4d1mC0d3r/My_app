--liquibase formatted sql
--changeset vadim:create-user-roles

CREATE TABLE user_roles (
                            email       VARCHAR(255) REFERENCES users(email) ON DELETE CASCADE,
                            role        TYPE_USER_ROLE,
                            is_active   BOOLEAN DEFAULT true,
                            assigned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (email, role)
);