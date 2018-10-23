package modele;

import modele.dao.AbstractDAOFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Carnet extends Observable implements Iterable<Contact>{
    private ArrayList<Contact> listContacts;

    public Carnet(){
        this.listContacts = new ArrayList<Contact>();
    }

    public void ajouterContact(String nom, String prenom, String adresse){
        Contact contact = new Contact(nom, prenom, adresse);
        this.listContacts.add(contact);
        setChanged();
        notifyObservers();
    }

    public void modifierContact(int ID, String nom, String prenom, String adresse){
        Contact c = listContacts.get(ID);
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setAdresse(adresse);
        setChanged();
        notifyObservers();
    }

    public String getNom(int id){
        return listContacts.get(id).getNom();
    }

    public String getPrenom(int id){
        return listContacts.get(id).getPrenom();
    }

    public String getAdresse(int id){
        return listContacts.get(id).getAdresse();
    }

    public void supprimerContact(int ID){
        listContacts.remove(ID);
        setChanged();
        notifyObservers();
    }

    public int getNbContact(){
        return listContacts.size();
    }

    public void load(){
        listContacts = AbstractDAOFactory.getDAOFactory().getContactDAO().load();
        setChanged();
        notifyObservers();
    }

    public void saveAll(){
        AbstractDAOFactory.getDAOFactory().getContactDAO().saveAll(this);
    }

    @Override
    public Iterator iterator() {
        return listContacts.iterator();
    }
}
