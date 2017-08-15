CREATE TABLE users
(
   USERNAME          VARCHAR(30)   NOT NULL,
   ENCODED_PASSWORD  VARCHAR(256),
   `ADMIN_ROLE`      VARCHAR(20),
   `STATUS`          INT            DEFAULT 1,
   `CREATE_NAME`     VARCHAR(30)    DEFAULT 'sys01' COMMENT '創建者名',
   `CREATE_DATE`     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '創建日時',
   `UPDATE_NAME`     VARCHAR(30)    DEFAULT 'sys01' COMMENT '更新者名',
   `UPDATE_DATE`     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時',
   PRIMARY KEY (USERNAME)
);