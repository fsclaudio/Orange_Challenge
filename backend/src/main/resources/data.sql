INSERT INTO tb_address (publicarea, number, complement, district, city, state, zipcode)
VALUES ('Rua Jasiel',100,'Bloco 27 apt 302','Jabotiana','Aracaju','SE','49098-780');
INSERT INTO tb_address (publicarea, number, complement, district, city, state, zipcode)
VALUES ('Avenica Nestor Sampaio',2250,'Parque dos Motorista','Luzia','Aracaju','SE','49045-015');
INSERT INTO tb_address (publicarea, number, complement, district, city, state, zipcode)
VALUES ('Rua A (Res Águas Belas)',85,'','Aruana','Aracaju','SE','49001-353');
INSERT INTO tb_address (publicarea, number, complement, district, city, state, zipcode)
VALUES ('Rua B (Res Flores Belas)',985,'','Aruana','Aracaju','SE','49001-353');

INSERT INTO tb_users (name,email,cpf,birtdate) VALUES('CLAUDIO FRANCISCO','fsclaudio@gmail.com','02224856900',TIMESTAMP WITH TIME ZONE '1975-07-13T20:50:07.12345Z');
INSERT INTO tb_users (name,email,cpf,birtdate) VALUES('FRANCISCO JOSE','franciscoj@gmail.com','02724856902',TIMESTAMP WITH TIME ZONE '2012-07-13T20:50:07.12345Z');
INSERT INTO tb_users (name,email,cpf,birtdate) VALUES('MARIO ANDRADE','marioand@gmail.com','52264850903',TIMESTAMP WITH TIME ZONE '2003-07-13T20:50:07.12345Z');

INSERT INTO tb_user_address (user_id,address_id) VALUES (1,2);
INSERT INTO tb_user_address (user_id,address_id) VALUES (2,2);
INSERT INTO tb_user_address (user_id,address_id) VALUES (1,3);
INSERT INTO tb_user_address (user_id,address_id) VALUES (2,4);
INSERT INTO tb_user_address (user_id,address_id) VALUES (3,3);
INSERT INTO tb_user_address (user_id,address_id) VALUES (3,1);
