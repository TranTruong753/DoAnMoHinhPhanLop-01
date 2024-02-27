/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import BUS.ResultBUS;
import DTO.StudentGrade;
import DTO.Person;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

/**
 *
 * @author M S I
 */

public class AddCourse extends javax.swing.JDialog {

    /**
     * Creates new form DepartmentGUI
     */
    public AddCourse(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadStudentList();

    }
    ArrayList<Person> arr = new ArrayList<>();
    ResultBUS resultBUS = new ResultBUS();

    public void loadStudentList() {
        DefaultTableModel dtm = (DefaultTableModel) tb_student.getModel();
        dtm.setRowCount(0);
        arr = resultBUS.GetAllStudent();
        for (int i = 0; i < arr.size(); i++) {
            int StudentID = arr.get(i).getPersonID();
            String Lastname = arr.get(i).getLastname();
            String Firstname = arr.get(i).getFirstname();
            Object[] row = {StudentID, Lastname, Firstname};
            dtm.addRow(row);
        }
    }
//    public void loadGradeTable(){
//        DefaultTableModel dtm = (DefaultTableModel) tb_grade.getModel();
//        dtm.setRowCount(0);
//        ArrayList<studentgrade> arr =  new ArrayList<studentgrade>();
//        arr = grade_Bus.getAllStudentInCourse();
//        int STT = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            STT++;
//            int StudenID = arr.get(i).getStudentID();
//            String Ten = arr.get(i).getTenNCC();
//            String SDT = arr.get(i).getSDT();
//            String Diachi = arr.get(i).getDiachi();
//            Object[] row = {MaNCC,TenNCC,SDT,Diachi};
//            dtm.addRow(row);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_them = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_themsuaxoa = new javax.swing.JPanel();
        lb_mancc1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_student = new javax.swing.JTable();
        txt_course = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_them.setBackground(new java.awt.Color(0, 153, 153));
        btn_them.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/addnew.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Classroom.png"))); // NOI18N
        jLabel1.setText("THÊM HỌC VIÊN VÀO KHÓA HỌC");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_themsuaxoa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_mancc1.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        lb_mancc1.setText("Chọn 1 học viên để thêm vào khóa học: ");

        tb_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "StudentID", "Last Name", "First Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb_student);

        txt_course.setEditable(false);
        txt_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_themsuaxoaLayout = new javax.swing.GroupLayout(panel_themsuaxoa);
        panel_themsuaxoa.setLayout(panel_themsuaxoaLayout);
        panel_themsuaxoaLayout.setHorizontalGroup(
            panel_themsuaxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_themsuaxoaLayout.createSequentialGroup()
                .addGroup(panel_themsuaxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_themsuaxoaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_themsuaxoaLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lb_mancc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_course, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel_themsuaxoaLayout.setVerticalGroup(
            panel_themsuaxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_themsuaxoaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_themsuaxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_mancc1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_themsuaxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_themsuaxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        int selectedRow = tb_student.getSelectedRow();
        if (txt_course.getText().equals("Chưa Chọn")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khóa học nào", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (selectedRow == -1) {
            // Hiển thị thông báo nếu chưa chọn dòng nào
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một học viên", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int studentID = (int) tb_student.getValueAt(selectedRow, 0);
        StudentGrade mh = new StudentGrade();
        mh.setStudentId(studentID);
        String[] parts = txt_course.getText().split("-", 2);
        int firstPart = Integer.parseInt(parts[0].trim());
        mh.setCourseId(firstPart);

        mh.setGrade(0.0);
        JOptionPane.showMessageDialog(this, resultBUS.AddStudentCource(mh, firstPart, studentID));
    }//GEN-LAST:event_btn_themActionPerformed

    private void txt_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddCourse dialog = new AddCourse(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void settxt_course(String name) {
        txt_course.setText(name);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_them;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_mancc1;
    private javax.swing.JPanel panel_themsuaxoa;
    private javax.swing.JTable tb_student;
    private javax.swing.JTextField txt_course;
    // End of variables declaration//GEN-END:variables

}
