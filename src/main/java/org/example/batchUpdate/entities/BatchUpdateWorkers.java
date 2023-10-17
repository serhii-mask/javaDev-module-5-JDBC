package org.example.batchUpdate.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BatchUpdateWorkers {

    private static final String PREPARED_STATEMENT_INSERT = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
    private PreparedStatement insertStatement;

    public BatchUpdateWorkers(Connection connection) {
        try {
            this.insertStatement = connection.prepareStatement(PREPARED_STATEMENT_INSERT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveAllWorkers(List<Worker> workers) {
        try {
            for (Worker worker : workers) {
                this.insertStatement.setString(1, worker.getName());
                this.insertStatement.setDate(2, Date.valueOf(worker.getBirthday().toString()));
                this.insertStatement.setString(3, worker.getLevel());
                this.insertStatement.setInt(4, worker.getSalary());
                this.insertStatement.addBatch();
            }

            insertStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
