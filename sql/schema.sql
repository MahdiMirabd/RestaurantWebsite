DROP TABLE IF EXISTS menu CASCADE;

CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    price NUMERIC (12, 2) NOT NULL,
    calories NUMERIC NOT NULL,
    ingredients VARCHAR(100) NOT NULL,
    allergen TEXT[] NOT NULL,
    image VARCHAR (150) NOT NULL,
    available BOOLEAN NOT NULL
);

INSERT INTO menu (name, price, calories, ingredients, allergen, image, available )
VALUES  ('Burrito', 20.50, 90, 'beef, cheese and spicy rice, beans', ARRAY ['Gluten','Milk', 'Celery', 'soy'], '/img/burrito.jpg', TRUE),
        ('Nacho', 10.50, 100, 'cheese, tomato, guacamole, sour cream', ARRAY ['Gluten','Eggs','Milk'], '/img/nacho.jpg', TRUE),
        ('Taco', 15, 120, 'beef, cheese, tomato', ARRAY ['Gluten', 'soy','Milk'], '/img/taco.jpg', TRUE),
        ('Quesadilla', 13, 80, 'chicken, cheese', ARRAY ['Gluten','Mustard','Milk'], '/img/quesadilla.jpg', TRUE),
        ('Fajita', 14, 80, 'chicken, cheese, salad, sour cream', ARRAY ['Gluten','Mustard','Milk'], '/img/fajita.jpg', TRUE),
        ('Enchilada', 12, 80, 'beef, cheese, salad', ARRAY ['Gluten','Soy','Milk'], '/img/enchiladas.jpg', TRUE);
