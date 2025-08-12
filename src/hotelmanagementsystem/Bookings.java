
package hotelmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Bookings extends javax.swing.JFrame {

    public Bookings() {
        initComponents();
        GetRooms();
        GetCustomer();
        ShowBookings();
        CostTb.setEditable(false);
    }
Connection con= null;
PreparedStatement Pst = null;
ResultSet Rs= null, Rs1= null;
Statement St=null, St1=null;
private void GetRooms(){
      try {
        String s="Free";
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
        St= con.createStatement();
        Rs= St.executeQuery("select * from Room1b1 where RStatus='"+s+"'");
        while(Rs.next()){
           int R= Rs.getInt("RNum");
           RoomCb.addItem(String.valueOf(R));
        }
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, e);
      }
}

private void UpdateRoom(){
     
         
          try {
              String s="Booked";
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
            PreparedStatement save= con.prepareStatement("update Room1b1 set RStatus=? where RNum=?");
                  save.setInt(2, Integer.parseInt(RoomCb.getSelectedItem().toString()));
                  save.setString(1, s);                  
                  
                  save.executeUpdate();
           
            con.close();
           }catch(Exception e){
          JOptionPane.showMessageDialog(this, e);
      }   
}
private void UpdatetoFree(){
     
         
          try {
              String s="Free";
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
            PreparedStatement save= con.prepareStatement("update Room1b1 set RStatus=? where RNum=?");
            save.setInt(2, R);
            save.setString(1, s);                  
                  
            save.executeUpdate();
           }catch(Exception e){
          JOptionPane.showMessageDialog(this, e);
      }   
}
int RC;
      private void GetCost(){
 try {
        St1= con.createStatement();
        Rs1= St1.executeQuery("select * from Room1b1 where RNum = "+RoomCb.getSelectedItem().toString());
        Rs1.next();
        RC = Rs1.getInt(5);
        CostTb.setText(""+RC);
      
      }catch(Exception e){
         
      }
}
private void GetCustomer(){
      try {
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
        St= con.createStatement();
        Rs= St.executeQuery("select * from Customer");
        while(Rs.next()){
        String C= Rs.getString("CustNum");
           CustomerCb.addItem(String.valueOf(C));
        }
        
      }catch(Exception e){
          
      }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        CustBtn = new javax.swing.JLabel();
        RoomBtn = new javax.swing.JLabel();
        BookBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        HomeBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CostTb = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookingList = new javax.swing.JTable();
        FetchBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        RoomCb = new javax.swing.JComboBox<>();
        CustomerCb = new javax.swing.JComboBox<>();
        BookDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Duration1 = new javax.swing.JTextField();
        AddBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.pressedBackground"));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        CustBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustBtn.setForeground(new java.awt.Color(255, 255, 255));
        CustBtn.setText("Manage Customer");
        CustBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        CustBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustBtnMouseClicked(evt);
            }
        });

        RoomBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        RoomBtn.setText("Manage Rooms");
        RoomBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        RoomBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomBtnMouseClicked(evt);
            }
        });

        BookBtn.setBackground(new java.awt.Color(204, 204, 204));
        BookBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BookBtn.setForeground(new java.awt.Color(255, 255, 255));
        BookBtn.setText("Booking");
        BookBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BookBtn.setOpaque(true);

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Log out");
        logoutBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        HomeBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(255, 255, 255));
        HomeBtn.setText("Home");
        HomeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(BookBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 48, 217));
        jLabel1.setText("Free Room Id");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 48, 217));
        jLabel2.setText("Registered Customer Id");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 48, 217));
        jLabel3.setText("Cost");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 48, 217));
        jLabel4.setText("Duration in Days");

        BookingList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BookingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Room", "Customer", "Cost", "Duration in Days", "Date"
            }
        ));
        BookingList.setGridColor(new java.awt.Color(0, 0, 0));
        BookingList.setRowHeight(25);
        BookingList.setRowMargin(1);
        BookingList.setShowGrid(true);
        BookingList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookingListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookingList);

        FetchBtn.setBackground(new java.awt.Color(51, 0, 204));
        FetchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        FetchBtn.setForeground(new java.awt.Color(255, 255, 255));
        FetchBtn.setText("Fetch Total Cost");
        FetchBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        FetchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FetchBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(0, 0, 204));
        CancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        RoomCb.setEditable(true);
        RoomCb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RoomCbItemStateChanged(evt);
            }
        });

        CustomerCb.setEditable(true);
        CustomerCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerCbActionPerformed(evt);
            }
        });

        BookDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookDateActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 48, 217));
        jLabel5.setText("Date");

        AddBtn1.setBackground(new java.awt.Color(51, 0, 204));
        AddBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddBtn1.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn1.setText("Book");
        AddBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BookDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RoomCb, javax.swing.GroupLayout.Alignment.LEADING, 0, 220, Short.MAX_VALUE)
                            .addComponent(CustomerCb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CostTb, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Duration1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(FetchBtn)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(CancelBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RoomCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddBtn1)
                            .addComponent(Duration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CostTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(FetchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(BookDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void CustomerCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerCbActionPerformed
        
    }//GEN-LAST:event_CustomerCbActionPerformed

    private void RoomCbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RoomCbItemStateChanged
       GetCost();
    }//GEN-LAST:event_RoomCbItemStateChanged
 private void ShowBookings(){
    try{
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
        St= con.createStatement();
        Rs= St.executeQuery("select * from Bookingtbl");
        BookingList.setModel(DbUtils.resultSetToTableModel(Rs));
        
    } catch (SQLException e){
        
    }
    
}
 int Bid;
    private void CountBookings(){
       try{
           St= con.createStatement();
           Rs= St.executeQuery("select Max(RNum) from Bookingtbl");
           Rs.next();
           Bid= Rs.getInt(1)+1;
           
       }catch(SQLException e){
           System.out.println("count bookings");
                  
       }
   }
    private void FetchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FetchBtnActionPerformed
      if(Duration1.getText().isEmpty())
      {
          JOptionPane.showMessageDialog(this, "Please Enter Duration");
      }
      else {int TotAmt = RC * Integer.parseInt(Duration1.getText());
       CostTb.setText(""+TotAmt);
      }
    }//GEN-LAST:event_FetchBtnActionPerformed

    private void BookDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookDateActionPerformed

    }//GEN-LAST:event_BookDateActionPerformed

    private void AddBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtn1ActionPerformed
         if(RoomCb.getSelectedIndex() == -1 || CustomerCb.getSelectedIndex()==-1|| Duration1.getText().isEmpty() ||BookDate.getText().isEmpty() || CostTb.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Data!!!");}
        else{
            try {

           CountBookings();
        
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
            PreparedStatement save= con.prepareStatement("insert into Bookingtbl values(?,?,?,?,?,?)");
                  save.setInt(1, Bid);
                  save.setInt(2, Integer.parseInt(RoomCb.getSelectedItem().toString()));                  
                  save.setInt(3, Integer.parseInt(CustomerCb.getSelectedItem().toString()));                  
                  save.setInt(4, Integer.parseInt(Duration1.getText()));
                  save.setInt(5, Integer.parseInt(CostTb.getText()));
                  save.setString(6, BookDate.getText());

                  save.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Booked Successfully!");
            con.close();
            ShowBookings();
            UpdateRoom();
            RoomCb.removeAllItems();
            GetRooms();
            
             } catch (SQLException ex) {
              JOptionPane.showMessageDialog(this, ex); 
            }
        }
    }//GEN-LAST:event_AddBtn1ActionPerformed

    private void RoomBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomBtnMouseClicked
        try {
            new Rooms().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bookings.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.dispose();
    }//GEN-LAST:event_RoomBtnMouseClicked
int Key=0;
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
              if(Key == 0) 
       {
            JOptionPane.showMessageDialog(this, "Please select a Booking!!!");
        }
        else{
            try {
           
         
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
            PreparedStatement save= con.prepareStatement("delete from Bookingtbl where RNum =?");
                  save.setInt(1, Key);
                  save.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Deleted Successfully!");
            con.close();
            ShowBookings();
            UpdatetoFree();
            RoomCb.removeAllItems();
            GetRooms();
             } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, ex); 
            }
        }
    }//GEN-LAST:event_CancelBtnActionPerformed
int R;
    private void BookingListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingListMouseClicked
         DefaultTableModel model =(DefaultTableModel) BookingList.getModel();
        int MyIndex= BookingList.getSelectedRow();
        Key =Integer.parseInt(model.getValueAt(MyIndex, 0).toString());
        R = Integer.parseInt(model.getValueAt(MyIndex, 1).toString());
        RoomCb.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
        CustomerCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        
        Duration1.setText(model.getValueAt(MyIndex, 3).toString());
        CostTb.setText(model.getValueAt(MyIndex, 4).toString());
        BookDate.setText(model.getValueAt(MyIndex, 5).toString());
    }//GEN-LAST:event_BookingListMouseClicked

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked
        new Home().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void CustBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustBtnMouseClicked
        new Customers().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_CustBtnMouseClicked

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn1;
    private javax.swing.JLabel BookBtn;
    private javax.swing.JTextField BookDate;
    private javax.swing.JTable BookingList;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTextField CostTb;
    private javax.swing.JLabel CustBtn;
    private javax.swing.JComboBox<String> CustomerCb;
    private javax.swing.JTextField Duration1;
    private javax.swing.JButton FetchBtn;
    private javax.swing.JLabel HomeBtn;
    private javax.swing.JLabel RoomBtn;
    private javax.swing.JComboBox<String> RoomCb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutBtn;
    // End of variables declaration//GEN-END:variables
}
