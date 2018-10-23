package controler;

import modele.Carnet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierControler implements ActionListener{
    private Carnet mod;

    public ModifierControler(Carnet mod){
        this.mod = mod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int val = Integer.parseInt(JOptionPane.showInputDialog("Contact Numero ?"));
            if (val >= mod.getNbContact() || val < 0){
                JOptionPane.showMessageDialog(null, "ID inexistant", "Valeur de case ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String nom = JOptionPane.showInputDialog("Nom ?", mod.getNom(val));
                String prenom = JOptionPane.showInputDialog("Prenom ?", mod.getPrenom(val));
                String adresse = JOptionPane.showInputDialog("Adresse ?", mod.getAdresse(val));
                mod.modifierContact(val, nom, prenom, adresse);
            }
        } catch (NumberFormatException exeption) {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas rentre un nombre ..", "Valeur de case ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
