drop table if exists follower, house, region, employee, position, postoffice, subscription, release, publication, publishinghouse, follower_subscription CASCADE;



CREATE TABLE postoffice (
                            id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                            name VARCHAR(25) NOT NULL,
                            addres VARCHAR(50) NOT NULL
);

CREATE TABLE publishinghouse (
                                 id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                 name VARCHAR(25) NOT NULL,
                                 addres VARCHAR(25) NOT NULL UNIQUE
);

CREATE TABLE publication (
                             id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                             name VARCHAR(25) NOT NULL,
                             publiching_house_id INT NOT NULL UNIQUE,
                             CONSTRAINT fk_publiching_house_id FOREIGN KEY (publiching_house_id) REFERENCES publishinghouse (id)
);

CREATE TABLE release (
                         id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         price INT NOT NULL,
                         count INT NOT NULL,
                         publication_id INT NOT NULL UNIQUE,
                         post_office_id INT NOT NULL UNIQUE,
                         CONSTRAINT fk_publication_id FOREIGN KEY (publication_id) REFERENCES publication (id),
                         CONSTRAINT fk_post_office_id FOREIGN KEY (post_office_id) REFERENCES postoffice (id)
);



CREATE TABLE position (
                          id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          name VARCHAR(25) NOT NULL,
                          salary INT NOT NULL
);

CREATE TABLE employee (
                          id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          first_name VARCHAR(25) NOT NULL,
                          last_name VARCHAR(25) NOT NULL,
                          middle_name VARCHAR(25) NOT NULL,
                          email VARCHAR(25) NOT NULL,
                          phone VARCHAR(25) NOT NULL,
                          position_id INT NOT NULL UNIQUE,
                          post_office_id INT NOT NULL UNIQUE,
                          CONSTRAINT fk_position_id FOREIGN KEY (position_id) REFERENCES position (id),
                          CONSTRAINT fk_post_office_id FOREIGN KEY (post_office_id) REFERENCES postoffice (id)
);

CREATE TABLE region (
                        id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        index INT NOT NULL,
                        post_office_id INT NOT NULL UNIQUE,
                        postman_id INT NOT NULL UNIQUE,
                        CONSTRAINT fk_post_office_id FOREIGN KEY (post_office_id) REFERENCES postoffice (id),
                        CONSTRAINT fk_postman_id FOREIGN KEY (postman_id) REFERENCES employee (id)
);

CREATE TABLE house (
                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       addres VARCHAR(50) NOT NULL,
                       region_id INT NOT NULL UNIQUE,
                       CONSTRAINT fk_region_id FOREIGN KEY (region_id) REFERENCES region (id)
);

CREATE TABLE follower (
                          id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          first_name VARCHAR(25) NOT NULL,
                          last_name VARCHAR(25) NOT NULL,
                          middle_name VARCHAR(25) NOT NULL,
                          email VARCHAR(25) NOT NULL,
                          phone VARCHAR(25) NOT NULL,
                          house_id INT NOT NULL UNIQUE,
                          CONSTRAINT fk_house_id FOREIGN KEY (house_id) REFERENCES house (id)
);

CREATE TABLE subscription (
                              id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                              start_date DATE NOT NULL,
                              description VARCHAR(100) NOT NULL,
                              term INT NOT NULL,
                              end_date DATE NOT NULL,
                              release_id INT NOT NULL UNIQUE,
                              CONSTRAINT fk_release_id FOREIGN KEY (release_id) REFERENCES release (id)
);



CREATE TABLE follower_subscription (
                                       id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                       follower_id INT NOT NULL UNIQUE,
                                       subscription_id INT NOT NULL UNIQUE,
                                       CONSTRAINT fk_follower_id FOREIGN KEY (follower_id) REFERENCES follower (id),
                                       CONSTRAINT fk_subscription_id FOREIGN KEY (subscription_id) REFERENCES subscription (id)
);