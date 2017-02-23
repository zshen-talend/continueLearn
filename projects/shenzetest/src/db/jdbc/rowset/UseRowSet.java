package db.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class UseRowSet {

    public void useRowSet() throws SQLException {
        RowSetFactory rsFactory = RowSetProvider.newFactory();
        try (JdbcRowSet jrs = rsFactory.createJdbcRowSet()) {
            jrs.setUrl("jdbc:mysql://192.168.33.211:3306/tbi");
            jrs.setUsername("shenze");
            jrs.setPassword("shenze");
            jrs.setCommand("SELECT * FROM generatdata1");
            jrs.setReadOnly(false);
            jrs.execute();
            jrs.absolute(1);
            jrs.updateString("a1", "" + (Integer.valueOf(jrs.getString("a1")) + 1));
            jrs.updateRow();
        }
    }

    public static void main(String[] args) {
        UseRowSet urs = new UseRowSet();
        try {
            urs.useRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
