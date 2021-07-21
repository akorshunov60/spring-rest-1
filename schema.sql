CREATE TABLE IF NOT EXISTS users (
  id        INT IDENTITY,
  name      VARCHAR2 NOT NULL);

DROP TABLE IF EXISTS orders;
CREATE TABLE IF NOT EXISTS orders (
  id        INT IDENTITY,
  user_id    INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id));

DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (
  id        INT IDENTITY,
  name      VARCHAR2 NOT NULL,
  price     DECIMAL(10,2) NOT NULL);

DROP TABLE IF EXISTS order_products;
CREATE TABLE IF NOT EXISTS order_products (
  id        INT IDENTITY,
  order_id   INT NOT NULL,
  product_id INT NOT NULL,
  quantity  INT NOT NULL,
  acquire_price DECIMAL(10,2) NOT NULL,
  CONSTRAINT uk_order_products UNIQUE (order_id, product_id),
  CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders(id),
  CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products(id));


INSERT INTO users (name)
VALUES ('Sergey'),
       ('Nikita'),
       ('Daniil');

INSERT INTO orders (user_id)
VALUES (1),
       (1),
       (1),
       (2),
       (1),
       (3);

INSERT INTO products (name, price)
VALUES ('Молоко 3,5%, 1 л', 89.99),
       ('Сметана 15%, 300 г', 75.99),
       ('Хлеб Бородинский, 300 г', 21.99),
       ('Сыр Четук 45%, 370 г', 231.99),
       ('Хлопья овсяные, 500 г', 63.99),
       ('Говяжий стейк Стриплойн Глобус, 1 кг', 849.90),
       ('Стейк Рибай Мираторг, 500 г', 839.99),
       ('Филе куриной грудки в сливочном маринаде, 1 кг', 449.90),
       ('Купаты из индейки Индилайт Боярские, 500 г', 239.99),
       ('Бедро куриное с маринадом гриль, 1 кг', 259.90),
       ('Батон Европейский, 330 г', 26.99),
       ('Хлеб Дарницкий Коломенское, нарезка, 350 г', 35.99),
       ('Майонез Слобода Оливковый 67%, 400 мл', 79.99),
       ('Майонез Лёгкий Calve, 400 г', 68.99),
       ('Творог Дмитровский молочный завод 5%, 180 г', 79.99),
       ('Творог Домик в деревне 5,5%, 170 г', 49.99),
       ('Творог со сливками Царка с наполнителем Яблоко-груша-злаки 5%, 200 г', 76.99),
       ('Творог со сливками Царка с наполнителем Лесные ягоды 5%, 200 г', 76.99),
       ('Яйца куриные Праксис отборной категории С0, 10 шт.', 99.99),
       ('Яйцо куриное Глобус выcшей категории СВ, 10 шт.', 112.99),
       ('Яйца перепелиные пищевые столовые Глобус, 20 шт.', 87.99);

INSERT INTO order_products (product_id, order_id, quantity, acquire_price)
VALUES (1, 1, 1, 87.99),
       (3, 1, 3, 20.99),
       (4, 1, 5, 231.99),
       (1, 2, 3, 89.99),
       (1, 3, 2, 89.99),
       (4, 3, 6, 231.99),
       (5, 4, 1, 63.99),
       (1, 5, 7, 89.99),
       (5, 5, 5, 63.99),
       (1, 6, 6, 89.99),
       (2, 6, 7, 75.99),
       (4, 6, 8, 231.99),
       (5, 6, 9, 63.99);