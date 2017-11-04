package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDiriMapper implements RowMapper<DataDiri> {
    @Override
    public DataDiri mapRow(ResultSet resultSet, int i) throws SQLException {
        DataDiri dataDiri = new DataDiri();
        dataDiri.setId(resultSet.getInt("id"));
        dataDiri.setNama(resultSet.getString("nama"));
        dataDiri.setUmur(resultSet.getInt("umur"));
        return dataDiri;
    }
}
