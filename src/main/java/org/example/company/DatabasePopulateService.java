package org.example.company;

import org.example.database.Database;

import static org.example.utils.ReaderFiles.readSqlFile;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String path = "./sql/populate_db.sql";
        String sql = readSqlFile(path);

        Database.getInstance().executeUpdate(sql);
    }
}