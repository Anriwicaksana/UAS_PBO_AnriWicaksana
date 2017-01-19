/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.modelbarang;
import util.koneksi;

/**
 *
 * @author Anri
 */
public class controllerBarang {
    koneksi koneksi = new koneksi();
    public void simpandata(modelbarang mp){
        koneksi.koneksidatabase();
        String query = " insert into tbl_barang(nama,jumlah,jenis) values ('"+mp.getNamabarang()+"','"+mp.getJumlahbarang()+"','"+mp.getJenisbarang()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Berhasil Kesimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Tidak Berhasil Kesimpan ");
            System.err.println(""+e);
        }
    }
    public void hapusdata(modelbarang mp){
        try {
            koneksi.koneksidatabase();
            String sql="insert into tbl_barang where id=('"+mp.getId()+"')";
            koneksi.state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "");
        } catch (SQLException ex) {
            System.err.println("error"+ex);
            JOptionPane.showMessageDialog(null,"data tidak terhapus");
            
        }
    }
        public void ubahdata(modelbarang mp){
            koneksi.koneksidatabase();
            try {
                int id =mp.getId();
                String nama =mp.getNamabarang();
                String  jenis =mp.getJenisbarang();
                int jumlah =mp.getJumlahbarang();
                String query ="update tbl_barang set nama=('" +nama +"'),jenis=('"+jenis+"'),jumlah=('"+jumlah+"') where id=('"+id+"')";
                koneksi.state.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil Terupdate");
                        
            } catch (SQLException e) {
                System.err.println("Eror"+e);
                JOptionPane.showMessageDialog(null,"Data Tidak Terubah");
            }
        }
}
