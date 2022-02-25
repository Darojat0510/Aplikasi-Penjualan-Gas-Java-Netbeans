
package aplikasipenjualangas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author TOSHIBA DC
 */
public final class menuutama extends javax.swing.JFrame {
    String nama = login.getU_nama();
     int banyakBarang = 0;

     Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form menuutama
     */
    public menuutama() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        
        userJL.setText(nama);
        setIcon();
        tanggal();
        jam();
        jumlahTerjual();
        banyakbarang();
         totalPendapatan();
        jamtanggal();
       
        
    }
    
    //tanggal
    public void tanggal(){
        Date skrg = new Date();
        SimpleDateFormat format= new SimpleDateFormat("EEEE, dd MMMM yyyy",new java.util.Locale("id"));
        String tgl = format.format(skrg);
        tanggalJl.setText(format.format(skrg));
    }
    public void hakAksesPemilik(){
        
    }
    
    public void hakAksespetugas(){
         pengguna.setEnabled(false);
          belibtn.setEnabled(false);
           beli.setEnabled(false);
            brgbtn.setEnabled(false);
             brg.setEnabled(false);
              lpbeli.setEnabled(false);
               lpbrg.setEnabled(false);
         homeBT.setEnabled(false);
         
        
        
    }
    
    public void hakAksesPersediaan(){
        jualbtn.setEnabled(false);
         belibtn.setEnabled(false);
        brg.setEnabled(false);
      
        pengguna.setEnabled(false);
          lpjual.setEnabled(false);
        lpbeli.setEnabled(false);
        jual.setEnabled(false);
        beli.setEnabled(false);
         homeBT.setEnabled(false);
        
       
       
    }
     public void jumlahTerjual() {
        setKoneksi();

        try {
            String sql = "SELECT SUM(jumlah) AS totaljumlah FROM penjualan;";
            
//            SELECT SUM(Quantity) AS TotalItemsOrdered FROM OrderDetails;
            ResultSet rs=st.executeQuery(sql);
             rs = st.executeQuery(sql); 
           
            rs.next();
            barangTF.setText(rs.getString(1));
             banyakBarang = Integer.parseInt(rs.getString(1));
           

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void totalPendapatan() {
       
setKoneksi();
        try {
            String sql = "SELECT SUM(subtot) AS totalPendapatan FROM penjualan;";
            ResultSet rs=st.executeQuery(sql);
             rs = st.executeQuery(sql); 

            rs.next();

            totalTF.setText(String.valueOf(rs.getString(1)));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void banyakbarang() {
       
setKoneksi();
        try {
            String sql = "SELECT count(namabarang) AS nama FROM barang;";
            ResultSet rs=st.executeQuery(sql);
             rs = st.executeQuery(sql); 

            rs.next();

            brgTF.setText(String.valueOf(rs.getString(1)));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setIcon() {
          ImageIcon img = new ImageIcon("src/gambar/WhatsApp Image 2021-07-04 at 20.43.42.jpeg");
        setIconImage(img.getImage());
    }
     private void jamtanggal() {
           DateFormat tgl=new SimpleDateFormat("dd MMMM yyyy");
        DateFormat waktu=new SimpleDateFormat("HH:mm:ss");
        String htgl=tgl.format(Calendar.getInstance().getTime());
        String hwaktu=waktu.format(Calendar.getInstance().getTime());
        tanggal.setText(htgl+" - "+hwaktu); 
     }
    
    
    public void jam(){
        ActionListener taskPerformer = new ActionListener() {
            
    public void actionPerformed(ActionEvent evt) {
        String nol_jam = "", nol_menit = "",nol_detik = "";
        java.util.Date dateTime = new java.util.Date();
        int nilai_jam = dateTime.getHours();
        int nilai_menit = dateTime.getMinutes();
        int nilai_detik = dateTime.getSeconds();
        if(nilai_jam <= 9) nol_jam= "0";
        if(nilai_menit <= 9) nol_menit= "0";
        if(nilai_detik <= 9) nol_detik= "0";
        String waktu = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        jam.setText(waktu+":"+menit+":"+detik+"");
    }
        };
        new Timer(1000, taskPerformer).start();
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
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jualbtn = new javax.swing.JButton();
        keluarbtn = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        homeBT = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        belibtn = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        brgbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tanggalJl = new javax.swing.JLabel();
        dp = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        tanggal = new javax.swing.JLabel();
        userJL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        barangTF = new javax.swing.JTextField();
        p = new javax.swing.JPanel();
        brgTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        totalTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        data = new javax.swing.JMenu();
        brg = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        pengguna = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jual = new javax.swing.JMenuItem();
        beli = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        lpbrg = new javax.swing.JMenuItem();
        lpbeli = new javax.swing.JMenuItem();
        lpjual = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 10, 80));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 10, 80));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 10, 80));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 10, 80));

        jualbtn.setBackground(new java.awt.Color(204, 204, 255));
        jualbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jualbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Penjualan.gif"))); // NOI18N
        jualbtn.setText("Penjualan");
        jualbtn.setToolTipText("klik untuk menambahkan data transaksi penjualan");
        jualbtn.setFocusable(false);
        jualbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jualbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jualbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jualbtnMouseEntered(evt);
            }
        });
        jualbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jualbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jualbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 80));

        keluarbtn.setBackground(new java.awt.Color(204, 204, 255));
        keluarbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        keluarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Hapus.png"))); // NOI18N
        keluarbtn.setText("Logout");
        keluarbtn.setToolTipText("klik untuk logout");
        keluarbtn.setFocusable(false);
        keluarbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        keluarbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        keluarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keluarbtnMouseEntered(evt);
            }
        });
        keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarbtnActionPerformed(evt);
            }
        });
        jPanel2.add(keluarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 90, 80));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 80));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 10, 80));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 10, 80));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 10, 80));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 10, 80));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 10, 80));

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 10, 80));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jam        :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 100, -1));

        jam.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 220, 30));

        homeBT.setBackground(new java.awt.Color(204, 204, 255));
        homeBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        homeBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home-icon.png"))); // NOI18N
        homeBT.setText("Home");
        homeBT.setToolTipText("klik untuk menambahkan data transaksi pembelian");
        homeBT.setFocusable(false);
        homeBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeBT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBTMouseEntered(evt);
            }
        });
        homeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBTActionPerformed(evt);
            }
        });
        jPanel2.add(homeBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 80));

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 10, 80));

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 10, 80));

        belibtn.setBackground(new java.awt.Color(204, 204, 255));
        belibtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        belibtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_transaction_55px.png"))); // NOI18N
        belibtn.setText("Pembelian");
        belibtn.setToolTipText("klik untuk menambahkan data transaksi pembelian");
        belibtn.setFocusable(false);
        belibtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        belibtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        belibtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                belibtnMouseEntered(evt);
            }
        });
        belibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                belibtnActionPerformed(evt);
            }
        });
        jPanel2.add(belibtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 80));

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 10, 80));

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, 80));

        brgbtn.setBackground(new java.awt.Color(204, 204, 255));
        brgbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        brgbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_input_55px.png"))); // NOI18N
        brgbtn.setText("Barang");
        brgbtn.setToolTipText("klik untuk menambahkan data barang");
        brgbtn.setFocusable(false);
        brgbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        brgbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        brgbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                brgbtnMouseEntered(evt);
            }
        });
        brgbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brgbtnActionPerformed(evt);
            }
        });
        jPanel2.add(brgbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 80));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tanggal :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        tanggalJl.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        tanggalJl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(tanggalJl, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 220, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1160, 80));

        dp.setBackground(new java.awt.Color(255, 255, 255));
        dp.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tanggal.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jPanel4.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 142, 343, 29));

        userJL.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jPanel4.add(userJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 56, 355, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("Welcome  :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 53, 144, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setText("Login        :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 142, 144, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Barang Terjual");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        barangTF.setBackground(new java.awt.Color(102, 102, 255));
        barangTF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        barangTF.setForeground(new java.awt.Color(255, 255, 255));
        barangTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        barangTF.setText("0");
        barangTF.setBorder(null);
        jPanel9.add(barangTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 277, 290, 100));

        p.setBackground(new java.awt.Color(102, 204, 255));
        p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pMouseExited(evt);
            }
        });
        p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        brgTF.setBackground(new java.awt.Color(102, 204, 255));
        brgTF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        brgTF.setForeground(new java.awt.Color(255, 255, 255));
        brgTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        brgTF.setText("0");
        brgTF.setBorder(null);
        brgTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brgTFActionPerformed(evt);
            }
        });
        p.add(brgTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Banyak Barang");
        p.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPanel4.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 277, 290, 100));

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total penjualan");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        totalTF.setBackground(new java.awt.Color(0, 153, 153));
        totalTF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalTF.setForeground(new java.awt.Color(255, 255, 255));
        totalTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        totalTF.setText("0");
        totalTF.setBorder(null);
        jPanel10.add(totalTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 230, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rp");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 277, 290, 100));

        dp.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(dp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1160, 570));

        jMenu1.setText("File");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        data.setText("Data Master");

        brg.setText("Data Barang");
        brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brgActionPerformed(evt);
            }
        });
        data.add(brg);

        jMenuItem3.setText("Data Supplier");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        data.add(jMenuItem3);

        pengguna.setText("Data Pengguna");
        pengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penggunaActionPerformed(evt);
            }
        });
        data.add(pengguna);

        jMenuBar1.add(data);

        jMenu3.setText("Data Transaksi");

        jual.setText("Data Penjualan");
        jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jualActionPerformed(evt);
            }
        });
        jMenu3.add(jual);

        beli.setText("Data Pembelian");
        beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliActionPerformed(evt);
            }
        });
        jMenu3.add(beli);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Laporan");

        lpbrg.setText("Laporan Barang");
        lpbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpbrgActionPerformed(evt);
            }
        });
        jMenu4.add(lpbrg);

        lpbeli.setText("Laporan Pembelian");
        lpbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpbeliActionPerformed(evt);
            }
        });
        jMenu4.add(lpbeli);

        lpjual.setText("Laporan Penjualan");
        lpjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpjualActionPerformed(evt);
            }
        });
        jMenu4.add(lpjual);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Peratuaran");

        jMenuItem10.setText("Ganti Password");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("Help");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("About");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu6MouseEntered(evt);
            }
        });

        jMenuItem12.setText("Tentang Aplikasi");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void belibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_belibtnActionPerformed
        // TODO add your handling code here:
        pembelian b= new pembelian();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
        
    }//GEN-LAST:event_belibtnActionPerformed

    private void keluarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarbtnActionPerformed
        // TODO add your handling code here:
        login h=new login();
        h.setLocationRelativeTo(null);
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_keluarbtnActionPerformed

    private void jualbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jualbtnActionPerformed
        // TODO add your handling code here:
         penjualan b= new penjualan();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jualbtnActionPerformed

    private void brgbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brgbtnActionPerformed
        // TODO add your handling code here:
         barang b= new barang();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_brgbtnActionPerformed

    private void penggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penggunaActionPerformed
        // TODO add your handling code here:
        pengguna b= new pengguna();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_penggunaActionPerformed

    private void lpbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpbeliActionPerformed
        // TODO add your handling code here:
         lppembelian b= new lppembelian();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_lpbeliActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
         gantipassword b= new gantipassword();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void keluarbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarbtnMouseEntered
        // TODO add your handling code here:
         keluarbtn.setBackground(new Color(204,145,226));
        keluarbtn.setForeground(Color.black);
    }//GEN-LAST:event_keluarbtnMouseEntered

    private void belibtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_belibtnMouseEntered
        // TODO add your handling code here:
         belibtn.setBackground(new Color(204,145,226));
        belibtn.setForeground(Color.black);
    }//GEN-LAST:event_belibtnMouseEntered

    private void jualbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jualbtnMouseEntered
        // TODO add your handling code here:
         jualbtn.setBackground(new Color(204,145,226));
        jualbtn.setForeground(Color.black);
    }//GEN-LAST:event_jualbtnMouseEntered

    private void brgbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brgbtnMouseEntered
        // TODO add your handling code here:
         brgbtn.setBackground(new Color(204,145,226));
        brgbtn.setForeground(Color.black);
    }//GEN-LAST:event_brgbtnMouseEntered

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
         supplier b= new supplier();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brgActionPerformed
        // TODO add your handling code here:
         barang b= new barang();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_brgActionPerformed

    private void jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jualActionPerformed
        // TODO add your handling code here:
         penjualan b= new penjualan();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jualActionPerformed

    private void beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliActionPerformed
        // TODO add your handling code here:
        pembelian b= new pembelian();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_beliActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        help b= new help();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void homeBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBTMouseEntered
        // TODO add your handling code here:
         homeBT.setBackground(new Color(204,145,226));
        homeBT.setForeground(Color.black);
    }//GEN-LAST:event_homeBTMouseEntered

    private void homeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBTActionPerformed
        // TODO add your handling code here:
         menuutama a = new menuutama();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_homeBTActionPerformed

    private void lpbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpbrgActionPerformed
        // TODO add your handling code here:
         lpbrg b= new lpbrg();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_lpbrgActionPerformed

    private void lpjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpjualActionPerformed
        // TODO add your handling code here:
         lppenjualan b= new lppenjualan();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_lpjualActionPerformed

    private void brgTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brgTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brgTFActionPerformed

    private void pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pMouseExited

    private void pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_pMouseEntered

    private void jMenu6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseEntered
        // TODO add your handling code here:
         jMenu6.setBackground(new Color(204,145,226));
         jMenu6.setForeground(Color.black);
    }//GEN-LAST:event_jMenu6MouseEntered

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
          about b= new about();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         login b= new login();
       dp.add(b);
       admin d = new admin();
       dp.remove(d);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barangTF;
    private javax.swing.JMenuItem beli;
    private javax.swing.JButton belibtn;
    private javax.swing.JMenuItem brg;
    private javax.swing.JTextField brgTF;
    private javax.swing.JButton brgbtn;
    private javax.swing.JMenu data;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JButton homeBT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jam;
    private javax.swing.JMenuItem jual;
    private javax.swing.JButton jualbtn;
    private javax.swing.JButton keluarbtn;
    private javax.swing.JMenuItem lpbeli;
    private javax.swing.JMenuItem lpbrg;
    private javax.swing.JMenuItem lpjual;
    private javax.swing.JPanel p;
    private javax.swing.JMenuItem pengguna;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel tanggalJl;
    private javax.swing.JTextField totalTF;
    private javax.swing.JLabel userJL;
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
}
