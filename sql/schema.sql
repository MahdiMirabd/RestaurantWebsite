CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    price NUMERIC (12, 2) NOT NULL,
    calories NUMERIC NOT NULL,
    allergies VARCHAR (50),
    ingredients VARCHAR(500) NOT NULL,
    FOREIGN KEY (allergies) REFERENCES allergies(name)
);

CREATE TABLE allergies (
    name VARCHAR (50) NOT NULL PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
);

INSERT INTO menu (name, price, calories, allergies, ingredients)
VALUES  ('Burrito', 20.50, 90, 'Milk', 'Burrito that contains beef shredded with nacho cheese and spicy rice'),
        ('Nachos', 10.50, 100, 'Milk', 'Nachos with nacho cheese over the top'),
        ('Tacos', 15, 120, 'Milk','Tacos containing beef shredded with cheese and tomato'),
        ('Quesadillas', 13, 80, 'Milk', 'Quesadillia containing cheese in a soft crunchy bread'),
        ('Burger', 10, 50, 'Milk', 'Burger containing cheese and a beef patty'),
        ('Chicken Wrap', 10, 30 'Milk', 'Chicken wrap containing shredded cheese and lettuce with tomato'),
        ('Beef Wrap', 10, 30, 'Milk', 'Beef Wrap containing shredded cheese and lettuce with tomato'),
        ('Fish Burger', 10, 25, 'Fish','Fish burger with nothing extra added'),
        ('Egg Breakfast', 10, 15, 'Egg','Simple egg breakfast'),
        ('Salsa', 5, 5, 'Gluten','Salsa dip containing tomato and fresh chilli peppers');
INSERT INTO allergies(name, description)
VALUES  ('Celery', "Contains Celery"),
        ('Gluten', "Contains Gluten"),
        ('Crustaceans', "Contains Shell Fish" ),
        ('Eggs', "Contains Eggs"),
        ('Fish', "Contains Fish"),
        ('Lupin', "Contains Lupin"),
        ('Milk', "Dairy Product"),
        ('Molluscs', "Contains Tropomyosin"),
        ('Mustard', "Contains Sin a 1 in Yellow Mustard, Bra j 1 in Brown Mustard"),
        ('Nuts', "Contains nuts"),
        ('Peanuts', "Contains peanuts"),
        ('Sesame Seeds', "Contains Sesame Seed"),
        ('Soya', "Contains Soy"),
        ('Sulphur Dioxide', "Contains Sulphur Dioxide");