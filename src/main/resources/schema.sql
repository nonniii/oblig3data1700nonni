CREATE TABLE Kinobilletter (
                               id INT AUTO_INCREMENT NOT NULL,
                               film VARCHAR(255) NOT NULL,
                               antall INT NOT NULL,
                               fornavn VARCHAR(255) NOT NULL,
                               etternavn VARCHAR(255) NOT NULL,
                               telefonnr VARCHAR(20) NOT NULL,
                               epost VARCHAR(255) NOT NULL,
                               PRIMARY KEY (id)
);
