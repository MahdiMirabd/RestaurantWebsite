DROP TABLE IF EXISTS menu, allergen CASCADE;

CREATE TABLE allergen (
    name VARCHAR (50) NOT NULL PRIMARY KEY,
    description VARCHAR(100) NOT NULL
);

CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    price NUMERIC (12, 2) NOT NULL,
    calories NUMERIC NOT NULL,
    ingredients VARCHAR(100) NOT NULL,
    allergen TEXT [] NOT NULL,
    image VARCHAR (150) NOT NULL,
    available BOOLEAN NOT NULL
);
INSERT INTO menu (name, price, calories, ingredients, allergen, image, available )
VALUES  ('Burrito', 20.50, 90, 'beef, cheese and spicy rice', ARRAY ['Milk', 'Celery'], '/img/burrito.jpg', TRUE),
        ('Nachos', 10.50, 100, 'cheese, tomato', ARRAY ['Eggs'], '/img/nacho.jpg', TRUE),
        ('Tacos', 15, 120, 'beef, cheese, tomato', ARRAY ['Gluten'], '/img/taco.jpg', TRUE),
        ('Quesadillas', 13, 80, 'cheese', ARRAY ['Mustard'], '/img/quesadilla.jpg', TRUE);

INSERT INTO allergen(name, description)
VALUES  ('Celery', 'Contains Celery'),
        ('Gluten', 'Contains Gluten'),
        ('Crustaceans', 'Contains Shell Fish' ),
        ('Eggs', 'Contains Eggs'),
        ('Fish', 'Contains Fish'),
        ('Lupin', 'Contains Lupin'),
        ('Milk', 'Dairy Product'),
        ('Molluscs', 'Contains Troponin'),
        ('Mustard', 'Contains Sin a 1 in Yellow Mustard, Bra j 1 in Brown Mustard'),
        ('Nuts', 'Contains nuts'),
        ('Peanuts', 'Contains peanuts'),
        ('Sesame Seeds', 'Contains Sesame Seed'),
        ('Soya', 'Contains Soy'),
        ('Sulphites', 'Contains Sulphur Dioxide');


