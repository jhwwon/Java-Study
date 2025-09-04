// DataExportJob.java
package shop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataExportJob implements BatchJob {
    @Override
    public void execute() throws Exception {
        String sql =
            "SELECT id, name, price, quantity " +
            "FROM products " +
            "ORDER BY id DESC " +
            "FETCH FIRST 5 ROWS ONLY";   

        try (Connection c = DBUtil.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("[DataExport] 최근 5건 ▼");
            while (rs.next()) {
                System.out.printf("- #%d %s / %d원 / %d개%n",
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("quantity"));
            }
        }
    }
}
