--liquibase formatted sql
--changeset vadim:create-cards

CREATE TABLE cards (
                       id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       email        VARCHAR(255) REFERENCES users(email) ON DELETE CASCADE,
                       account_id   UUID REFERENCES accounts(id) ON DELETE CASCADE,
                       card_number  CHAR(16) UNIQUE,
                       card_type    TYPE_CARD NOT NULL,
                       valid_until  DATE,
                       cvv_hash     VARCHAR(255),
                       is_active    BOOLEAN DEFAULT true,
                       created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
