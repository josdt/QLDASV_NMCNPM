
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Administrator
 */
public class cuasoDoan extends javax.swing.JPanel {

    /**
     * Creates new form cuasoDoan
     */
    DefaultTableModel defaultTableModel;
    DefaultTableModel defaultTableModel1;
    public cuasoDoan() {
        initComponents();
        show();
        show1();
    }
    public void show(){
    defaultTableModel = new DefaultTableModel();
        bangDOAN.setEditingColumn(0);
        bangDOAN.setEditingRow(0);
        defaultTableModel.addColumn("MÃ ĐỒ ÁN");
        defaultTableModel.addColumn("TÊN ĐỒ ÁN");
        ArrayList<doAn> list= ThaoTacGV.getTableviewDoAn();
        for(doAn k: list){
            defaultTableModel.addRow(k.toObjectsviewDA());
        }
        bangDOAN.setModel(defaultTableModel);
        
        
    }
    public void show1(){
        defaultTableModel1 = new DefaultTableModel();
        String magv=GiangVien_Form.ma;
        bangDS.setEditingColumn(0);
        bangDS.setEditingRow(0);
        loadcbbmaDA(magv);
        loadcbbmaSV(magv);
        defaultTableModel1.addColumn("MÃ SINH VIÊN");
        defaultTableModel1.addColumn("MÃ GIẢNG VIÊN HƯỚNG DẪN");
        defaultTableModel1.addColumn("MÃ ĐỒ ÁN");  
        ArrayList<phanDoAn> list1 =ThaoTacGV.getTablephanDoAn();
        for(phanDoAn l: list1){
            defaultTableModel1.addRow(l.toObjectsphanDA());
        }
        bangDS.setModel(defaultTableModel1);
    }
    public void loadcbbmaSV(String magv){
        Connection ketNoi = DBConnection.getConnection();
        String sql = "SELECT masv from ct_doan where magvhd='"+magv+"'  order by masv";
        
        jcbbmaSV.removeAllItems();
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jcbbmaSV.addItem(rs.getString("masv"));

            }
            rs.close();
            ps.close();
            ketNoi.close();

        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void loadcbbmaDA(String magv){
        Connection ketNoi = DBConnection.getConnection();
        String sql = "SELECT madoan from doan where magv='"+magv+"'  order by madoan";
        
        jcbbmaDA.removeAllItems();
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jcbbmaDA.addItem(rs.getString("madoan"));

            }
            rs.close();
            ps.close();
            ketNoi.close();

        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Boolean tontaiDiemhd(String maSV){
        java.sql.Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from CT_DOAN where CT_DOAN.MASV=? and CT_DOAN.diemhd is not null");
            preparedStatement.setString(1,maSV );
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThaoTacGV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangDS = new javax.swing.JTable();
        jLabeltbDA = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangDOAN = new javax.swing.JTable();
        jcbbmaSV = new javax.swing.JComboBox<>();
        jcbbmaDA = new javax.swing.JComboBox<>();

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mã đồ án:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mã Sinh Viên:");
        jLabel2.setOpaque(true);

        jButtonLuu.setText("LƯU");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        bangDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(bangDS);

        jLabeltbDA.setBackground(new java.awt.Color(255, 204, 255));
        jLabeltbDA.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabeltbDA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltbDA.setOpaque(true);

        bangDOAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(bangDOAN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabeltbDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbbmaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbbmaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jButtonLuu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbbmaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLuu)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbbmaDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addComponent(jLabeltbDA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        String MaDA=(String) jcbbmaDA.getSelectedItem().toString();
        String MaSV=(String) jcbbmaSV.getSelectedItem().toString();
        String check="N+[0-9]{1,2}+DCCN+[0-9]{3}";
        if(MaDA.equals("")){
            jLabeltbDA.setText("Bạn chưa nhập mã đồ án!");
            jLabeltbDA.setVisible(true);
            return;
        }
        if(MaSV.equals("")){
            jLabeltbDA.setText("Bạn chưa nhập mã sinh viên!");
            jLabeltbDA.setVisible(true);
            return;
        }
        if(!MaSV.matches(check)){
            jLabeltbDA.setText("Mã sinh viên không đúng định dạng!");
            jLabeltbDA.setVisible(true);
            return;
        }       
        phanDoAn p= new phanDoAn(MaSV, MaSV, MaDA);
        jLabeltbDA.setVisible(false);
        if(ThaoTacGV.ktMaDoAn(MaDA)){
            if(ThaoTacGV.ktMaSV(MaSV)){
                if(ThaoTacGV.ktDoAnMaSV(MaDA)){
                    if(!tontaiDiemhd(MaSV)){
                        int k=JOptionPane.showConfirmDialog(this,"Bạn có muốn lưu không", "Cảnh báo", JOptionPane.YES_NO_OPTION);
                    if(k==0){
                        ThaoTacGV.phanDoAn(p);
                        show1();
                    }
                    }
                    else{
                    JOptionPane.showMessageDialog(this,"Đồ án này đã có điểm hướng dẫn, không được sửa!");
//                    if(ThaoTacGV.ktNullMaDoAn(MaSV)){
                        
//                    }
//                    else{
////                        ThaoTacGV.xoaCham(ThaoTacGV.getMadoanCham(MaSV));
//                        int k=JOptionPane.showConfirmDialog(this,"Bạn có muốn cập nhật không", "Cảnh báo", JOptionPane.YES_NO_OPTION);
//                        if(k==0){
//                        ThaoTacGV.phanDoAn(p);
//                        show1();
//                        }
//                    }
   
                
                
                }
            }
                else{
                    JOptionPane.showMessageDialog(this,"Đồ án này đã được sinh viên khác làm!");
                }            
            }
            else{
                JOptionPane.showMessageDialog(this,"Sinh viên này không tồn tại!");  
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Mã đồ án không tồn tại!");
        }
        //TODO add your handling code here:
    }//GEN-LAST:event_jButtonLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangDOAN;
    private javax.swing.JTable bangDS;
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabeltbDA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbbmaDA;
    private javax.swing.JComboBox<String> jcbbmaSV;
    // End of variables declaration//GEN-END:variables
}