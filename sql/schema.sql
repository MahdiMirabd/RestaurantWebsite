CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    price NUMERIC (12, 2) NOT NULL,
    calories NUMERIC NOT NULL
    /*allergen VARCHAR,*/
);

INSERT INTO menu (name, price, calories)
VALUES  ('Burito', 20.50, 90),
        ('Nachos', 10.50, 100),
        ('Tacos', 15, 120),
        ('Quesadillas', 13, 80);
    