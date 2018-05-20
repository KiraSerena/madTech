package com.example.demo.repo;

import com.example.demo.model.ProductSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class ProductSpecRepo {



        @Autowired
        JdbcTemplate jdbcTemplate;

        class ProductSpecRowMapper implements RowMapper<ProductSpec> {
            @Override
            public ProductSpec mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProductSpec productSpec = new ProductSpec();
                productSpec.setStørelse(rs.getString("størelse"));
                productSpec.setVægt(rs.getInt("vægt"));
                productSpec.setPris(rs.getInt("pris"));
                productSpec.setMateriale(rs.getString("materiale"));
                productSpec.setFarve(rs.getString("farve"));
               return productSpec;
            }

        }
}
