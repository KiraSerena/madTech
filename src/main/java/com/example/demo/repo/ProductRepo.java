package com.example.demo.repo;


import com.example.demo.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProductRepo {



  @Autowired
  JdbcTemplate jdbcTemplate;


      class ProductRowMapper implements RowMapper<Products> {

        @Override

        public Products mapRow (ResultSet rs, int rowNum) throws SQLException {
          Products products = new Products();
          products.setProduktId(rs.getInt("produktId"));
          products.setProduktNavn(rs.getString("produktNavn"));
          products.setProduktId(rs.getInt("produktId"));
          products.setLagerStatus(rs.getInt("lagerstatus"));
          products.setStartDato(rs.getDate("startDato"));




          return products;
        }
      }

}
