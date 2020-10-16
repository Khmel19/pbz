package com.khmel.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class Table extends JTable {

    public Table() {
    }

    public Table(ResultSet rs) {

        try {
            ResultSetMetaData rsmd = rs.getMetaData();

            DefaultTableModel dtm = new DefaultTableModel();
            dtm.fireTableDataChanged();
            for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                dtm.addColumn(rsmd.getColumnName(i));
            }

            while(rs.next() == true) {
                //Object array[] = new Object[rsmd.getColumnCount()];
                Vector<Object> v = new Vector<Object>();
                for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                    //array[i - 1] = rs.getString(i);
                    v.add(rs.getString(i));
                    System.out.println(rs.getString(i));
                }
                //dtm.addRow(array);
                dtm.addRow(v);
            }
//AUTO_RESIZE_ALL_COLUMNS
            setModel(dtm);
            setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
//    @Override
//    public Object getValueAt(int row, int column) {
//        return super.getValueAt(row, column);
//    }

}
