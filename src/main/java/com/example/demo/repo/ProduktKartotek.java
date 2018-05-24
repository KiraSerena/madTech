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
public class ProduktKartotek {



  @Autowired
  JdbcTemplate jdbcTemplate;


      class ProdukterRowMapper implements RowMapper<Produkter> {

        @Override

        public Produkter mapRow (ResultSet rs, int rowNum) throws SQLException {
          Produkter produkter = new Produkter();
          produkter.setProduktId(rs.getInt("produktId"));
          produkter.setProduktNavn(rs.getString("produktNavn"));
          produkter.setLagerStatus(rs.getInt("lagerstatus"));
          produkter.setStartDato(rs.getDate("startDato"));
          produkter.setSlutDato(rs.getDate("slutDato"));
          produkter.setLeveringstid(rs.getString("leveringstid"));
          return produkter;
        }
      }


  public List<Produkter> findAll() {
    return jdbcTemplate.query("select * from produkter", new ProdukterRowMapper());
  }


  public int insert(Produkter produkter) {
    return jdbcTemplate.update("insert into produkter (produktNavn, lagerstatus, startDato, leveringstid) " + "values( ?, ?, ?, ?)",
            new Object[] { produkter.getProduktNavn(), produkter.getLagerStatus(), produkter.getStartDato() });
  }

  public int deleteById(long id) {
    return jdbcTemplate.update("delete from produkter where produktId=?", new Object[] { id });
  }


  public int update(Produkter produkter) {
    return jdbcTemplate.update("update produkter set produktNavn = ?, startDato = ?, slutDato = ?,  lagerStatus = ?, last_name = ? where produktId = ?",
            new Object[] { produkter.getProduktNavn(), produkter.getLagerStatus(), produkter.getStartDato(), produkter.getSlutDato(), produkter.getLeveringstid() });
  }

}
