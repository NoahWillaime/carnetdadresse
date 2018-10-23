package controler;


import modele.Carnet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupprimerControler implements ActionListener {
    private Carnet mod;

    public SupprimerControler(Carnet mod){
        this.mod = mod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int val = Integer.parseInt(JOptionPane.showInputDialog("Contact Numero ?"));
            if (val >= mod.getNbContact() || val < 0){
                JOptionPane.showMessageDialog(null, "ID inexistant", "Valeur de case ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                mod.supprimerContact(val);
            }
        } catch (NumberFormatException exeption) {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas rentre un nombre ..", "Valeur de case ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
