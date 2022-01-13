package com.indra.actions;

import oracle.jdbc.datasource.impl.OracleDataSource;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ejecucionProcedimientosAlmancenados {
@Test
    public void DatabaseConnectionActivator() throws SQLException {

        OracleDataSource ods = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // Create DataSource and connect to the local database
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//10.69.60.89:1521/DEV11G");
        ods.setUser("ACTIVATOR");
        ods.setPassword("ACTIVATOR");
        conn = ods.getConnection();

        try
        {
            // Query the employee names
            CallableStatement cs3 = conn.prepareCall("SET serveroutput ON;BEGIN AL_RE_ACTIVADOR ('3046010569');END;");

        }

    //Close the result set, statement, and the connection
        finally{
           if(conn!=null) conn.close();
        }
}
    @Test
    public void DatabaseConnectionActivator2() throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:oracle:thin:@10.69.60.89:1521/DEV11G","ACTIVATOR","ACTIVATOR");
        con.close();
        System.out.println("program is exited");
    }

}