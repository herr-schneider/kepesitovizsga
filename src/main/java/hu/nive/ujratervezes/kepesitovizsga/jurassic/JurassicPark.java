package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JurassicPark {
    private MariaDbDataSource dataSource;

    public JurassicPark(MariaDbDataSource source) {
        this.dataSource = source;
    }

    public List<String> checkOverpopulation() {
        List<String> results = new ArrayList<>();
        int exp;
        int act;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM dinosaur")) {
            process(results, stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        }
        Collections.sort(results);
        return results;
    }

    private void process(List<String> results, PreparedStatement stmt) throws SQLException {
        int exp;
        int act;
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                exp = rs.getInt("expected");
                act = rs.getInt("actual");
                if (exp < act) {
                    results.add(rs.getString("breed"));
                }
            }
        }
    }


}
