--liquibase formatted sql
--changeset vadim:create-users

CREATE TABLE users (
                       email              VARCHAR(255) PRIMARY KEY,   -- ID
                       password_hash      VARCHAR(255) NOT NULL,	  -- Хэш пароля пользователя. Сюда сохраняется результат, например, алгоритма bcrypt, scrypt или argon2. Сам пароль в базе не хранится.
                       full_name          VARCHAR(255),			      -- ФИО.
                       phone              VARCHAR(20),			      -- Номер телефона(Он всегда один).
                       iin                CHAR(12),                   -- 12 символов (ИИН)(Он всегда один).
                       passport_number    VARCHAR(20),			      -- Паспортный номер(Он тоже всегда должен быть один).
                       passport_issued_by VARCHAR(255),			      -- Орган, выдавший паспорт. Например: "МВД РК".
                       passport_issue_date DATE,				      -- Дата выдачи паспорта. В формате YYYY-MM-DD
                       address            TEXT, 				      -- Адрес регистрации или доставки.
                       created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- Время создания записи. Автоматически выставляется при создании
                       updated_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP    -- Время последнего обновления. Можно обновлять через триггер или вручную при любом изменении записи.
);