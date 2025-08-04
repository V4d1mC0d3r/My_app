--liquibase formatted sql
--changeset vadim:create-two-factor

CREATE TABLE two_factor_codes (
                                  email       VARCHAR(255) REFERENCES users(email) ON DELETE CASCADE,
                                  code        CHAR(6),
                                  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  expires_at  TIMESTAMP,
                                  used        BOOLEAN DEFAULT FALSE,
                                  PRIMARY KEY (email, code)
);
