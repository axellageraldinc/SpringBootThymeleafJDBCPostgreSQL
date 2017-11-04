package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class DataDiriImpl implements DataDiriDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public DataDiriImpl(){
        jdbcTemplate.setDataSource(DataSourceConfig.dataSource());
    }

    @Override
    public void CreateTable() {
        String query = "CREATE TABLE IF NOT EXISTS data_diri" +
                "(id serial primary key, nama TEXT, umur INT)";
        jdbcTemplate.execute(query);
    }

    @Override
    public void InsertData(DataDiri dataDiri) {
        String query = "INSERT INTO data_diri (nama, umur) VALUES (?,?)";
        jdbcTemplate.update(query, new Object[] { dataDiri.getNama(), dataDiri.getUmur() });
    }

    @Override
    public List<DataDiri> GetAllData() {
        String query = "SELECT * FROM data_diri";
        List<DataDiri> dataDiriList = new ArrayList<>();
        dataDiriList = jdbcTemplate.query(query, new DataDiriMapper());
        return dataDiriList;
    }

    @Override
    public List<DataDiri> GetOneData(int id) {
        List<DataDiri> dataDiriList = new ArrayList<>();
        String query = "SELECT * FROM data_diri WHERE id=?";
        dataDiriList = jdbcTemplate.query(query, new Object[] {id}, new DataDiriMapper());
        return dataDiriList;
    }

    @Override
    public String GetNameById(int id) {
        String query = "SELECT nama FROM data_diri WHERE id=?";
        String nama;
        nama = jdbcTemplate.queryForObject(query, new Object[] {id}, String.class);
        return nama;
    }

    @Override
    public void Update(DataDiri dataDiri) {
        String query = "UPDATE data_diri SET nama=?, umur=? WHERE id=?";
        jdbcTemplate.update(query, new Object[] {dataDiri.getNama(), dataDiri.getUmur(), dataDiri.getId()});
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM data_diri WHERE id=?";
        jdbcTemplate.update(query, new Object[] {id});
    }
}
