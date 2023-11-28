import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class main extends javax.swing.JFrame {
  
    /**
     * Creates new form main
     */
    public main() {
   
      
        initComponents();
        Connect();
        LoadStudentNumber();
        Fetch();
        
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
   
    
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM student_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
               Vector v2 = new Vector();
               for(int a=1; a<=q; a++){
                   v2.add(rs.getString("id"));
                   v2.add(rs.getString("fname"));
                   v2.add(rs.getString("sid"));
                   v2.add(rs.getString("course"));
                   v2.add(rs.getString("section"));
                   v2.add(rs.getString("year"));
               }
               df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/CC104","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadStudentNumber(){
        try {
            pst = con.prepareStatement("SELECT id FROM student_tbl");
            rs = pst.executeQuery();
            txtsid.removeAllItems();
            while(rs.next()){
            txtsid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblupdate = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        txtsection = new javax.swing.JTextField();
        txtyear = new javax.swing.JTextField();
        txtsid = new javax.swing.JComboBox<>();
        lblsearch = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/button.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1810, 20, -1, -1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(246, 220, 174));
        jTable1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STUDENT NO.", "NAME", "STUDENT I.D", "COURSE", "SECTION", "YEAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 130, 1010, 930));

        lblupdate.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        lblupdate.setForeground(new java.awt.Color(255, 255, 255));
        lblupdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblupdate.setText("UPDATE");
        lblupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblupdateMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblupdateMousePressed(evt);
            }
        });
        jPanel1.add(lblupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 690, 220, 80));

        add.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("ADD");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 690, 220, 80));

        delete.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("DELETE");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 690, 220, 80));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FULL NAME:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 280, 70));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STUDENT ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("COURSE       :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SECTION      :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("YEAR           :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, -1, -1));

        txtfname.setBackground(new java.awt.Color(245, 154, 61));
        txtfname.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        txtfname.setForeground(new java.awt.Color(255, 255, 255));
        txtfname.setBorder(null);
        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 390, 60));

        txtid.setBackground(new java.awt.Color(245, 154, 61));
        txtid.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        txtid.setBorder(null);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 390, 60));

        txtcourse.setBackground(new java.awt.Color(245, 154, 61));
        txtcourse.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        txtcourse.setForeground(new java.awt.Color(255, 255, 255));
        txtcourse.setBorder(null);
        jPanel1.add(txtcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 390, 60));

        txtsection.setBackground(new java.awt.Color(245, 154, 61));
        txtsection.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        txtsection.setForeground(new java.awt.Color(255, 255, 255));
        txtsection.setBorder(null);
        txtsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsectionActionPerformed(evt);
            }
        });
        jPanel1.add(txtsection, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 390, 60));

        txtyear.setBackground(new java.awt.Color(245, 154, 61));
        txtyear.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        txtyear.setForeground(new java.awt.Color(255, 255, 255));
        txtyear.setBorder(null);
        txtyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearActionPerformed(evt);
            }
        });
        jPanel1.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 390, 60));

        txtsid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtsid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsidActionPerformed(evt);
            }
        });
        jPanel1.add(txtsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 840, 290, 60));

        lblsearch.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        lblsearch.setForeground(new java.awt.Color(255, 255, 255));
        lblsearch.setText("SEARCH");
        lblsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsearchMouseClicked(evt);
            }
        });
        jPanel1.add(lblsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 840, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG/mian.bg.jpg"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        try {
            String full_name = txtfname.getText();
            String student_id = txtid.getText();
            String course = txtcourse.getText();
            String section = txtsection.getText();
            String year = txtyear.getText();
            
            pst = con.prepareStatement("INSERT INTO student_tbl (fname,sid,course,section,year)VALUES(?,?,?,?,?)");
            pst.setString(1, full_name);
            pst.setString(2, student_id);
            pst.setString(3, course);
            pst.setString(4, section);
            pst.setString(5, year);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Student successfully added!");
                txtfname.setText("");
                txtid.setText("");
                txtcourse.setText("");
                txtsection.setText("");
                txtyear.setText(""); 
                Fetch();
                LoadStudentNumber();
            }else{
                JOptionPane.showMessageDialog(this, "Failed to add student, please try again!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_addMouseClicked

    private void lblupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateMouseClicked
       
        try {
            String fname = txtfname.getText();
            String id = txtid.getText();
            String section = txtsection.getText();
            String course = txtcourse.getText();
            String year = txtyear.getText();
            String sid = txtsid.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE student_tbl SET fname=?,sid=?,course=?,section=?,year=? WHERE id=?");
            
            pst.setString(1, fname);
            pst.setString(2, id);
            pst.setString(3, course);
            pst.setString(4, section);
            pst.setString(5, year);
            pst.setString(6, sid);
            
            int k=pst.executeUpdate();
            if(k==1){
                 JOptionPane.showMessageDialog(this, "Student updated!");
                
                txtfname.setText("");
                txtid.setText("");
                txtcourse.setText("");
                txtsection.setText("");
                txtyear.setText(""); 
                txtfname.requestFocus();
                Fetch();
                LoadStudentNumber();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_lblupdateMouseClicked

    private void lblupdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateMousePressed
       
    }//GEN-LAST:event_lblupdateMousePressed

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txtsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsectionActionPerformed

    private void txtyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtsidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsidActionPerformed

    private void lblsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsearchMouseClicked
        try {
            String sid = txtsid.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM student_tbl WHERE id=?");
            pst.setString(1,sid);
            rs = pst.executeQuery();
            
            if(rs.next()==true){
                txtfname.setText(rs.getString(2));
                txtid.setText(rs.getString(3));
                txtcourse.setText(rs.getString(4));
                txtsection.setText(rs.getString(5));
                txtyear.setText(rs.getString(6));
            }else{
                JOptionPane.showMessageDialog(this, "No student found!");
                txtfname.setText("");
                txtid.setText("");
                txtcourse.setText("");
                txtsection.setText("");
                txtyear.setText(""); 
                txtfname.requestFocus();
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblsearchMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        try {
            String sid = txtsid.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM student_tbl WHERE id=?");
            pst.setString(1, sid);
            
            int k = pst.executeUpdate();
            if (k==1){
                JOptionPane.showMessageDialog(this, "Student record sucessfully deleted!");
                txtfname.setText("");
                txtid.setText("");
                txtcourse.setText("");
                txtsection.setText("");
                txtyear.setText(""); 
                txtfname.requestFocus();
                Fetch();
                LoadStudentNumber();
            }else{
            JOptionPane.showMessageDialog(this, "Student record failed to delete!");
           }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblsearch;
    private javax.swing.JLabel lblupdate;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtsection;
    private javax.swing.JComboBox<String> txtsid;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
