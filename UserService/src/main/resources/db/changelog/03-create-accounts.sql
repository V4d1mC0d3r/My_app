--liquibase formatted sql
--changeset vadim:create-accounts

CREATE TABLE accounts (
                          id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          email        VARCHAR(255) REFERENCES users(email),
                          account_type TYPE_ACCOUNT NOT NULL,
                          currency     CHAR(3) DEFAULT 'KZT',
                          balance      NUMERIC(18, 2) DEFAULT 0,
                          created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);