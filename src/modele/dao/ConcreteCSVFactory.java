package modele.dao;

public class ConcreteCSVFactory extends AbstractDAOFactory{
    @Override
    public ContactDAO getContactDAO() {
        return ContactCSVDAO.getInstance();
    }
}
