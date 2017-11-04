package com.example.demo;

import java.util.List;

public interface DataDiriDao {
    void CreateTable();
    void InsertData(DataDiri dataDiri);
    List<DataDiri> GetAllData();
    List<DataDiri> GetOneData(int id);
    String GetNameById(int id);
    void Update(DataDiri dataDiri);
    void Delete(int id);
}
