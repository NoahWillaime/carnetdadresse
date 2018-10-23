package modele.dao;

import modele.Carnet;
import modele.Contact;

import java.io.*;
import java.util.ArrayList;

public class ContactCSVDAO implements ContactDAO {
    private static ContactCSVDAO instance = null;

    public static ContactDAO getInstance(){
        if (instance == null){
            instance = new ContactCSVDAO();
        }
        return instance;
    }


    @Override
    public ArrayList<Contact> load() {
        BufferedReader br = null;
        String line = "";
        //séparateur du CSV
        String csvSeparator = ",";
        ArrayList<Contact> listContact = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("output.csv"));
            while ((line = br.readLine()) != null) {
                String[] contacts = line.split(csvSeparator);
                listContact.add(new Contact(contacts[0], contacts[1], contacts[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listContact;
    }

    @Override
    public void save(Contact contact) {
        try {
            FileWriter writer = new FileWriter("output.csv");

            String csvSeparator = ",";

            writer.append(contact.getNom());
            writer.append(csvSeparator);
            writer.append(contact.getPrenom());
            writer.append(csvSeparator);
            writer.append(contact.getAdresse());
            writer.append('\n');

            writer.flush();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAll(Carnet carnet) {
        try {
            FileWriter writer = new FileWriter("output.csv");

            String csvSeparator = ",";

            for (Contact contact : carnet) {
                writer.append(contact.getNom());
                writer.append(csvSeparator);
                writer.append(contact.getPrenom());
                writer.append(csvSeparator);
                writer.append(contact.getAdresse());
                writer.append('\n');
            }

            writer.flush();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
