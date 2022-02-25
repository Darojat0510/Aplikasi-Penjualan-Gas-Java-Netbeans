
package aplikasipenjualangas;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class pembelian extends javax.swing.JInternalFrame {
private DefaultTableModel TabModel;





    Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form barang
     */
    public pembelian() {
        initComponents();
        tgl();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
    
    
    
    

siapIsi(false);
        tombolNormal();
        subtotTF.setVisible(false);
        Object header[]={"Kode Barang","Nama Barang","Ukuran","Harga Beli","Jumlah","Subtotal"};
        TabModel=new DefaultTableModel(null, header);
    }
    
    
     public String Kobe, Naba,Ukur,Hargabel,Stok;

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
        return Hargabel;
    }

    ;
    
    
    
    public String stock() {
        return Stok;
    }
    
    public String Kosupp,Namsupp;
     public String Kodesup() {
        return Kosupp;
    }

    ;
    
    public String Namasup() {
        return Namsupp;
    }

    private void tgl(){
    Date date = new Date();
        tglTF.setDate(date);
}
    private void bersih(){
        noTF.setText("");
        supTF.setText("");
        kodeTF.setText("");
        namaTF.setText("");
        hbeliTF.setText("");
        jumlahTF.setText("");
        subtotTF.setText("0");
        totalTF.setText("0");
    }

    private void siapIsi(boolean a){;
        noTF.setEnabled(a);
        supTF.setEnabled(a);
        kodeTF.setEnabled(a);
        namaTF.setEnabled(a);
        hbeliTF.setEnabled(a);
        jumlahTF.setEnabled(a);
        totalTF.setEnabled(a);
    }
    
    private void tombolNormal(){
        tambahBT.setEnabled(true);
        simpanBT.setEnabled(false);
        tbhBrgBT.setEnabled(false);
        krgBrgBT.setEnabled(false);
        cariSupBT.setEnabled(false);
        cariBrgBT.setEnabled(false);
    }
    
    
    
    
    public void ambildata() {
         Integer a = Integer.parseInt(jumlahTF.getText());
        Integer b = Integer.parseInt(stokTF.getText());
        Integer c = a + b;
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
                
                String kolom4 = hbeliTF.getText();
                String kolom5 = jumlahTF.getText();
                String kolom6 = subtotTF.getText();
                String[] kolom = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6};
                TabModel.addRow(kolom);
          }
          catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Data gagal disimpan");
          }     
    }
    
    private void hapusdatadaritabel() {
        
        int a = jTable1.getSelectedRow();
        if(a == -1){
        }TabModel.removeRow(a);
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
            int hbeli= Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            int jml= Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            int subtot= Integer.parseInt(jTable1.getValueAt(i, 5).toString());
         
            String sql ="insert into pembelian values('"+noTF.getText()+"','"+tgl+"','"+supTF.getText()+"','"
                    +kdbrng+"','"+nmbrng+"','"+ukur+"','"+hbeli+"','"+jml+"','"+subtot+"','"+totalTF.getText()+"')";
            
            st.executeUpdate(sql);
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Simpan transaksi gagal");
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
        Integer c = a - b;
        stokTF.setText(String.valueOf(c));
        
            try{
            setKoneksi();
            String sql="update barang set stok='"+stokTF.getText()+"' where kodebarang='"+k.getText()+"'";
            st.executeUpdate(sql);
           
        } 
        catch(Exception e){
        
        }
        

        }
    
       
    
    private void otomatis(){
        try {
            setKoneksi();
            String sql="select right (notrans,2)+1 from pembelian";
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    noTF.setText("P"+no);}
                }
            else
            {
                noTF.setText("P001"); 
        }
        } catch (Exception e) 
        {
        }
        
   
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        tglTF = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jumlahTF = new javax.swing.JTextField();
        supTF = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        cariSupBT = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        kodeTF = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        namaTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        hbeliTF = new javax.swing.JTextField();
        krgBrgBT = new javax.swing.JButton();
        tbhBrgBT = new javax.swing.JButton();
        noTF = new javax.swing.JTextField();
        subtotTF = new javax.swing.JTextField();
        cariBrgBT = new javax.swing.JButton();
        stokTF = new javax.swing.JTextField();
        ukurTF = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        j = new javax.swing.JTextField();
        k = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tambahBT = new javax.swing.JButton();
        simpanBT = new javax.swing.JButton();
        totalTF = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        idTF = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1160, 570));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Transaksi Pembelian");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 490, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 490, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1160, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)), "Silakan Input Data Pembelian", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 204, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tanggal Transaksi  :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 308, 13));

        tglTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(tglTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 178, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("No Transaksi       :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Jumlah");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, -1, -1));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 430, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Supplier             :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 170, 10));

        jumlahTF.setBorder(null);
        jumlahTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahTFActionPerformed(evt);
            }
        });
        jPanel3.add(jumlahTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 80, 30));

        supTF.setBorder(null);
        jPanel3.add(supTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 260, 30));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 430, 10));

        cariSupBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Cari2.png"))); // NOI18N
        cariSupBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cariSupBTMouseEntered(evt);
            }
        });
        cariSupBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSupBTActionPerformed(evt);
            }
        });
        jPanel3.add(cariSupBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Kode Barang");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        kodeTF.setBorder(null);
        jPanel3.add(kodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 30));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 190, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nama Barang");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 190, 10));

        namaTF.setBorder(null);
        namaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTFActionPerformed(evt);
            }
        });
        jPanel3.add(namaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Harga Beli");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 190, 10));

        hbeliTF.setBorder(null);
        hbeliTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hbeliTFActionPerformed(evt);
            }
        });
        jPanel3.add(hbeliTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 190, 30));

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
        jPanel3.add(krgBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, -1, 30));

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
        jPanel3.add(tbhBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, 30));

        noTF.setBorder(null);
        noTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTFActionPerformed(evt);
            }
        });
        jPanel3.add(noTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 310, 30));
        jPanel3.add(subtotTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 90, 10, 0));

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
        jPanel3.add(cariBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, 30));
        jPanel3.add(stokTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, 0));
        jPanel3.add(ukurTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 0, 0));
        jPanel3.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, 0));
        jPanel3.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 10, 0));
        jPanel3.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 10, 0));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 890, 200));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)), "Keranjang Belanja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 890, 170));

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
        jPanel1.add(tambahBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, -1, 40));

        simpanBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        simpanBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Simpan.png"))); // NOI18N
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
        jPanel1.add(simpanBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 110, 40));

        totalTF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalTF.setText("0");
        totalTF.setBorder(null);
        totalTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTFActionPerformed(evt);
            }
        });
        jPanel1.add(totalTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 250, 40));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 320, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Total   :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 500, 70, 30));
        jPanel1.add(idTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 10, 0));

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

    private void jumlahTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahTFActionPerformed

    private void totalTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTFActionPerformed

    private void namaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTFActionPerformed

    private void hbeliTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hbeliTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hbeliTFActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
         if(noTF.getText().equals("") || supTF.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Lengkapi inputan pembelian barang");
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

    private void noTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noTFActionPerformed

    private void tbhBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbhBrgBTActionPerformed
        // TODO add your handling code here:
         int harga=Integer.parseInt(hbeliTF.getText());
        int jml=Integer.parseInt(jumlahTF.getText());
        int total=Integer.parseInt(totalTF.getText());
        
            int subtot=harga*jml;
            subtotTF.setText(Integer.toString(subtot));
            
            int totbay=total+(harga*jml);
            totalTF.setText(Integer.toString(totbay));
            
            ambildata();
            
        kodeTF.setText("");
        namaTF.setText("");
        hbeliTF.setText("");
        jumlahTF.setText("");
    }//GEN-LAST:event_tbhBrgBTActionPerformed

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

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
         if(tambahBT.getText().equalsIgnoreCase("TAMBAH")){
            tambahBT.setText("BERSIH");
            siapIsi(true);
            bersih();
            otomatis();
            supTF.requestFocus();
            noTF.setEnabled(false);
            simpanBT.setEnabled(true);
            tbhBrgBT.setEnabled(true);
            krgBrgBT.setEnabled(true);
            cariBrgBT.setEnabled(true);
            cariSupBT.setEnabled(true);
        }else{
            bersih();
            siapIsi(false);
            tambahBT.setText("Tambah");
            TabModel.getDataVector().removeAllElements();
            TabModel.fireTableDataChanged();
            tombolNormal();
        }
    }//GEN-LAST:event_tambahBTActionPerformed

    private void cariBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBrgBTActionPerformed
        // TODO add your handling code here:
         boolean closable = true;
         brg1 fDB = new  brg1(null, closable);
        fDB.fAB = this;
        fDB.setVisible(true);
        fDB.setResizable(true);
       
        kodeTF.setText(Kobe);
         namaTF.setText(Naba);
          ukurTF.setText(Ukur);
          hbeliTF.setText(Hargabel);
           stokTF.setText(Stok);
        
           
    }//GEN-LAST:event_cariBrgBTActionPerformed

    private void cariSupBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSupBTActionPerformed
        // TODO add your handling code here:
        boolean closable = true;
         sup fDB = new  sup(null, closable);
        fDB.fAB = this;
        fDB.setVisible(true);
        fDB.setResizable(true);
        idTF.setText(Kosupp);
         supTF.setText(Namsupp);
    }//GEN-LAST:event_cariSupBTActionPerformed

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

    private void cariSupBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariSupBTMouseEntered
        // TODO add your handling code here:
         cariSupBT.setBackground(new Color(102,204,255));
        cariSupBT.setForeground(Color.black);
    }//GEN-LAST:event_cariSupBTMouseEntered

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariBrgBT;
    private javax.swing.JButton cariSupBT;
    private javax.swing.JTextField hbeliTF;
    private javax.swing.JTextField idTF;
    private javax.swing.JTextField j;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jumlahTF;
    private javax.swing.JTextField k;
    private javax.swing.JTextField kodeTF;
    private javax.swing.JButton krgBrgBT;
    private javax.swing.JTextField namaTF;
    private javax.swing.JTextField noTF;
    private javax.swing.JTextField p;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTextField stokTF;
    private javax.swing.JTextField subtotTF;
    private javax.swing.JTextField supTF;
    private javax.swing.JButton tambahBT;
    private javax.swing.JButton tbhBrgBT;
    private com.toedter.calendar.JDateChooser tglTF;
    private javax.swing.JTextField totalTF;
    private javax.swing.JTextField ukurTF;
    // End of variables declaration//GEN-END:variables
 void cetak_nota(){
        try {
            String NamaFile = "src/Laporan/kwitansibeli.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/papantulis","root","");
            HashMap param = new HashMap();
            param.put("notabeli",noTF.getText());
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!","Cetak Data",JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
}
