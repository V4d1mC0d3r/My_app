--liquibase formatted sql
--changeset vadim:create-transactions

CREATE TABLE transactions (
                              id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                              sender_account   UUID REFERENCES accounts(id),
                              receiver_account UUID REFERENCES accounts(id),
                              amount           NUMERIC(18, 2),
                              currency         CHAR(3) DEFAULT 'KZT',
                              type             TYPE_TRANSACTION,
                              status           TYPE_TRANSACTION_STATUS DEFAULT 'pending',
                              created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              description      TEXT
);
