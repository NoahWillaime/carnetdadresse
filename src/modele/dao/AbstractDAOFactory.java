package modele.dao;

public abstract class AbstractDAOFactory {
    public abstract ContactDAO getContactDAO();

    public static AbstractDAOFactory getDAOFactory(){
        return new ConcreteCSVFactory();
    }
}
