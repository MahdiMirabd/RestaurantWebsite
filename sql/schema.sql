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