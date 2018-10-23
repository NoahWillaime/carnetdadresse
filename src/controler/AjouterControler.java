package controler;

import modele.Carnet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterControler implements ActionListener{
    private Carnet mod;

    public AjouterControler(Carnet mod){
        this.mod = mod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = JOptionPane.showInputDialog("Nom ?", "");
        String prenom = JOptionPane.showInputDialog("Prenom ?", "");
        String adresse = JOptionPane.showInputDialog("Adresse ?", "");
        mod.ajouterContact(nom, prenom, adresse);
    }
}
