/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PettaInventory;

/**
 *
 * @author MasterPaulo
 */
public class PettaInventory {
    public static MainFrame cashier;
    public static Authenticator authenticater;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*cashier = new MainFrame("hey");
        cashier.preparation();
        cashier.pack();
        cashier.setLocationRelativeTo(null);
        cashier.setVisible(true);*/
        authenticater =new Authenticator();
        authenticater.setVisible(true);
    }
}
