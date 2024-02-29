/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.ResultBUS;
import BUS.Course;
import BUS.StudentGrade;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;
import static oracle.sql.NUMBER.e;

/**
 *
 * @author ACER
 */
public class ResultGUI extends javax.swing.JFrame {

    private ResultBUS RSBUS = new ResultBUS();
    private ArrayList<Course> courseInfoListOnl = RSBUS.GetCourseOnline();
    private ArrayList<Course> courseInfoListOff = RSBUS.GetCourseOffline();
    ArrayList<StudentGrade> liststuden;
    ArrayList<Integer> errorRows;

    public ResultGUI() {
        initComponents();
        Search();
        checkError();
        KeyStroke saveKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        btnSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(saveKeyStroke, "save");
        btnSave.getActionMap().put("save", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSave.doClick();
            }
        });
    }

    public void Search() {
        Document searchDocument = Search.getDocument();
        searchDocument.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearch();
            }
        });
    }

    private void updateSearch() {
        String searchText = Search.getText();
        searchAndDisplay(searchText);
    }

    private void searchAndDisplay(String searchText) {
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblStudent.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                Object valueCol3 = entry.getValue(1);
//                Object valueCol4 = entry.getValue(3);
                String text = searchText.toLowerCase();
                return valueCol3.toString().toLowerCase().contains(text);
            }
        };
        sorter.setRowFilter(rowFilter);
    }

    public void reloadTableGrade() {
        String selectedItem = CbbCourse.getSelectedItem().toString();
        String[] parts = selectedItem.split("-", 2);
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        if (parts.length < 2) {
            //JOptionPane.showMessageDialog(this, "Chọn một khóa học hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            model.setRowCount(0);
        } else {
            int firstPart = Integer.parseInt(parts[0].trim());
            if (liststuden != null) {
                liststuden.clear();
            }
            liststuden = RSBUS.GetStudent(firstPart);
            if (liststuden != null && !liststuden.isEmpty()) {
                int count = 0;
                model.setRowCount(0);
                for (StudentGrade student : liststuden) {
                    count++;
                    Object[] rowData = {count, student.getStudentId(), student.getFirstname(), student.getLastname(), student.getGrade()};
                    model.addRow(rowData);
                }
                tblStudent.setModel(model);
                DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
                leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
                tblStudent.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);
            } else {
                model.setRowCount(0);

            }
        }
    }

    public void checkError() {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblStudent.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tblStudent.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean stopCellEditing() {
                String text = ((JTextField) getComponent()).getText();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ô không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    Component component = getComponent();
                    if (component instanceof JTextField) {
                        ((JTextField) component).setText(""); // Xóa nội dung của ô
                    }
                    SwingUtilities.invokeLater(() -> {
                        tblStudent.requestFocusInWindow(); // Focus vào bảng
                        tblStudent.changeSelection(tblStudent.getSelectedRow(), 4, false, false); // Focus vào dòng đang chọn
                    });
                    btnSave.setEnabled(false);
                    return false;
                }

                try {
                    double value = Double.parseDouble(text);
                    if (value < 0 || value > 4) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số từ 0 đến 4!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        Component component = getComponent();
                        if (component instanceof JTextField) {
                            ((JTextField) component).setText(""); // Xóa nội dung của ô
                        }
                        SwingUtilities.invokeLater(() -> {
                            tblStudent.requestFocusInWindow(); // Focus vào bảng
                            tblStudent.changeSelection(tblStudent.getSelectedRow(), 4, false, false); // Focus vào dòng đang chọn
                        });
                        btnSave.setEnabled(false);
                        return false;
                    }
                } catch (NumberFormatException e) {
                    // Nếu không phải là số, hiển thị thông báo lỗi
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    Component component = getComponent();
                    if (component instanceof JTextField) {
                        ((JTextField) component).setText(""); // Xóa nội dung của ô
                    }
                    SwingUtilities.invokeLater(() -> {
                        tblStudent.requestFocusInWindow(); // Focus vào bảng
                        tblStudent.changeSelection(tblStudent.getSelectedRow(), 4, false, false); // Focus vào dòng đang chọn
                    });
                    btnSave.setEnabled(false);
                    return false;
                }
                return super.stopCellEditing();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        CbbCourse = new javax.swing.JComboBox<>();
        CbbOnOff = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Search = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        btnSave2 = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản Lý Kết Quả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblStudent.setAutoCreateRowSorter(true);
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "StudentId", "Họ", "Tên", "Điểm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudent.setName(""); // NOI18N
        tblStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblStudentKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        CbbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa Chọn", " " }));
        CbbCourse.setEnabled(false);
        CbbCourse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CbbCourseFocusLost(evt);
            }
        });
        CbbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbCourseActionPerformed(evt);
            }
        });

        CbbOnOff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Khóa Học", "Online", "Offline" }));
        CbbOnOff.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CbbOnOffFocusLost(evt);
            }
        });
        CbbOnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbOnOffActionPerformed(evt);
            }
        });

        jLabel3.setText("Khóa Học");

        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btnSave.setText("Lưu");
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSave.setIconTextGap(8);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave1.setText("Thêm");
        btnSave1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSave1.setIconTextGap(8);
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        btnSave1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSave1KeyPressed(evt);
            }
        });

        btnSave2.setText("Ghi Danh");
        btnSave2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSave2.setIconTextGap(8);
        btnSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave2ActionPerformed(evt);
            }
        });
        btnSave2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSave2KeyPressed(evt);
            }
        });

        btnReload.setText("Reload");
        btnReload.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReload.setIconTextGap(8);
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        btnReload.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnReloadKeyPressed(evt);
            }
        });

        jLabel1.setText("Theo Mã:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbbOnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReload)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(CbbOnOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int rowCount = tblStudent.getRowCount();
        String selectedItem = CbbCourse.getSelectedItem().toString();
        String[] parts = selectedItem.split("-", 2);
        int firstPart = Integer.parseInt(parts[0].trim());
        ArrayList<Object[]> data = new ArrayList<>();
        int checkError = 0;
        for (int i = 0; i < rowCount; i++) {
            Object value = tblStudent.getValueAt(i, 4);
            if (value instanceof Double || value instanceof String) {
                Double gradeDouble = null;
                if (value instanceof Double) {
                    gradeDouble = (Double) value;
                } else if (value instanceof String) {
                    try {
                        gradeDouble = Double.parseDouble((String) value);
                    } catch (NumberFormatException e) {
                        System.err.println("Giá trị không hợp lệ: " + value);
                        continue; // Bỏ qua giá trị không hợp lệ và tiếp tục với hàng tiếp theo
                    }
                }
                if (gradeDouble != null && gradeDouble >= 0 && gradeDouble <= 4) { // Kiểm tra giá trị của gradeInt
                    Object[] rowData = new Object[2];
                    rowData[0] = tblStudent.getValueAt(i, 1);
                    rowData[1] = gradeDouble;
                    data.add(rowData);
                }
            }
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn lưu thay đổi?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (!data.isEmpty()) {
//                for (Object[] row : data) {
//                    System.out.println(Arrays.toString(row));
//                }
                if (RSBUS.UpdateStudent(data, firstPart)) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CbbOnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbOnOffActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        model.setRowCount(0);

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Chưa Chọn");

        if (CbbOnOff.getSelectedItem().equals("Online")) {
            CbbCourse.setEnabled(true);
            for (Course courseInfo : courseInfoListOnl) {
                comboBoxModel.addElement(courseInfo.getCourseID() + " - " + courseInfo.getTitle());
            }
        } else if (CbbOnOff.getSelectedItem().equals("Offline")) {
            CbbCourse.setEnabled(true);
            for (Course courseInfo : courseInfoListOff) {
                comboBoxModel.addElement(courseInfo.getCourseID() + " - " + courseInfo.getTitle());
            }
        } else {
            model.setRowCount(0);
            CbbCourse.setEnabled(false);
        }

        CbbCourse.setModel(comboBoxModel);
    
    }//GEN-LAST:event_CbbOnOffActionPerformed

    private void CbbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbCourseActionPerformed
        //tblStudent.clearSelection();
        String selectedItem = CbbCourse.getSelectedItem().toString();
        String[] parts = selectedItem.split("-", 2);
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        if (parts.length < 2) {
            model.setRowCount(0);
        } else {
            int firstPart = Integer.parseInt(parts[0].trim());
            if (liststuden != null) {
                liststuden.clear();
            }
            liststuden = RSBUS.GetStudent(firstPart);
            if (liststuden != null && !liststuden.isEmpty()) {
                int count = 0;
                model.setRowCount(0);
                for (StudentGrade student : liststuden) {
                    count++;
                    Object[] rowData = {count, student.getStudentId(), student.getFirstname(), student.getLastname(), student.getGrade()};
                    model.addRow(rowData);
                }
                tblStudent.setModel(model);
                DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
                leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
                tblStudent.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);
            } else {
                model.setRowCount(0);

            }
        }


    }//GEN-LAST:event_CbbCourseActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

    }//GEN-LAST:event_SearchActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveKeyPressed

    private void CbbOnOffFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CbbOnOffFocusLost
        CbbCourseActionPerformed(null);        // TODO add your handling code here:
    }//GEN-LAST:event_CbbOnOffFocusLost

    private void CbbCourseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CbbCourseFocusLost
        CbbCourseActionPerformed(null);   // TODO add your handling code here:
    }//GEN-LAST:event_CbbCourseFocusLost

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblStudent.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
            int studentId = Integer.parseInt(tblStudent.getValueAt(selectedRow, 1).toString());  // Lấy StudentId từ dòng được chọn
            String selectedItem = CbbCourse.getSelectedItem().toString();
            String[] parts = selectedItem.split("-", 2);
            int courseId = Integer.parseInt(parts[0].trim()); // Lấy CourseId từ ComboBox
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dữ liệu của sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Gọi phương thức để xóa dữ liệu sinh viên với StudentId và CourseId tương ứng
                boolean deleteSuccess = RSBUS.DeleteStudent(studentId, courseId);
                if (deleteSuccess) {
                    // Nếu xóa thành công, cập nhật lại bảng hoặc thông báo thành công
                    DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
                    model.removeRow(selectedRow); // Xóa dòng khỏi bảng hiện tại
                    JOptionPane.showMessageDialog(this, "Dữ liệu của sinh viên đã được xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa dữ liệu của sinh viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sinh viên để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
        AddCourse gui = new AddCourse(this, rootPaneCheckingEnabled);
        gui.settxt_course(CbbCourse.getSelectedItem().toString());

        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.addWindowListener(new WindowAdapter() {
            @Override

public void windowClosed(WindowEvent e) {
                reloadTableGrade();

            }
        });
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnSave1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSave1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1KeyPressed

    private void btnSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave2ActionPerformed
        // TODO add your handling code here:
        GhiDanhGUI gui = new GhiDanhGUI(this, rootPaneCheckingEnabled);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }//GEN-LAST:event_btnSave2ActionPerformed

    private void btnSave2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSave2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave2KeyPressed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        String selectedItem = CbbCourse.getSelectedItem().toString();
        String[] parts = selectedItem.split("-", 2);
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        if (parts.length < 2) {
            //JOptionPane.showMessageDialog(this, "Chọn một khóa học hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            model.setRowCount(0);
        } else {
            int firstPart = Integer.parseInt(parts[0].trim());
            if (liststuden != null) {
                liststuden.clear();
            }
            liststuden = RSBUS.GetStudent(firstPart);
            if (liststuden != null && !liststuden.isEmpty()) {
                int count = 0;
                model.setRowCount(0);
                for (StudentGrade student : liststuden) {
                    count++;
                    Object[] rowData = {count, student.getStudentId(), student.getFirstname(), student.getLastname(), student.getGrade()};
                    model.addRow(rowData);
                }
                tblStudent.setModel(model);
                DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
                leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
                tblStudent.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);
            } else {
                model.setRowCount(0);

            }
        }

    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnReloadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnReloadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReloadKeyPressed

    private void tblStudentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             btnSave.setEnabled(true);
        }
    }//GEN-LAST:event_tblStudentKeyPressed

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
            java.util.logging.Logger.getLogger(ResultGUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultGUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultGUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultGUI.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultGUI().setVisible(true);
            }
        }
        );
        // Ánh xạ phím tắt Ctrl+C cho button
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbCourse;
    private javax.swing.JComboBox<String> CbbOnOff;
    private javax.swing.JTextField Search;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudent;
    // End of variables declaration//GEN-END:variables
}
