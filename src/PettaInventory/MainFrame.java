/**
 * MainFrame.java
 * acts as the main menu of an inventory system
 * imports are loaded from an external text file
 */
package PettaInventory;

import java.awt.event.ItemEvent;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *  Hyperion Production
 * @author MasterPaulo
 */
public class MainFrame extends javax.swing.JFrame {

    private String[] listData = {"Master", "Petta", "Hyperion"}; //visible names in the list
    private ArrayList<InventoryItem> products = new ArrayList<>();//current items in process
    private ArrayList<InventoryItem> cart = new ArrayList<>();
    private ArrayList<InventoryItem> Imports = new ArrayList<>(); //holds a general copy of all items
    public int numberOfItems = 0; //total number of items / size of Imports[]
    javax.swing.DefaultComboBoxModel boxMdl = new javax.swing.DefaultComboBoxModel();
    javax.swing.DefaultListModel listMdl = new javax.swing.DefaultListModel();
    
    public InventoryItem returner=null;

    //public static EditMenu editor=null;
    public CartMenu carter=new CartMenu();;
    private Credits creditor= new Credits();
    private Authors author = new Authors();
    //public static PreviewMenu viewer=null;
    //public staticBuyMenu buyer =null;
    
    public MainFrame(String title) {
        super(title);
        initComponents();
        String laf = UIManager.getSystemLookAndFeelClassName();
        try{
        UIManager.setLookAndFeel("com.sun.java.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){}
    }

    //FAIL ... a method that is equivalent to JList.setListData
    public void loadList(Object[] names) {
        listMdl.clear();
        for (int i = 0; i < names.length; i++) {
            listMdl.addElement(names[i]);
        }
        Listers.setModel(listMdl);

    }

    public void preparation() {
        importItems();
        listData = updateListData(0);
        //loadList(listData);
        Listers.setListData(listData);
    }

    /**
     * imports Inventory Items from txt file.
     * text file must be within the directory of the MainFrame class
     * or the jar file.
     * default text file is titled "items.txt"
     * 
     */
    public void importItems() {
        ArrayList<InventoryItem> array = new ArrayList<>();
        Scanner fin;
        try {
            //D:\\Program files\\JAVA Projects\\PettaInventory\\src\\PettaInventory\\items.txt
            fin = new Scanner(new File("items.txt"));
        } catch (Exception e) {
            System.out.println("Invalid File");
            return;
        }
        String line[];
        int i = 0;
        while (fin.hasNext()) {
            line = fin.nextLine().split(" ");
            //array[i] = new InventoryItem(line);
            array.add(new InventoryItem(line));
            //array[i].setItemNumber(i);
            array.get(i).setItemNumber(i);
            i++;
        }
        numberOfItems = i;
        Imports = array;
        fin.close();
    }
    
    public void exportItems(){
        java.io.PrintWriter outFile;
        int code;
        String name;
        String img;
        double price;
        int stock;
        int qty;
        try{
            outFile = new java.io.PrintWriter(new java.io.FileWriter("items.txt"));
        }catch(Exception e){ return; }
        for(int i=0 ; i< Imports.size() ; i++){
            code = Imports.get(i).getItemCode();
            name = Imports.get(i).getItemName().replace(' ', '_');
            img = Imports.get(i).getItemImage().replace(' ', '_');
            price = Imports.get(i).getItemPrice();
            stock = Imports.get(i).getItemStock();
            qty = Imports.get(i).getItemQuantity();
            outFile.println(String.format("%d %s %s %.2f %d %d",code, name, img, price, stock, qty));
        }
        outFile.close();
    }
    //resets numbering after removing or adding items
    public void setNumbering(){
        int i;
        for( i=0;i<Imports.size();i++)
            Imports.get(i).setItemNumber(i);
        numberOfItems = i;
    }
    /**
     * method to get listData ... 
     * returns an array of string to represent the updated list data
     * from ArrayList <products>
     * 
     */
    public String[] updateListData(int code) {
        products.clear();
        if(code!=16)
        for (int i = 0; i < Imports.size(); i++) {
            if (Imports.get(i).getItemCode() == code) {
                products.add(Imports.get(i));
            }

        }
        else
        for (int i = 0; i < Imports.size(); i++) {
                products.add(Imports.get(i));
        }
        numberOfItems=Imports.size();
        //creates String array to hold the names shown in the updated list
        //the names represent the real ListData of type 'InventoryItem'
        String[] data = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            data[i] = String.format("%4d   %s",i+1,products.get(i).getItemName());
        }
        return data;
    }
    /**
     * updates list <Listers> in mainframe
     * ... also called by external methods
     */
    public void updateList(){
        if(returner!=null){
            int i = returner.getItemNumber();
            if(i==numberOfItems)
                Imports.add(returner);
            else
                Imports.set(i,returner);
        }
        returner=null;
        int code = itemTypeBox.getSelectedIndex();
        listData = updateListData(code);
        Listers.setListData(listData);
        //Listers.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitBUtton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Listers = new javax.swing.JList();
        itemTypeBox = new javax.swing.JComboBox();
        IDPanel = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        inStockLabel = new javax.swing.JLabel();
        InStockLabel = new javax.swing.JLabel();
        buyPanel = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();
        previewButton = new javax.swing.JButton();
        viewCartButton = new javax.swing.JButton();
        optionPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        importButton = new javax.swing.JButton();
        iconAdd = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        editBUtton = new javax.swing.JButton();
        iconEdit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        delButton = new javax.swing.JButton();
        iconDel = new javax.swing.JLabel();
        secretPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        creditsMenu = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/"+Authenticator.icon)));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        exitBUtton.setText("Exit");
        exitBUtton.setToolTipText("");
        exitBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBUttonActionPerformed(evt);
            }
        });

        jScrollPane1.setFocusable(false);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(210, 300));

        Listers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Listers.setToolTipText("List of items in inventory");
        Listers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Listers);

        itemTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPU", "RAM", "HDD", "MAINBOARD", "GCARD", "ROM", "MODEM", "LANCARD", "CASE", "KEYBOARD", "MOUSE", "SPEAKERS", "MONITOR", "PRINTER", "SCANNER", "OTHERS", "All" }));
        itemTypeBox.setToolTipText("Item Types");
        itemTypeBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemTypeBoxItemStateChanged(evt);
            }
        });
        itemTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypeBoxActionPerformed(evt);
            }
        });

        IDPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        priceLabel.setText("PRICE : ");
        priceLabel.setToolTipText("");

        PriceLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PriceLabel.setText("0.00");

        inStockLabel.setText("IN STOCK : ");

        InStockLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        InStockLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        InStockLabel.setText("0");

        javax.swing.GroupLayout IDPanelLayout = new javax.swing.GroupLayout(IDPanel);
        IDPanel.setLayout(IDPanelLayout);
        IDPanelLayout.setHorizontalGroup(
            IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IDPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IDPanelLayout.createSequentialGroup()
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                    .addGroup(IDPanelLayout.createSequentialGroup()
                        .addComponent(inStockLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InStockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        IDPanelLayout.setVerticalGroup(
            IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IDPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceLabel)
                    .addComponent(PriceLabel))
                .addGroup(IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inStockLabel)
                    .addComponent(InStockLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BUY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buyButton.setMnemonic('Q');
        buyButton.setText("Quick Buy");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        cartButton.setMnemonic('A');
        cartButton.setText("Add to Cart");
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buyPanelLayout = new javax.swing.GroupLayout(buyPanel);
        buyPanel.setLayout(buyPanelLayout);
        buyPanelLayout.setHorizontalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buyPanelLayout.setVerticalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartButton)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "VIEW"));

        previewButton.setMnemonic('P');
        previewButton.setText("Preview");
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        viewCartButton.setMnemonic('C');
        viewCartButton.setText("View Cart");
        viewCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(previewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewCartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewButton)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        optionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Options"));

        importButton.setMnemonic('I');
        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        iconAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addIcon2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(iconAdd)
                .addGap(17, 17, 17)
                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(importButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(iconAdd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADD", jPanel1);

        editBUtton.setMnemonic('E');
        editBUtton.setText("Edit");
        editBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBUttonActionPerformed(evt);
            }
        });

        iconEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editIcon3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(editBUtton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(editBUtton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(iconEdit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EDIT", jPanel3);

        delButton.setMnemonic('D');
        delButton.setText("Delete");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        iconDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delIcon1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconDel)
                .addGap(18, 18, 18)
                .addComponent(delButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(delButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(iconDel)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DEL", jPanel2);

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        secretPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                secretPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout secretPanelLayout = new javax.swing.GroupLayout(secretPanel);
        secretPanel.setLayout(secretPanelLayout);
        secretPanelLayout.setHorizontalGroup(
            secretPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        secretPanelLayout.setVerticalGroup(
            secretPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        openMenu.setText("Open resource");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setText("Save & Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        jMenuBar1.add(fileMenu);

        About.setText("Help");

        jMenuItem4.setText("Help Contents");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        About.add(jMenuItem4);

        jMenu1.setText("About");

        creditsMenu.setText("Credits");
        creditsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsMenuActionPerformed(evt);
            }
        });
        jMenu1.add(creditsMenu);

        aboutMenu.setText("About Inventory");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        jMenu1.add(aboutMenu);

        About.add(jMenu1);

        jMenuBar1.add(About);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(secretPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBUtton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(secretPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(itemTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(IDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(exitBUtton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBUttonActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_exitBUttonActionPerformed

    private void itemTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypeBoxActionPerformed
    }//GEN-LAST:event_itemTypeBoxActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        new EditMenu().setVisible(true);
    }//GEN-LAST:event_importButtonActionPerformed

    private void itemTypeBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemTypeBoxItemStateChanged
        updateList();
    }//GEN-LAST:event_itemTypeBoxItemStateChanged

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        int index = Listers.getSelectedIndex();
        if (index >= 0) {
            if(products.get(index).getItemStock()>0){
                new BuyMenu(products.get(index)).setVisible(true);
            }
            else
                javax.swing.JOptionPane.showMessageDialog(null, "Out of stock");
        }
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
    }//GEN-LAST:event_buyButtonActionPerformed

    private void editBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBUttonActionPerformed
        int index = Listers.getSelectedIndex();
        if (index >= 0 ) {
            new EditMenu(products.get(index)).setVisible(true);
        }
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
    }//GEN-LAST:event_editBUttonActionPerformed

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        int index = Listers.getSelectedIndex();
        if (index >= 0) {
            PreviewMenu viewer = new PreviewMenu(products.get(index));
            //viewer.setLocationRelativeTo(null);
            viewer.setVisible(true);
        }
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
    }//GEN-LAST:event_previewButtonActionPerformed

    private void ListersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListersValueChanged
        int i = Listers.getSelectedIndex();
        double price=0;
        int qua=0;
        if(i>=0){
            price = products.get(i).getItemPrice();
            qua = products.get(i).getItemStock();
        }
        PriceLabel.setText(String.format("%10.2f", price));
        InStockLabel.setText(String.format("%10d", qua));
    }//GEN-LAST:event_ListersValueChanged

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        int index = Listers.getSelectedIndex();
        if (index >= 0) {
            if(products.get(index).getItemStock()>0){
                if(carter.counter==null || !carter.counter.isVisible())
                    carter.promptQty(products.get(index));
            }
            else
                javax.swing.JOptionPane.showMessageDialog(null, "Out of stock");
        }
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
    }//GEN-LAST:event_cartButtonActionPerformed

    private void viewCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCartButtonActionPerformed
            carter.setVisible(true);
    }//GEN-LAST:event_viewCartButtonActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        int index = Listers.getSelectedIndex();
        if (index >= 0)
            Imports.remove(products.get(index).getItemNumber());                
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
        setNumbering();
        updateList();
        Listers.setSelectedIndex(index);
    }//GEN-LAST:event_delButtonActionPerformed

    private void secretPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secretPanelMouseClicked
        if(evt.getButton() == 2)
            new Secrets.Dedication().setVisible(true);
    }//GEN-LAST:event_secretPanelMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        exportItems();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        exportItems();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void creditsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsMenuActionPerformed
        author.setVisible(true);
    }//GEN-LAST:event_creditsMenuActionPerformed

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        creditor.setVisible(true);
    }//GEN-LAST:event_aboutMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        javax.swing.JOptionPane.showMessageDialog(null,"Sorry, this function is not available in the current version","Notice",0);
    }//GEN-LAST:event_openMenuActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        javax.swing.JOptionPane.showMessageDialog(null,"Sorry, this function is not available in the current version","Notice",0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JPanel IDPanel;
    private javax.swing.JLabel InStockLabel;
    private javax.swing.JList Listers;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JButton buyButton;
    private javax.swing.JPanel buyPanel;
    private javax.swing.JButton cartButton;
    private javax.swing.JMenuItem creditsMenu;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editBUtton;
    private javax.swing.JButton exitBUtton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel iconAdd;
    private javax.swing.JLabel iconDel;
    private javax.swing.JLabel iconEdit;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel inStockLabel;
    private javax.swing.JComboBox itemTypeBox;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton previewButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel secretPanel;
    private javax.swing.JButton viewCartButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
