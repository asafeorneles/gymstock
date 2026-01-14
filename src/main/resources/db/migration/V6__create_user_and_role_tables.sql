CREATE TABLE tb_users
(
    user_id  BINARY(16) PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE tb_roles
(
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE tb_users_roles
(
    user_id BINARY(16) NOT NULL,
    role_id BIGINT NOT NULL,

    PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_users_roles_user
        FOREIGN KEY (user_id) REFERENCES tb_users (user_id),

    CONSTRAINT fk_users_roles_role
        FOREIGN KEY (role_id) REFERENCES tb_roles (role_id)
);

INSERT
IGNORE INTO tb_roles (name) VALUES
('ROLE_ADMIN'),
('ROLE_BASIC');