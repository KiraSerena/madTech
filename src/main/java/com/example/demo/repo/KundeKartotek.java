package com.example.demo.repo;

import com.example.demo.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class KundeKartotek {


    @Autowired
    JdbcTemplate jdbcTemplate;

    class KundeRowMapper implements RowMapper<Kunde> {
        @Override
        public Kunde mapRow(ResultSet rs, int rowNum) throws SQLException {
            Kunde kunde = new Kunde();

           // kunde.setKundeId(rs.getInt("kundeId"));
            kunde.setFornavn(rs.getString("fornavn"));
            kunde.setEfternavn(rs.getString("efternavn"));
            kunde.setEmail(rs.getString("email"));
            kunde.setTlfNr(rs.getInt("tlfnr"));
            kunde.setAdresse(rs.getString("adresse"));
            kunde.setZipcode(rs.getInt("zipcode"));
            kunde.setCity(rs.getNString("city"));
            kunde.setLand(rs.getString("land"));
         //   kunde.setOprettelsesDato(rs.getDate("oprettelsesDato"));

            return kunde;

        }

    }

    public List<Kunde> findAll() {
        return jdbcTemplate.query("select * from kunde", new KundeRowMapper());
    }
    public int insert(Kunde kunde) {
        return jdbcTemplate.update("insert into kunde (fornavn, efternavn, email, tlfNr, adresse, zipcode, city, land) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[] { kunde.getFornavn(), kunde.getEfternavn(), kunde.getEmail(), kunde.getTlfNr(),
                         kunde.getAdresse(), kunde.getZipcode(), kunde.getCity(), kunde.getLand() });
    }



    public Kunde findById(long id) {
        return jdbcTemplate.queryForObject("select * from kunde where kundeId=?", new Object[] { id },
                new BeanPropertyRowMapper<Kunde>(Kunde.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from kunde where kundeId=?", new Object[] { id });
    }


    public int update(Kunde kunde) {
        return jdbcTemplate.update("update kunde, fornavn = ?, efternavn = ?, email = ?,  tlfNr = ?, adresse = ?, zipcode = ?, city = ?, land = ?, where kundeId = ?",
                new Object[] { });
    }

}

