import modele.Carnet;
import modele.dao.AbstractDAOFactory;
import view.VueAdresses;

public class main {
    public static void main(String args[]){
        Carnet carnet = new Carnet();
        carnet.ajouterContact("Willaime", "Noah", "noah.willaime@adresse.com");
        carnet.ajouterContact("Jean", "Michel", "Masuperadresse@orange.wanadoo");
        new VueAdresses(carnet);
    }
}
