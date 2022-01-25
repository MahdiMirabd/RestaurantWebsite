DROP TABLE IF EXISTS menu, allergen, menu_allergen CASCADE;

CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    price NUMERIC (12, 2) NOT NULL,
    calories NUMERIC NOT NULL,
    ingredients VARCHAR(100) NOT NULL
);

CREATE TABLE allergen (
    name VARCHAR (50) NOT NULL PRIMARY KEY,
    description VARCHAR(100) NOT NULL
);

CREATE TABLE menu_allergen (
    menu_id INT  REFERENCES menu(id),
    allergen_id VARCHAR (50) REFERENCES allergen(name)
);

INSERT INTO menu (name, price, calories, ingredients)
VALUES  ('Burrito', 20.50, 90, 'Burrito that contains beef shredded with nacho cheese and spicy rice'),
        ('Nachos', 10.50, 100, 'Nachos with nacho cheese over the top'),
        ('Tacos', 15, 120, 'Tacos containing beef shredded with cheese and tomato'),
        ('Quesadillas', 13, 80, 'Quesadillas containing cheese in a soft crunchy bread');
        /*('Burger', 10, 50, 'Milk', 'Burger containing cheese and a beef patty'),
        ('Chicken Wrap', 10, 30 'Milk', 'Chicken wrap containing shredded cheese and lettuce with tomato'),
        ('Beef Wrap', 10, 30, 'Milk', 'Beef Wrap containing shredded cheese and lettuce with tomato'),
        ('Fish Burger', 10, 25, 'Fish','Fish burger with nothing extra added'),
        ('Egg Breakfast', 10, 15, 'Egg','Simple egg breakfast'),
        ('Salsa', 5, 5, 'Gluten','Salsa dip containing tomato and fresh chilli peppers');*/

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

INSERT INTO menu_allergen (menu_id, allergen_id)
VALUES ('1', 'Gluten'),
       ('1', 'Milk'),
       ('2', 'Eggs'),
       ('3', 'Sulphites'),
       ('4', 'Mustard');
