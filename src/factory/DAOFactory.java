package factory;

import dao.*;
        import dao.proxy.*;
public class DAOFactory {

    public static IStuDAO getIStuDAOInstance() throws  Exception{
        return new StuDAOProxy();
    }

    public static ILoginDAO getILoginDAOInstance() throws Exception{
        return new LoginDAOProxy();
    }

    public static IDocBorDAO getIDocBorDAOInstance() throws Exception{
        return new DocBorDAOProxy();
    }

    public static IBookDAO getIBookDAOInstance()  throws  Exception{
        return new BookDAOProxy();
    }

}
