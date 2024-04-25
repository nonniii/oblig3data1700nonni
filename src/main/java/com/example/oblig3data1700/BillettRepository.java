package com.example.oblig3data1700;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    public void leggInn(Kinobilletter kinobillett) {
        String sql = "INSERT INTO Kinobilletter (film, antall, fornavn, etternavn, telefonnr, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, kinobillett.getFilm(), kinobillett.getAntall(), kinobillett.getFornavn(),
                kinobillett.getEtternavn(), kinobillett.getTelefonnr(), kinobillett.getEpost());
    }

    public List<Kinobilletter> hentAlle() {
        String sql = "SELECT id, film, antall, fornavn, etternavn, telefonnr, epost FROM Kinobilletter ORDER BY etternavn";
        return db.query(sql, new BeanPropertyRowMapper<>(Kinobilletter.class));
    }

    public void slettAlle() {
        String sql = "DELETE FROM Kinobilletter";
        db.update(sql);
    }
}
