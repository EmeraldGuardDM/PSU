CREATE TABLE follower (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       first_name VARCHAR(25) NOT NULL,
                       last_name VARCHAR(25) NOT NULL,
					   middle_name VARCHAR(25) NOT NULL,
					   email VARCHAR(25) NOT NULL,
					   phone VARCHAR(25) NOT NULL,
                       house_id INT NOT NULL UNIQUE
);

CREATE TABLE house (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       addres VARCHAR(50) NOT NULL,
                       region_id INT NOT NULL UNIQUE
);

CREATE TABLE region (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       index INT NOT NULL,
                       post_office_id INT NOT NULL UNIQUE,
					   postman_id INT NOT NULL UNIQUE
);

CREATE TABLE employee (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       first_name VARCHAR(25) NOT NULL,
                       last_name VARCHAR(25) NOT NULL,
					   middle_name VARCHAR(25) NOT NULL,
					   email VARCHAR(25) NOT NULL,
					   phone VARCHAR(25) NOT NULL,
                       position_id INT NOT NULL UNIQUE,
					   post_office_id INT NOT NULL UNIQUE
);

CREATE TABLE position (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       name VARCHAR(25) NOT NULL,
                       salary INT NOT NULL 
);

CREATE TABLE postoffice (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
					   name VARCHAR(25) NOT NULL,
                       addres VARCHAR(50) NOT NULL
);

CREATE TABLE subscription (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       start_date DATE NOT NULL,
                       description VARCHAR(100) NOT NULL,					   
                       term INT NOT NULL,
					   end_date DATE NOT NULL,
					   release_id INT NOT NULL UNIQUE
);

CREATE TABLE release (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       price INT NOT NULL,
                       count INT NOT NULL,
					   publication_id INT NOT NULL UNIQUE,
					   post_office_id INT NOT NULL UNIQUE
);

CREATE TABLE publication (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       name VARCHAR(25) NOT NULL,
					   publiching_house_id INT NOT NULL UNIQUE
);

CREATE TABLE publishinghouse (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       name VARCHAR(25) NOT NULL,
					   addres VARCHAR(25) NOT NULL UNIQUE
);