/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PettaInventory;

import java.util.ArrayList;
/**
 *
 * @author MasterPaulo
 */
public class CartMenu extends javax.swing.JFrame {
    public  ArrayList<InventoryItem> cart = new ArrayList<>();
    private int height;
    private static final int width=4;
    private static Object[] header= {"Item Name","Price", "Quantity","Subtotal"};
    Object [][] data;
    
    public QuantityMenu counter;// = new QuantityMenu();
    private PaymentMenu pay;
    private int discount = 0;
    
    public CartMenu() {
        super("Buy");
        initComponents();
        updateTable();

    }
    
    public CartMenu(ArrayList<InventoryItem> cart) {
        super("Buy");
        this.cart=cart;
        this.height=cart.size();
        initComponents();
        updateTable();

    }
    public javax.swing.table.DefaultTableModel updateTableData(){
        height = cart.size();
        data = new Object[height][width];
        //generates table model...
        for(int i=0;i<height;i++){
            String name = cart.get(i).getItemName();
            double price = cart.get(i).getItemPrice();
            int qty = cart.get(i).getItemQuantity();
            double total = price*qty;
            data[i][0]=name;
            data[i][1]=price;
            data[i][2]=qty;
            data[i][3]=total;
        }
        
        
        javax.swing.table.DefaultTableModel modeler = new javax.swing.table.DefaultTableModel(data, header){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
           
        };
        
        
        return modeler;
        
    }
    public void updateTable(){     
        itemTable.setModel(updateTableData());
        itemTable.setColumnSelectionAllowed(false);
        itemTable.setShowHorizontalLines(false);
        itemTable.getTableHeader().setReorderingAllowed(false);
        itemTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                itemTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);
        itemTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemTable.getColumnModel().getColumn(0).setResizable(false);
        itemTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        itemTable.getColumnModel().getColumn(1).setResizable(false);
        itemTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        itemTable.getColumnModel().getColumn(2).setResizable(false);
        itemTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        itemTable.getColumnModel().getColumn(3).setResizable(false);
        itemTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        totalAmountLabel.setText(String.format("%.2f", getTotalAmountDue()));
        ItemLabel.setText(String.format("%d", getTotalQuantity()));
        DiscountLabel.setText(String.format("%d%%",discount));

    }
    
    public double getTotalAmountDue(){
        double total=0;
        int qty = 0;
        for(int i=0;i<cart.size();i++){
            total+=cart.get(i).getItemPrice() *cart.get(i).getItemQuantity();
            qty+=cart.get(i).getItemQuantity();
        }
        if(qty>=10 && qty<=50)
            discount=(qty/10)*5;
        
        return total-((float)discount/100.0)*total;
    }
    public int getTotalQuantity(){
        int qty = 0;
        for(int i=0;i<cart.size();i++){
            qty+=cart.get(i).getItemQuantity();
        }
        return qty;
    }

    public void promptQty(InventoryItem adder){
          counter = new QuantityMenu(adder, QuantityMenu.MAIN_MENU);
          counter.setVisible(true);
    }
    public  void addItem(InventoryItem adder){
        int id=isPresent(adder);
        if(id==-1)
            cart.add(adder);
        else{
            int qty = cart.get(id).getItemQuantity();
            cart.get(id).setItemQuantity(qty);
        }
        PettaInventory.cashier.carter.updateTable();
    }
    
    public  int isPresent(InventoryItem item){
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getItemNumber()==item.getItemNumber())
                return i;
        }
        
        return -1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        removeButton = new javax.swing.JButton();
        buyButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        itemLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalAmountLabel = new javax.swing.JLabel();
        ItemLabel = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();

        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/"+Authenticator.icon)));
        setLocationByPlatform(true);

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Price", "Qty", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.setColumnSelectionAllowed(true);
        itemTable.setShowHorizontalLines(false);
        itemTable.getTableHeader().setReorderingAllowed(false);
        itemTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                itemTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);
        itemTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemTable.getColumnModel().getColumn(0).setResizable(false);
        itemTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        itemTable.getColumnModel().getColumn(1).setResizable(false);
        itemTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        itemTable.getColumnModel().getColumn(2).setResizable(false);
        itemTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        itemTable.getColumnModel().getColumn(3).setResizable(false);
        itemTable.getColumnModel().getColumn(3).setPreferredWidth(50);

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        buyButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buyButton.setText("BUY");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        addButton.setText("Edit Qty");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Summary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(94, 129, 188)));

        itemLabel.setText("No. of Items:");

        discountLabel.setText("Discount:");

        totalLabel.setText("Total Amount Due:");

        totalAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalAmountLabel.setText("0.00");

        ItemLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ItemLabel.setText("0");

        DiscountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DiscountLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemLabel)
                            .addComponent(discountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ItemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(DiscountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemLabel)
                    .addComponent(ItemLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountLabel)
                    .addComponent(DiscountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmountLabel))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, clearButton, removeButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_itemTablePropertyChange
        
    }//GEN-LAST:event_itemTablePropertyChange

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int index = itemTable.getSelectedRow();
        if (index >= 0)
            cart.remove(index);                
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
        updateTable();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
         int index = itemTable.getSelectedRow();
         if(index>=0){
             if(counter==null || !counter.isVisible()){
                 counter = new QuantityMenu(cart.get(index), QuantityMenu.CART_MENU);
                 
             }
             counter.setVisible(true);
         }
         else
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an item");
         updateTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        cart.clear();
        updateTable();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        if(pay==null || !pay.isVisible()){
            pay = new PaymentMenu(getTotalAmountDue(), cart);
            pay.setVisible(true);
        }
    }//GEN-LAST:event_buyButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DiscountLabel;
    private javax.swing.JLabel ItemLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JTable itemTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel totalAmountLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
