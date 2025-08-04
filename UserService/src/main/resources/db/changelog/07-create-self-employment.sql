--liquibase formatted sql
--changeset vadim:create-self-employment

CREATE TABLE self_employment (
                                 email         VARCHAR(255) PRIMARY KEY REFERENCES users(email) ON DELETE CASCADE,
                                 region        VARCHAR(100),
                                 activity      VARCHAR(255),
                                 iin           CHAR(12),
                                 registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
