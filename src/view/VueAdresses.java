package view;

import controler.AjouterControler;
import controler.ModifierControler;
import controler.SupprimerControler;
import modele.Carnet;
import modele.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observer;

public class VueAdresses implements Observer{
    private Carnet mod;
    private JFrame fenetre;
    private JPanel affichage;
    private JPanel buttons;
    private JButton ajouter;
    private JButton supprimer;
    private JButton modifier;
    private JButton sauvegarderTout;
    private JButton charger;
    private JPanel contacts;
    private ArrayList<JLabel> listContacts;

    public VueAdresses(Carnet carnet){
        this.mod = carnet;
        this.mod.addObserver(this);
        buildFrame();
    }

    public void buildFrame(){
        fenetre = new JFrame("Carnet d'adresses");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setPreferredSize(new Dimension(700, 300));

        affichage = new JPanel();
        affichage.setLayout(new BorderLayout());

        contacts = new JPanel();
        listContacts = new ArrayList<>();
        int i = 0;
        for (Contact c : mod){
            JLabel contact = new JLabel();
            contact.setText(i+" : Nom : "+c.getNom()+" - Prenom : "+c.getPrenom()+" - Adresse mail : "+c.getAdresse());
            contacts.add(contact);
            listContacts.add(contact);
            i++;
        }

        buttons = new JPanel();
        ajouter = new JButton("Ajouter un contact");
        ajouter.addActionListener(new AjouterControler(mod));
        supprimer = new JButton("Supprimer un contact");
        supprimer.addActionListener(new SupprimerControler(mod));
        modifier = new JButton("Modifier un contact");
        modifier.addActionListener(new ModifierControler(mod));
        sauvegarderTout = new JButton("Tout sauvegarder");
        sauvegarderTout.addActionListener(e -> {
            mod.saveAll();
        });
        charger = new JButton("Charger contacts");
        charger.addActionListener(e -> {
            mod.load();
        });
        buttons.add(ajouter);
        buttons.add(modifier);
        buttons.add(supprimer);
        buttons.add(sauvegarderTout);
        buttons.add(charger);

        affichage.add(contacts, BorderLayout.CENTER);
        affichage.add(buttons, BorderLayout.SOUTH);
        fenetre.add(affichage);
        fenetre.pack();
        fenetre.setVisible(true);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        int i = 0;
        contacts.removeAll();
        for (Contact c : mod){
            JLabel contact = new JLabel();
            contact.setText(i+" : Nom : "+c.getNom()+" - Prenom : "+c.getPrenom()+" - Adresse mail : "+c.getAdresse());
            contacts.add(contact);
            listContacts.add(contact);
            i++;
        }
        contacts.revalidate();
        contacts.repaint();
    }
}
