package com.example.demo.repo;

import com.example.demo.model.ProduktSpec;
import com.example.demo.model.Produkter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ProduktSpecKartotek {



        @Autowired
        JdbcTemplate jdbcTemplate;

        class ProductSpecRowMapper implements RowMapper<ProduktSpec> {
            @Override
            public ProduktSpec mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProduktSpec produktSpec = new ProduktSpec();
                produktSpec.setStørelse(rs.getString("størelse"));
                produktSpec.setVægt(rs.getInt("vægt"));
                produktSpec.setPris(rs.getInt("pris"));
                produktSpec.setMateriale(rs.getString("materiale"));
                produktSpec.setFarve(rs.getString("farve"));
               return produktSpec;
            }

        }


    public List<ProduktSpec> findAll() {
        return jdbcTemplate.query("select * from produktSpecifikationer", new ProduktSpecKartotek.ProductSpecRowMapper());
    }


    public int insert(ProduktSpec produktSpec) {
        return jdbcTemplate.update("insert into produktSpecifikationer (størelse, vægt, pris, materiale, farve) " + "values( ?, ?, ?, ?, ?)",
                new Object[] { produktSpec.getStørelse(), produktSpec.getVægt(), produktSpec.getPris(), produktSpec.getMateriale(), produktSpec.getFarve() });
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from produktSpecifikationer where produkterproduktId=?", new Object[] { id });
    }


    public int update(ProduktSpec produktSpec) {
        return jdbcTemplate.update("update produktSpecifikationer set størelse = ?, vægt = ?, pris = ?,  materiale = ?, farve = ? where produkterproduktId= ?",
                new Object[] { produktSpec.getStørelse(), produktSpec.getVægt(), produktSpec.getPris(), produktSpec.getMateriale(), produktSpec.getFarve()  });
    }


}
