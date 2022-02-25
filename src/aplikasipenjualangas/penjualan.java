
package aplikasipenjualangas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TOSHIBA DC
 */
public class penjualan extends javax.swing.JInternalFrame {
    String nama = login.getU_nama();
private DefaultTableModel TabModel;




PreparedStatement pst = null;



    Connection conn;
    Statement st;
    ResultSet rs;
   
    /**
     * Creates new form barang
     */
    public penjualan() {
        initComponents();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
           pembeliTF.setText(nama);
    siapIsi(false);
   
    
        tombolNormal();
        tgl();
       
        subtotTF.setVisible(false);
        Object header[]={"Kode Barang","Nama Barang","Ukuran","Harga Barang","jumlah","subtotal"};
        TabModel=new DefaultTableModel(null, header);
    }
    
    public void tampilUser(String user){
        pembeliTF.setText(user);
    }
    
    public String Kobe, Naba,Ukur,HargaJua,Stok;

    public String Koba() {
        return Kobe;
    }

    ;
    public String Namaba() {
        return Naba;
    }

    ;
    public String Ukuran() {
        return Ukur;
    }

    ;
    public String Harga() {
        return HargaJua;
    }

    ;
    
    
    
    public String stock() {
        return Stok;
    }

   
private void bersih(){
        noTF.setText("");
        pembeliTF.setText("");
         stokTF.setText("");
        kodeTF.setText("");
        namaTF.setText("");
        hjualTF.setText("");
        jumlahTF.setText("");
        subtotTF.setText("0");
        totalTF.setText("0");
        ubayTF.setText("0");
        ukemTF.setText("0");
    }

    private void siapIsi(boolean a){;
        noTF.setEnabled(a);
        pembeliTF.setEnabled(a);
        kodeTF.setEnabled(a);
        namaTF.setEnabled(a);
        hjualTF.setEnabled(a);
        jumlahTF.setEnabled(a);
        totalTF.setEnabled(a);
        ubayTF.setEnabled(a);
        ukemTF.setEnabled(a);
    }
    
    private void tombolNormal(){
        tambahBT.setEnabled(true);
        simpanBT.setEnabled(false);
        tbhBrgBT.setEnabled(false);
        krgBrgBT.setEnabled(false);
        cariBrgBT.setEnabled(false);
    }
    
      private void tgl(){
    Date date = new Date();
        tglTF.setDate(date);
}
      
    
    private void otomatis(){
        try {
            setKoneksi();
            String sql="select right (notrans,2)+1 from penjualan";
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    noTF.setText("T"+no);}
                }
            else
            {
                noTF.setText("T001"); 
        }
        } catch (Exception e) 
        {
        }
    } 
    private void cekstock(){
        try{
            setKoneksi();
            rs=st.executeQuery("SELECT *from barang where kodebarang='" + k.getText() + "'");
            
            if (rs.next());
            k.setText(rs.getString("kodebarang"));
            
            p.setText(rs.getString("Stok"));
             } catch (Exception e) {
            
             }
          finally{
                
            }
        Integer a = Integer.parseInt(p.getText());
        Integer b = Integer.parseInt(j.getText());
        Integer c = a + b;
        stokTF.setText(String.valueOf(c));
        
            try{
            setKoneksi();
            String sql="update barang set stok='"+stokTF.getText()+"' where kodebarang='"+k.getText()+"'";
            st.executeUpdate(sql);
           
        } 
        catch(Exception e){
        
        }
        

        }
    
    public void ambildata() {
        Integer a = Integer.parseInt(stokTF.getText());
        Integer b = Integer.parseInt(jumlahTF.getText());
        Integer c = a - b;
        stokTF.setText(String.valueOf(c));
        
            try{
            setKoneksi();
            String sql="update barang set stok='"+stokTF.getText()+"' where kodebarang='"+kodeTF.getText()+"'";
            st.executeUpdate(sql);
           
        } 
        catch(Exception e){
        
        }
       finally{
                
            }
        
        try {
            jTable1.setModel(TabModel);
                String kolom1 = kodeTF.getText();
                String kolom2 = namaTF.getText();
                String kolom3 = ukurTF.getText();
                String kolom4 = hjualTF.getText();
                String kolom5 = jumlahTF.getText();
                String kolom6 = subtotTF.getText();
                String[] kolom = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6};
                TabModel.addRow(kolom);
          }
          catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Data gagal disimpan");
          }     
    }
    
    private void simpan(){
        setKoneksi();
        try {
            Date skrg=new Date();
            SimpleDateFormat frm=new SimpleDateFormat("yyyy-MM-dd");
            String tgl=frm.format(skrg); 
            
            int t = jTable1.getRowCount();
            for(int i=0;i<t;i++)    
            {
            String kdbrng=jTable1.getValueAt(i, 0).toString();
            String nmbrng=jTable1.getValueAt(i, 1).toString();
             String ukur=jTable1.getValueAt(i, 2).toString();
            
            int harga= Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            int jml= Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            int subtot= Integer.parseInt(jTable1.getValueAt(i, 5).toString());
         
            String sql ="insert into penjualan values('"+noTF.getText()+"','"+tgl+"','"+pembeliTF.getText()+"','"
                    +kdbrng+"','"+nmbrng+"','"+ukur+"','"+harga+"','"+jml+"','"+subtot+"','"+totalTF.getText()+"','"+ubayTF.getText()+"','"+ukemTF.getText()+"')";
            
             st.executeUpdate(sql);
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Simpan transaksi penjualan gagal");
        }
    }
    
    
    private void hapusdatadaritabel() {
        int a = jTable1.getSelectedRow();
        if(a == -1){
        }TabModel.removeRow(a);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        totalTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        kodeTF = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        pembeliTF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        hjualTF = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        namaTF = new javax.swing.JTextField();
        jumlahTF = new javax.swing.JTextField();
        noTF = new javax.swing.JTextField();
        tglTF = new com.toedter.calendar.JDateChooser();
        tbhBrgBT = new javax.swing.JButton();
        krgBrgBT = new javax.swing.JButton();
        cariBrgBT = new javax.swing.JButton();
        p = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ukemTF = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ubayTF = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        simpanBT = new javax.swing.JButton();
        tambahBT = new javax.swing.JButton();
        stokTF = new javax.swing.JTextField();
        ukurTF = new javax.swing.JTextField();
        k = new javax.swing.JTextField();
        j = new javax.swing.JTextField();
        subtotTF = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1160, 570));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Transaksi Penjualan");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 480, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 490, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1160, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)), "Silahkan Transaksi Penjualan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 204, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalTF.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        totalTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalTF.setText("0");
        totalTF.setBorder(null);
        totalTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTFActionPerformed(evt);
            }
        });
        totalTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totalTFKeyPressed(evt);
            }
        });
        jPanel3.add(totalTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 260, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("No Transaksi          :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tanggal Transaksi  :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Pembeli                 :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 200, 10));

        kodeTF.setBorder(null);
        kodeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kodeTFKeyReleased(evt);
            }
        });
        jPanel3.add(kodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 380, 10));

        pembeliTF.setBorder(null);
        jPanel3.add(pembeliTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 250, 30));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 380, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Jumlah");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        hjualTF.setBorder(null);
        jPanel3.add(hjualTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 230, 30));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 380, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Kode Barang");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 190, 10));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 230, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nama Barang");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 230, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Harga Jual");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        namaTF.setBorder(null);
        jPanel3.add(namaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 230, 30));

        jumlahTF.setBorder(null);
        jumlahTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jumlahTFKeyPressed(evt);
            }
        });
        jPanel3.add(jumlahTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 120, 30));

        noTF.setBorder(null);
        jPanel3.add(noTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 250, 30));

        tglTF.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglTFPropertyChange(evt);
            }
        });
        jPanel3.add(tglTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 250, 30));

        tbhBrgBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbhBrgBT.setText("+");
        tbhBrgBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbhBrgBTMouseEntered(evt);
            }
        });
        tbhBrgBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbhBrgBTActionPerformed(evt);
            }
        });
        jPanel3.add(tbhBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, -1, 30));

        krgBrgBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        krgBrgBT.setText("-");
        krgBrgBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                krgBrgBTMouseEntered(evt);
            }
        });
        krgBrgBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                krgBrgBTActionPerformed(evt);
            }
        });
        jPanel3.add(krgBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, -1, 30));

        cariBrgBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Cari2.png"))); // NOI18N
        cariBrgBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cariBrgBTMouseEntered(evt);
            }
        });
        cariBrgBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBrgBTActionPerformed(evt);
            }
        });
        jPanel3.add(cariBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, 30));
        jPanel3.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 10, 0));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 990, 220));

        jTextField6.setBorder(null);
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 230, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)), "Keranjang Belanja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 204, 255))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 990, 150));

        ukemTF.setBorder(null);
        ukemTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukemTFActionPerformed(evt);
            }
        });
        jPanel1.add(ukemTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, 210, 30));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, 260, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Bayar    :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 60, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Kembali :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, -1, -1));

        ubayTF.setBorder(null);
        ubayTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubayTFActionPerformed(evt);
            }
        });
        ubayTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ubayTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ubayTFKeyReleased(evt);
            }
        });
        jPanel1.add(ubayTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, 210, 30));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 260, 10));

        simpanBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        simpanBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Print.png"))); // NOI18N
        simpanBT.setText("SIMPAN");
        simpanBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanBTMouseEntered(evt);
            }
        });
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });
        jPanel1.add(simpanBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 110, 40));

        tambahBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tambahBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Tambah.png"))); // NOI18N
        tambahBT.setText("TAMBAH");
        tambahBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahBTMouseEntered(evt);
            }
        });
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });
        jPanel1.add(tambahBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 110, 40));
        jPanel1.add(stokTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, 0));
        jPanel1.add(ukurTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 0, -1));
        jPanel1.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, -1, 0));
        jPanel1.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 490, 0, 0));

        subtotTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotTFActionPerformed(evt);
            }
        });
        jPanel1.add(subtotTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 550, -1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ukemTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukemTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ukemTFActionPerformed

    private void ubayTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubayTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubayTFActionPerformed

    private void tbhBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbhBrgBTActionPerformed
        // TODO add your handling code here:
        
        int harga=Integer.parseInt(hjualTF.getText());
        int jml=Integer.parseInt(jumlahTF.getText());
        int stok=Integer.parseInt(stokTF.getText());
        int total=Integer.parseInt(totalTF.getText());
        
        if(jml>stok){
             JOptionPane.showMessageDialog(null, "Stok barang tidak mencukupi");
        }else{
                 
            int subtot=harga*jml;
            subtotTF.setText(Integer.toString(subtot));
            
            int totbay=total+(harga*jml);
            totalTF.setText(Integer.toString(totbay));
            
            ambildata();
            
        kodeTF.setText("");
        namaTF.setText("");
        hjualTF.setText("");
        jumlahTF.setText("");
        
        }
    }//GEN-LAST:event_tbhBrgBTActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
        if(noTF.getText().equals("") || pembeliTF.getText().equals("") || ubayTF.getText().equals("0") || ukemTF.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Lengkapi inputan penjualan barang");
        } else{
            simpan();  
            int pesan=JOptionPane.showConfirmDialog(null, "Cetak Kwitansi Nota","Cetak",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               
            if(pesan==JOptionPane.YES_OPTION){
                   cetak_nota();
               }else {
                   JOptionPane.showMessageDialog(null, "Simpan Transaksi Berhasil");
               }
            bersih();
        }
    }//GEN-LAST:event_simpanBTActionPerformed

    private void totalTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTFActionPerformed

    private void cariBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBrgBTActionPerformed
        // TODO add your handling code here:
         boolean closable = true;
         brg fDB = new  brg(null, closable);
        fDB.fAB = this;
        fDB.setVisible(true);
        fDB.setResizable(true);
       
        kodeTF.setText(Kobe);
         namaTF.setText(Naba);
          ukurTF.setText(Ukur);
          hjualTF.setText(HargaJua);
           stokTF.setText(Stok);
        
           
    }//GEN-LAST:event_cariBrgBTActionPerformed

    private void krgBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_krgBrgBTActionPerformed
        // TODO add your handling code here:
         cekstock();
         int baris = jTable1.getSelectedRow();
        int qty=Integer.parseInt(jTable1.getModel().getValueAt(baris, 4).toString());
        int total=Integer.parseInt(totalTF.getText());
        int harga=Integer.parseInt(jTable1.getModel().getValueAt(baris, 3).toString());
        
        int totbay=total-(harga*qty);
        totalTF.setText(Integer.toString(totbay)); 
        hapusdatadaritabel();
    }//GEN-LAST:event_krgBrgBTActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         jTable1.setRowSelectionAllowed(true);
        int a = jTable1.getSelectedRow();
        String kolom1 = jTable1.getValueAt(a,0).toString();
        String kolom2 = jTable1.getValueAt(a,1).toString();
        String kolom3 = jTable1.getValueAt(a,2).toString();
        String kolom4 = jTable1.getValueAt(a,3).toString();
        String kolom5 = jTable1.getValueAt(a,4).toString();
        String kolom6 = jTable1.getValueAt(a,5).toString();
         k.setText(jTable1.getModel().getValueAt(a, 0).toString());
          j.setText(jTable1.getModel().getValueAt(a, 4).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void totalTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalTFKeyPressed
        // TODO add your handling code here:
         char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_totalTFKeyPressed

    private void jumlahTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahTFKeyPressed
        // TODO add your handling code here:
         char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jumlahTFKeyPressed

    private void ubayTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubayTFKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_ubayTFKeyReleased

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
        if(tambahBT.getText().equalsIgnoreCase("TAMBAH")){
            tambahBT.setText("BERSIH");
            siapIsi(true);
            bersih();
            otomatis();
            pembeliTF.requestFocus();
            noTF.setEnabled(false);
            simpanBT.setEnabled(true);
            tbhBrgBT.setEnabled(true);
            krgBrgBT.setEnabled(true);
            cariBrgBT.setEnabled(true);
        }else{
            bersih();
            siapIsi(false);
            tambahBT.setText("Tambah");
            TabModel.getDataVector().removeAllElements();
            TabModel.fireTableDataChanged();
            tombolNormal();
        }
        
    }//GEN-LAST:event_tambahBTActionPerformed

    private void ubayTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubayTFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            int total=Integer.parseInt(totalTF.getText());
            int bayar=Integer.parseInt(ubayTF.getText());
            if(bayar<total){
                JOptionPane.showMessageDialog(null, "Jumlah bayar tidak mencukupi");
                ubayTF.requestFocus();
            } else{
                int kembali=bayar-total;
                ukemTF.setText(Integer.toString(kembali));
            }
        }
    }//GEN-LAST:event_ubayTFKeyPressed

    private void tglTFPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglTFPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tglTFPropertyChange

    private void kodeTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeTFKeyReleased
        // TODO add your handling code here:
        try{
            setKoneksi();
            rs=st.executeQuery("SELECT *from barang where kodebarang='" + kodeTF.getText() + "'");
            
            if (rs.next());
            kodeTF.setText(rs.getString("kodebarang"));
            
            p.setText(rs.getString("stok"));
             } catch (Exception e) {
            
             }
    }//GEN-LAST:event_kodeTFKeyReleased

    private void cariBrgBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariBrgBTMouseEntered
        // TODO add your handling code here:
         cariBrgBT.setBackground(new Color(102,204,255));
        cariBrgBT.setForeground(Color.black);
    }//GEN-LAST:event_cariBrgBTMouseEntered

    private void tbhBrgBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhBrgBTMouseEntered
        // TODO add your handling code here:
         tbhBrgBT.setBackground(new Color(102,204,255));
         tbhBrgBT.setForeground(Color.black);
    }//GEN-LAST:event_tbhBrgBTMouseEntered

    private void krgBrgBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_krgBrgBTMouseEntered
        // TODO add your handling code here:
         krgBrgBT.setBackground(new Color(102,204,255));
         krgBrgBT.setForeground(Color.black);
         
    }//GEN-LAST:event_krgBrgBTMouseEntered

    private void tambahBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahBTMouseEntered
        // TODO add your handling code here:
        
          tambahBT.setBackground(new Color(102,204,255));
         tambahBT.setForeground(Color.black);
        
    }//GEN-LAST:event_tambahBTMouseEntered

    private void simpanBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanBTMouseEntered
        // TODO add your handling code here:
        
          simpanBT.setBackground(new Color(102,204,255));
         simpanBT.setForeground(Color.black);
    }//GEN-LAST:event_simpanBTMouseEntered

    private void subtotTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariBrgBT;
    private javax.swing.JTextField hjualTF;
    private javax.swing.JTextField j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jumlahTF;
    private javax.swing.JTextField k;
    private javax.swing.JTextField kodeTF;
    private javax.swing.JButton krgBrgBT;
    private javax.swing.JTextField namaTF;
    private javax.swing.JTextField noTF;
    private javax.swing.JTextField p;
    private javax.swing.JTextField pembeliTF;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTextField stokTF;
    private javax.swing.JTextField subtotTF;
    private javax.swing.JButton tambahBT;
    private javax.swing.JButton tbhBrgBT;
    private com.toedter.calendar.JDateChooser tglTF;
    private javax.swing.JTextField totalTF;
    private javax.swing.JTextField ubayTF;
    private javax.swing.JTextField ukemTF;
    private javax.swing.JTextField ukurTF;
    // End of variables declaration//GEN-END:variables
public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/papantulis","root","");
            st=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }

    
    void cetak_nota(){
        try {
            String NamaFile = "src/Laporan/kwitansijual.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/papantulis","root","");
            HashMap param = new HashMap();
            param.put("notajual",noTF.getText());
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!","Cetak Data",JOptionPane.ERROR_MESSAGE);
        }
    }

}




