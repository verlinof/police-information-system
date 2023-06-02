import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class outputSortingForm extends JFrame{
    private JComboBox CbCariKasus;
    private JButton BtnSearch;
    private JTable dataTable;
    private JScrollPane JsDataTable;
    private JPanel outputSortingPanel;
    private JButton BtnKembali;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;
    private Statement stmt;

    public outputSortingForm(){
        connect();
        table_load();
        JFrame frame = new JFrame("Halaman Sorting");
        frame.setContentPane(outputSortingPanel);
        frame.setSize(750,500);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setVisible(true);

        BtnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKasus = CbCariKasus.getSelectedItem().toString();
                if(jenisKasus.equalsIgnoreCase("Semua Kasus")){
                    sortingTableLoadAll(jenisKasus);
                }
                else{
                    sortingTableLoad(jenisKasus);
                }
            }
        });
        BtnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainPage(null);
            }
        });
    }

    //method untuk sortingan beberapa kasus saja atau semuanya
    public void sortingTableLoadAll(String jenisKasus){
        try {
            pst = conn.prepareStatement("select * from kasus");
            rs = pst.executeQuery();
            dataTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //buat ngeload full kasus
    public void sortingTableLoad(String jenisKasus){
        try {
            pst = conn.prepareStatement("select * from kasus where jenis_kasus = ?");
            pst.setString(1,jenisKasus);
            rs = pst.executeQuery();
            dataTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Buat ngeload table
    public void table_load(){
        try {
            pst = conn.prepareStatement("select * from kasus");
            rs = pst.executeQuery();
            dataTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //buat connect ke database
    public void connect(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projek_akhir","root","");
            stmt = conn.createStatement();
            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
