package modele.dao;

import modele.Carnet;
import modele.Contact;

import java.util.ArrayList;

public interface ContactDAO {

    public ArrayList<Contact> load();
    public void save(Contact contact);
    public void saveAll(Carnet carnet);
}
