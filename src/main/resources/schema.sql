CREATE TABLE IF NOT EXISTS author (id SERIAL PRIMARY KEY, lastname VARCHAR(255), firstname VARCHAR(255));
CREATE TABLE IF NOT EXISTS book (id SERIAL PRIMARY KEY, title VARCHAR(100), isbn VARCHAR(255), description VARCHAR(255), page int, price double precision);


-- ALTER TABLE book ADD CONSTRAINT book_title_unq UNIQUE (title);

