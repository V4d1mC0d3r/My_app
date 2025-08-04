--liquibase formatted sql
--changeset vadim:recreate-type-user-role-enum

-- 1️⃣ Удаляем зависимость от старого типа
ALTER TABLE user_roles DROP CONSTRAINT IF EXISTS user_roles_pkey;
ALTER TABLE user_roles ALTER COLUMN role TYPE VARCHAR(50);

-- 2️⃣ Удаляем старый ENUM, если есть
DROP TYPE IF EXISTS type_user_role CASCADE;

-- 3️⃣ Создаем новый ENUM с правильными значениями
CREATE TYPE type_user_role AS ENUM ('INDIVIDUAL', 'SELF_EMPLOYED', 'IP', 'TOO', 'AO', 'ADMIN');

-- 4️⃣ Приводим колонку обратно к ENUM
ALTER TABLE user_roles ALTER COLUMN role TYPE type_user_role USING role::type_user_role;

-- 5️⃣ Возвращаем первичный ключ
ALTER TABLE user_roles ADD PRIMARY KEY (email, role);
