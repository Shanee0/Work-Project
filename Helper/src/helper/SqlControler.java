/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Shane.Sutton
 */

public class SqlControler
{

    Connection con;
    Statement st;
    ResultSet rs;

    
    public Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:sqlserver://ACCESS-1GDBKY1\\SQL2012;" + "databaseName = master; user = sa;password = SA2;");
        return con;
    }
    
    
    
    public ResultSet Connection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(
                "jdbc:sqlserver://ACCESS-1GDBKY1\\SQL2012;" + "databaseName = master; user = sa;password = SA2;");
        //con = DriverManager.getConnection("jdbc:sqlserver://;ACCESS-1GDBKY1\\SQL2012;\\instance1;integratedSecurity=true");
        st = con.createStatement();
        rs = st.executeQuery("SELECT name FROM master.dbo.sysdatabases");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next())
        {

            for (int i = 1; i <= columnsNumber; i++)
            {
                if (i > 0)
                {
                    System.out.print(",  ");
                }
                String columnValue = rs.getString("name");
                System.out.print(columnValue);
                return rs;
                
            }

        }
        return rs;
    }
    
    public void validateLogin(String password) throws SQLException, NoSuchAlgorithmException{
        boolean loginSuccessful;
        Connection con = getConnection();
        
        
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < byteData.length; i ++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(
                            1));
            
        }
        
        System.out.println("Hex format : " + sb.toString());
       
        
    }
    
    
    
    
    
    
    
    
    
    

}
