--liquibase formatted sql
--changeset vadim:create-types

CREATE TYPE TYPE_USER_ROLE AS ENUM (
    'individual',
    'self_employed',
    'ip',
    'too',
    'ao'
);

CREATE TYPE TYPE_ACCOUNT AS ENUM (
    'nakopitelniy',
    'osnovnoy',
    'kreditniy'
);

CREATE TYPE TYPE_CARD AS ENUM (
    'debit',
    'credit'
);

CREATE TYPE TYPE_TRANSACTION AS ENUM (
    'internal',
    'p2p',
    'external'
);

CREATE TYPE TYPE_TRANSACTION_STATUS AS ENUM (
    'pending',
    'completed',
    'failed'
);
