-- (이미 데이터베이스는 있기 때문에 CREATE DATABASE/USE 없음)

-- 안전 삭제
BEGIN EXECUTE IMMEDIATE 'DROP TABLE products CASCADE CONSTRAINTS'; EXCEPTION WHEN OTHERS THEN NULL; END;

BEGIN EXECUTE IMMEDIATE 'DROP SEQUENCE products_seq'; EXCEPTION WHEN OTHERS THEN NULL; END;


-- 테이블
CREATE TABLE products (
  id        NUMBER PRIMARY KEY,
  name      VARCHAR2(100) NOT NULL,
  price     NUMBER(10)    NOT NULL,
  quantity  NUMBER(10)    NOT NULL,
  created_at DATE DEFAULT SYSDATE,
  updated_at DATE DEFAULT SYSDATE
);

-- 시퀀스
CREATE SEQUENCE products_seq START WITH 1 INCREMENT BY 1 NOCACHE;

-- updated_at 자동 갱신 트리거
CREATE OR REPLACE TRIGGER trg_products_upd
BEFORE UPDATE ON products
FOR EACH ROW
BEGIN
  :NEW.updated_at := SYSDATE;
END;


-- 샘플 데이터(선택)
INSERT INTO products (id, name, price, quantity)
VALUES (products_seq.NEXTVAL, 'Keyboard', 45000, 10);

INSERT INTO products (id, name, price, quantity)
VALUES (products_seq.NEXTVAL, 'Mouse', 22000, 20);

COMMIT;
