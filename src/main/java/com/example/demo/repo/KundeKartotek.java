package com.example.demo.repo;

import com.example.demo.model.Kunde;
import com.example.demo.model.Produkter;
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


            kunde.setUsername(rs.getString("username"));
            kunde.setPassword(rs.getString("password"));
            kunde.setKundeid(rs.getInt("kundeid"));
            kunde.setFornavn(rs.getString("fornavn"));
            kunde.setEfternavn(rs.getString("efternavn"));
            kunde.setRoles(rs.getString("roles"));
            kunde.setEmail(rs.getString("email"));
            kunde.setTlfNr(rs.getInt("tlfnr"));
            kunde.setAdresse(rs.getString("adresse"));
            kunde.setZipKode(rs.getInt("zipKode"));
            kunde.setCity(rs.getNString("city"));
            kunde.setLand(rs.getString("land"));
            kunde.setOprettelsesDato(rs.getDate("oprettelsesDato"));

            return kunde;
        }

    }

    public List<Kunde> findAll() {
        return jdbcTemplate.query("select * from kunde", new KundeRowMapper());
    }
    public int insert(Kunde kunde) {
        return jdbcTemplate.update("insert into kunde (username, password, fornavn, , efternavn, email, tlfNr, oprettelsesDato, adresse, zipKode, city, land) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[] { kunde.getUsername(), kunde.getPassword(), kunde.getFornavn(), kunde.getEfternavn(), kunde.getEmail(), kunde.getTlfNr(),
                        kunde.getOprettelsesDato(), kunde.getAdresse(), kunde.getZipKode(), kunde.getCity(), kunde.getLand() });
    }



    public Kunde findById(long id) {
        return jdbcTemplate.queryForObject("select * from kunde where kundeId=?", new Object[] { id },
                new BeanPropertyRowMapper<Kunde>(Kunde.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from kunde where kundeId=?", new Object[] { id });
    }


    public int update(Kunde kunde) {
        return jdbcTemplate.update("update kunde set username = ?, password = ?, fornavn = ?, efternavn = ?, slutDato = ?,  lagerStatus = ?, last_name = ? where kundeId = ?",
                new Object[] { });
    }

}

