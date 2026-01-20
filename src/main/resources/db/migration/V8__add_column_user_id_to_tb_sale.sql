ALTER TABLE tb_sales
    ADD COLUMN user_id BINARY(16) NOT NULL;

ALTER TABLE tb_sales
    ADD CONSTRAINT fk_sales_user
        FOREIGN KEY (user_id) REFERENCES tb_users(user_id);