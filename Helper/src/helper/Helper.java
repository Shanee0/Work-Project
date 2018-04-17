/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.SQLException;

/**
 *
 * @author Shane.Sutton
 */
public class Helper
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        SqlControler sql = new SqlControler();
        
        sql.Connection();
    }
    
}
