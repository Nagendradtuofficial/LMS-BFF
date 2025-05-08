CREATE TABLE IF NOT EXISTS books (
    book_id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    title VARCHAR(255),
    quantity INT
);

CREATE TABLE IF NOT EXISTS users (
   user_id SERIAL PRIMARY KEY,
   mobile_number VARCHAR(15),
   name VARCHAR(255) NOT NULL,
   access_level VARCHAR(50) NOT NULL,
   rented_books_list INTEGER[]  -- This stores a list of integers (Book IDs)
);
