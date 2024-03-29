/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;
import BUS.CourseBUS;
import BUS.CourseInstructorBUS;
import BUS.PersonBUS;
import BUS.Course;
import BUS.CourseInstructor;
import BUS.Person;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Admin
 */
public class CourseIntructorGUI extends javax.swing.JDialog {
  
    private statisticGUIfix statisticGUI ;
    private CourseInstructorBUS courseinstructorbll =new CourseInstructorBUS();
    private PersonBUS personbll=new PersonBUS();
    private List<Person> listps = personbll.selectAll();
    private CourseBUS coursebll=new CourseBUS();
     
    JTable table;
    private String[] listColumn = {"CouseID","Title", "Credits","Departments","PersonID","FirstName"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public CourseIntructorGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setDateToTable();
        setLocationRelativeTo(null) ;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        khung = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jtfTim = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfCourseID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfCredits = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfDepartment = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jboxPersonID = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnstatis = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        khung.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Variable", 0, 14))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jpnView.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        jPanel1.add(jpnView, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(250, 250, 250));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Variable", 0, 14))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(980, 60));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(204, 204, 204)));
        jtfTim.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel7.add(jtfTim);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(250, 250, 250));
        jPanel8.setPreferredSize(new java.awt.Dimension(980, 60));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel9.setBackground(new java.awt.Color(250, 250, 250));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Variable", 0, 14))); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 360));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(250, 250, 250));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel2.setText("CourseID :");
        jLabel2.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel11.add(jLabel2);

        jtfCourseID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfCourseID.setEnabled(false);
        jtfCourseID.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel11.add(jtfCourseID);

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel3.setText("Title :");
        jLabel3.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel11.add(jLabel3);

        jtfTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfTitle.setEnabled(false);
        jtfTitle.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel11.add(jtfTitle);

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel4.setText("Credits :");
        jLabel4.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel11.add(jLabel4);

        jtfCredits.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfCredits.setEnabled(false);
        jtfCredits.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel11.add(jtfCredits);

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel5.setText("DepartmentID :");
        jLabel5.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel11.add(jLabel5);

        jtfDepartment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfDepartment.setEnabled(false);
        jtfDepartment.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel11.add(jtfDepartment);

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel6.setText("PersonID :");
        jLabel6.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel11.add(jLabel6);

        jboxPersonID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jboxPersonID.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel11.add(jboxPersonID);

        jPanel17.setOpaque(false);
        jPanel17.setPreferredSize(new java.awt.Dimension(250, 70));
        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 42, 30));

        btnsave.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnsave.setText("Lưu");
        btnsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsave.setPreferredSize(new java.awt.Dimension(80, 30));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel17.add(btnsave);

        btnremove.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnremove.setText("Xóa");
        btnremove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnremove.setPreferredSize(new java.awt.Dimension(80, 30));
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });
        jPanel17.add(btnremove);

        jPanel11.add(jPanel17);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setBackground(new java.awt.Color(250, 250, 250));
        jPanel12.setPreferredSize(new java.awt.Dimension(290, 10));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(250, 250, 250));
        jPanel13.setPreferredSize(new java.awt.Dimension(290, 70));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        btnstatis.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnstatis.setText("XEM THỐNG KÊ DANH SÁCH LỚP");
        btnstatis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnstatis.setPreferredSize(new java.awt.Dimension(260, 40));
        btnstatis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstatisActionPerformed(evt);
            }
        });
        jPanel13.add(btnstatis);

        jPanel9.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jPanel14.setBackground(new java.awt.Color(250, 250, 250));
        jPanel14.setPreferredSize(new java.awt.Dimension(10, 163));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel14, java.awt.BorderLayout.LINE_END);

        jPanel15.setBackground(new java.awt.Color(250, 250, 250));
        jPanel15.setPreferredSize(new java.awt.Dimension(10, 163));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel15, java.awt.BorderLayout.LINE_START);

        jPanel2.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel10.setBackground(new java.awt.Color(250, 250, 250));
        jPanel10.setPreferredSize(new java.awt.Dimension(5, 360));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel10, java.awt.BorderLayout.LINE_START);

        khung.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 80));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý phân công");
        jPanel3.add(jLabel1);

        khung.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 10));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        khung.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setPreferredSize(new java.awt.Dimension(10, 400));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        khung.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setPreferredSize(new java.awt.Dimension(10, 400));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        khung.add(jPanel6, java.awt.BorderLayout.LINE_START);

        getContentPane().add(khung, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        //tạo ra một đối tượng CourseInstructor mới
        CourseInstructor courseinstructorDTO= new CourseInstructor();    
        //kiểm tra điều kiện hợp lệ
        if (jtfCourseID.getText().equals("")||jboxPersonID.getSelectedItem().equals("None"))
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khóa học hoặc chưa chọn giảng viên!", "Thông báo", JOptionPane.WARNING_MESSAGE);             
        else         
        {   // thiết lập các thuộc tính cho đối tượng mới
            courseinstructorDTO.setCourseID(Integer.parseInt(jtfCourseID.getText()));
            courseinstructorDTO.setPersonID(Integer.parseInt(jboxPersonID.getSelectedItem().toString()));
            //kiểm tra xem CourseID có trong bảng CourseInstructor chưa
            //nếu chưa thì thêm 1 phân công mới
            if(courseinstructorbll.selectById(courseinstructorDTO)==null){  
                //thêm phân công
                addCourseinstructor(courseinstructorDTO);
            }
            //nếu đã có thì cập nhật lại phân công
            else {
                //cập nhật phân công
                updateCourseinstructor(courseinstructorDTO);
            }
            setDateToTable();   
        }
       
    }//GEN-LAST:event_btnsaveActionPerformed
       
    public void addCourseinstructor(CourseInstructor t){
        //thêm phân công
        if(courseinstructorbll.insert(t)==1){
            JOptionPane.showMessageDialog(null, "Lưu thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Lưu thất bại!", "Thông báo", JOptionPane.WARNING_MESSAGE);   
        }
    }
   
     public void updateCourseinstructor(CourseInstructor t){
        //cập nhật phân công
        if(courseinstructorbll.update(t)==1){
            JOptionPane.showMessageDialog(null, "Lưu thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Lưu thất bại!", "Thông báo", JOptionPane.WARNING_MESSAGE);   
        }
    }
    
    
    private void btnstatisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatisActionPerformed
        //Hiển thị giao diện thống kê
        statisticGUI = new statisticGUIfix(this, rootPaneCheckingEnabled);
        statisticGUI.setVisible(true);
    }//GEN-LAST:event_btnstatisActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
//  chức năng xóa
    CourseInstructor courseinstructorDTO= new CourseInstructor();       
    if (jtfCourseID.getText().equals("")||jboxPersonID.getSelectedItem().equals("None"))
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khóa học hoặc khóa học chưa được phân công!", "Thông báo", JOptionPane.WARNING_MESSAGE);             
    else{
            courseinstructorDTO.setCourseID(Integer.parseInt(jtfCourseID.getText()));
            courseinstructorDTO.setPersonID(Integer.parseInt(jboxPersonID.getSelectedItem().toString()));
            //Xóa phân công
            deleteCourseinstructor(courseinstructorDTO);
            setDateToTable(); 
        }
    }//GEN-LAST:event_btnremoveActionPerformed
    
    public void deleteCourseinstructor(CourseInstructor t){
        //Xóa phân công
        if(courseinstructorbll.delete(t)==1){
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", JOptionPane.WARNING_MESSAGE);   
        }
    }   
    
    //TableCourseinstructor : tạo bảng
    public void setTableKH(List<Course> Listcourse,List<CourseInstructor> Listcourseinstructor, String[] listColumn){ 
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {//Không được chỉnh sửa hàng và cột của bảng
                return false;
            }       
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = Listcourse.size();
        if(rows > 0){
            for(int i = 0;i<rows;i++){
                Course course = Listcourse.get(i);             
                obj = new Object[columns];  //Mỗi phần tử trong mảng là một cột
                //obj[0] = (i+1);
                // gán các thông tin khóa học vô cột của bảng
                obj[0] = course.getCourseID();
                obj[1] = course.getTitle();
                obj[2] = course.getCredits();
                obj[3] = course.getDepartmentID();
                // hàm for để tìm các khóa học đã được phân công
                for (CourseInstructor Listcourseinstructor1 : Listcourseinstructor) {
                    CourseInstructor courseinstructor=Listcourseinstructor1;
                    //nếu CourseID có trong CourseInstructor thì khóa học đã được phân công
                    if(courseinstructor.getCourseID()==course.getCourseID()){
                        //khóa học đã được phân công sẽ có PersonID,gán PersonID vào cột của bảng
                        obj[4] = courseinstructor.getPersonID();
                        //từ PersonID tìm được Firstname và gán Firstname vào cột của bảng
                        Person ps=new Person();                        
                        ps.setPersonID(courseinstructor.getPersonID());
                        obj[5] = personbll.selectById(ps).getFirstname();                                                
                    }
                }              
               dtm.addRow(obj); 
            }
            
        }       
        table = new JTable(dtm);
    }
    
//  LoadTableCourseinstructor : load dữ liệu
    
    public void setDateToTable(){
        // Lấy danh sách của khóa học từ database
        List<Course> listcourse = coursebll.getAll();
        // Lấy danh sách của phân công khóa học từ database
        List<CourseInstructor> listcourseinstructor = courseinstructorbll.selectAll();
        
        setTableKH(listcourse,listcourseinstructor, listColumn);
        
        //giúp bảng có khả năng sắp xếp và lọc dữ liệu
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfTim.getDocument().addDocumentListener(new DocumentListener() {
        //tìm kiếm
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfTim.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfTim.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        //chỉnh bảng cho đẹp
        table.setRowHeight(40);
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        //xử lý sự kiện khi click vào 1 dòng trong bản
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //kiểm tra số lần click và đó có phải 1 dòng hay không
                if(e.getClickCount()==1 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lấy Index dòng được chọn
                    int SRow = table.getSelectedRow();
                    //khi sắp xếp, Index dòng được chọn vẫn dùng
                    SRow = table.convertRowIndexToModel(SRow);                        
                    //gán các thông tin của dòng vào các ô có sẵn
                    getJtfCourseID().setText( model.getValueAt(SRow, 0).toString());
                    getJtfTitle().setText(model.getValueAt(SRow,1).toString());
                    getJtfCredits().setText(model.getValueAt(SRow,2).toString());
                    getJtfDepartment().setText(model.getValueAt(SRow,3).toString());
                    getJboxPersonID().removeAllItems();
                    getJboxPersonID().addItem("None");
                    for(Person ps: listps){
                        if(ps.getHireDate()!=null)
                            getJboxPersonID().addItem(""+ps.getPersonID());
                    }
                    if(model.getValueAt(SRow, 4) != null)
                        getJboxPersonID().setSelectedItem(model.getValueAt(SRow, 4).toString());
                }
            }
            
        });
        //chỉnh tiêu đề
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));
        header.setPreferredSize(new Dimension(50, 50));
        // Căn giữa tiêu đề theo chiều dọc
        DefaultTableCellRenderer centerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.validate();
        table.repaint();
        //hiển thị bảng dữ liệu một cách thuận tiện và đảm bảo nó không bị tràn ra khỏi kích thước hiển thị
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(800,400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
        }
    
    public void setJboxPersonID(JComboBox<String> jboxPersonID) {
        this.jboxPersonID = jboxPersonID;
    }

    public void setJtfCourseID(JTextField jtfCourseID) {
        this.jtfCourseID = jtfCourseID;
    }

    public void setJtfCredits(JTextField jtfCredits) {
        this.jtfCredits = jtfCredits;
    }

    public void setJtfDepartment(JTextField jtfDepartment) {
        this.jtfDepartment = jtfDepartment;
    }

    public void setJtfTitle(JTextField jtfTitle) {
        this.jtfTitle = jtfTitle;
    }

    public JComboBox<String> getJboxPersonID() {
        return jboxPersonID;
    }

    public JTextField getJtfCourseID() {
        return jtfCourseID;
    }

    public JTextField getJtfCredits() {
        return jtfCredits;
    }

    public JTextField getJtfDepartment() {
        return jtfDepartment;
    }

    public JTextField getJtfTitle() {
        return jtfTitle;
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CourseIntructorGUI dialog = new CourseIntructorGUI(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnstatis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> jboxPersonID;
    private javax.swing.JPanel jpnView;
    private javax.swing.JTextField jtfCourseID;
    private javax.swing.JTextField jtfCredits;
    private javax.swing.JTextField jtfDepartment;
    private javax.swing.JTextField jtfTim;
    private javax.swing.JTextField jtfTitle;
    private javax.swing.JPanel khung;
    // End of variables declaration//GEN-END:variables
}
