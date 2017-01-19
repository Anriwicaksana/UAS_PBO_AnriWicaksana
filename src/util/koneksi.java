/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Anri
 */
public class koneksi {
    public Connection connect ;
    public Statement state;
    public ResultSet res;
    String namadatabase="jdbc:mysql://localhost:3306/db_uas_15311150";
    public koneksi koneksi;
    public void koneksidatabase(){
        try {
            connect = DriverManager.getConnection(namadatabase,"root","12345678");
            System.out.println("Koneksi Tidak bermasalah");
            state = connect.createStatement();
        } catch (Exception e) {
            System.err.println("Cek url, username host dan password host");
            System.err.println("" + e);
        }
    }
}
