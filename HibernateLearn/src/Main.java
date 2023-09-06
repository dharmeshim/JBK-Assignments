


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main  {

//    public static SessionFactory provideSessionFactory()
//    {
////        Configuration config = new Configuration();
////        config.configure();
//        return config.buildSessionFactory();
//    }


    public static void main(String[] args) {

        try {
            Configuration config = new Configuration();
            config.configure();
            SessionFactory sf = config.buildSessionFactory();
            getData(sf);
//    		saveData(sf);
//    		updateData(sf);
//            deleteData(sf);

        }
        catch (Exception e) {
            System.out.println("Exception occured"+ e);
        }


    }
    // Save data or insert Data
    public static void  saveData(SessionFactory sf) {

        Logdetails l =new Logdetails( 1,"dpr","dpr1@gmail");

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        session.save(l);
        tr.commit();
        session.close();

    }

    // update Data
    public static void  updateData(SessionFactory sf) {

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Logdetails s1 = session.get(Logdetails.class, 3);
        s1.setName("abc");

        session.save(s1);
        tr.commit();
        session.close();

    }

    //get  Data
    public static void  getData(SessionFactory sf) {

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Logdetails s1 = session.get(Logdetails.class,1);

        System.out.println(s1);
        session.close();

    }


    //Delete Data
    public static void  deleteData(SessionFactory sf) {

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Logdetails s1 = session.get(Logdetails.class,7);

        session.delete(s1);
        session.close();

    }

}