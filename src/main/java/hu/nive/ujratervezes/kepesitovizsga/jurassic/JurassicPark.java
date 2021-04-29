package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
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
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) //PreparedStatement stmt = conn.prepareStatement( "SELECT * FROM dinosaur"))
        {
            proccess(results, stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        }
        Collections.sort(results);
        return results;
    }

    private void proccess(List<String> results, Statement stmt) throws SQLException {
        int exp;
        int act;
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM dinosaur")) {
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
