package employee;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * <p>
 * EmployeeReg.
 * 
 * Creates an employee registration form along with their name & salary.
 * </p>
 *
 * @author Benedict Halim
 * @version 1.0
 */
public class EmployeeReg extends javax.swing.JFrame {
    /**
     * Connection to the table.
     */
    Connection con;
    /**
     * Prepared SQL statement.
     */
    PreparedStatement pst;

    /**
     * Constructs a new Employee registration form.
     */
    public EmployeeReg() {
        initComponents();
        AutoID();
        tableUpdate();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtsalary = new javax.swing.JTextField();
        txtid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form");

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee Registration");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employee Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Salary");

        txtname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtsalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 153));
        txtid.setText("EmpID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname)
                    .addComponent(txtsalary, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 287, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtid))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(470, 470, 470))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(clearButton))
                .addContainerGap(22, Short.MAX_VALUE))
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
    /**
    * Adds new entry to the table.
    */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            // Store the inputed text values into the variables
            String id = txtid.getText();
            String empname = txtname.getText();
            String salary = txtsalary.getText();
            // Returns the Class object associated with the given string name
            Class.forName("com.mysql.jdbc.Driver");
            // Manage the establishment of connections
            con = DriverManager.getConnection("jdbc:mysql://localhost/emppay","root","");
            // Create a new row with the incremented ID, inputed name, and inputed salary
            pst = con.prepareStatement("insert into employee(id,empname,salary)values(?,?,?)");
            
            // Set the columns to the variables inputed
            pst.setString(1, id);
            pst.setString(2, empname);
            pst.setString(3, salary);
            
            // Update the table
            pst.executeUpdate();
            
            // Show addition successful message
            JOptionPane.showMessageDialog(this, "Employee Added");
            
            // Update the table with new additions
            tableUpdate();
            
            // Reset the text fields
            txtname.setText("");
            txtsalary.setText("");
            
            // Focus onto the name field
            txtname.requestFocus();
            
            // Increment the ID
            AutoID();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
    * Selects a row in the table.
    */
    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        // Get the table model
        DefaultTableModel d1 = (DefaultTableModel) employeeTable.getModel();
        // Gets the index of the selected row
        int selectIndex = employeeTable.getSelectedRow();
        
        // Sets the input text fields to the values specified
        txtid.setText(d1.getValueAt(selectIndex, 0).toString());
        txtname.setText(d1.getValueAt(selectIndex, 1).toString());
        txtsalary.setText(d1.getValueAt(selectIndex, 2).toString());
        
        // Disable save button
        saveButton.setEnabled(false);
    }//GEN-LAST:event_employeeTableMouseClicked

    /**
    * Updates the selected table row.
    */
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            // Store the inputed text values into the variables
            String id = txtid.getText();
            String empname = txtname.getText();
            String salary = txtsalary.getText();
            // Returns the Class object associated with the given string name
            Class.forName("com.mysql.jdbc.Driver");
            // Manage the establishment of connections
            con = DriverManager.getConnection("jdbc:mysql://localhost/emppay","root","");
            // Update the employee's name & salary where the ID is what's selected
            pst = con.prepareStatement("update employee set empname = ?, salary = ? where id = ?");
            
            // Set the columns to the inputed variables
            pst.setString(1, empname);
            pst.setString(2, salary);
            pst.setString(3, id);
            
            // Update the table
            pst.executeUpdate();
            
            // Show update successful message
            JOptionPane.showMessageDialog(this, "Employee Updated");
            
            // Update the table
            tableUpdate();
            
            // Set save button to be enabled after updating records
            saveButton.setEnabled(true);
            
            // Reset the text fields
            txtname.setText("");
            txtsalary.setText("");
            
            // Focus cursor onto the name field
            txtname.requestFocus();
            
            // Increment the ID
            AutoID();
            

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    
    /**
    * Deletes the selected row.
    */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            // Store the inputed text values into the variables
            String id = txtid.getText();
            
            // Returns the Class object associated with the given string name
            Class.forName("com.mysql.jdbc.Driver");
            // Manage the establishment of connections
            con = DriverManager.getConnection("jdbc:mysql://localhost/emppay","root","");
            // Delete from the employee table where the ID is what's selected
            pst = con.prepareStatement("delete from employee where id = ?");
            
            // Set the columns to the inputed variables
            pst.setString(1, id);
            
            // Update the table
            pst.executeUpdate();
            
            // Show deletion successful message
            JOptionPane.showMessageDialog(this, "Employee Deleted");
            
            // Update the table with new additions
            tableUpdate();
            
            // Set save button to be enabled after updating records
            saveButton.setEnabled(true);
            
            // Reset the text fields
            txtname.setText("");
            txtsalary.setText("");
            
            // Focus onto the name field
            txtname.requestFocus();
            
            // Increment the ID
            AutoID();
            

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    /**
    * Clears the input fields.
    */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
            // Set Save button to be able to be selected after updating records
            saveButton.setEnabled(true);
            
            // Reset the text fields
            txtname.setText("");
            txtsalary.setText("");
            
            // Focus onto the name field
            txtname.requestFocus();
            
            // Increment the ID
            AutoID();
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
    * Generates an incremented ID.
    */
    public void AutoID() {
        try {
            // Returns the Class object associated with the class or interface with the given string name.
            Class.forName("com.mysql.jdbc.Driver");
            // Manage the establishment of connections.
            con = DriverManager.getConnection("jdbc:mysql://localhost/emppay","root","");
            // Make a SQL statement.
            Statement s = con.createStatement();
            // Get the ID with the maximum value.
            ResultSet rs = s.executeQuery("select MAX(id) from employee");
            // Moves the pointer to the next row.
            rs.next();
            
            // Base case.
            if(rs.getString("MAX(id)") == null){
                txtid.setText("ES001");
            // Otherwise, increment and set the text to that.
            } else {
                // Get the last 3 digits, set as long into id variable.
                long id = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
                // Increment it.
                id++;
                // Sets the text to the incremented value.
                txtid.setText("ES" + String.format("%03d", id));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Updates the table display.
    */
    public void tableUpdate(){
        int c;
        try {
            // Returns the Class object associated with the class or interface with the given string name
            Class.forName("com.mysql.jdbc.Driver");
            // Manage the establishment of connections
            con = DriverManager.getConnection("jdbc:mysql://localhost/emppay","root","");
            // Select all from employee table
            pst = con.prepareStatement("select * from employee");
            // Gets the Java object that contains the results of executing an SQL query
            ResultSet rs = pst.executeQuery();
            // Gets the data of the ResultSet object
            ResultSetMetaData rm = rs.getMetaData();
            // Gets the column count
            
            // Casts the model as a Default Table Model object
            DefaultTableModel dft = (DefaultTableModel) employeeTable.getModel();
            // Set your row count to 0
            dft.setRowCount(0);
            // As long as the ResultSet has a next value
            while(rs.next()){
                // Implement an array of objects
                Vector v = new Vector();
                
                // Adds the 3 inputs to the vector array
                    v.add(rs.getString("id"));
                    v.add(rs.getString("empname"));
                    v.add(rs.getString("salary"));
                
                // Adds the vector to the row
                dft.addRow(v);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeReg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsalary;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
