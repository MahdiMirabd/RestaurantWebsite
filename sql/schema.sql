CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    price NUMERIC (12, 2) NOT NULL,
    calories NUMERIC NOT NULL,
    allergies VARCHAR (50),
    FOREIGN KEY (allergies) REFERENCES allergies(name)
);

CREATE TABLE allergies (
    name VARCHAR (50) NOT NULL PRIMARY KEY,
    description NUMERIC VARCHAR(50) NOT NULL,
);

INSERT INTO menu (name, price, calories)
VALUES  ('Burrito', 20.50, 90),
        ('Nachos', 10.50, 100),
        ('Tacos', 15, 120),
        ('Quesadillas', 13, 80);
    