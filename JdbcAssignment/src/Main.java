import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false", "root", "root");

        Statement st = con.createStatement();

        getData(st);
//        insertData(st);
//        updateData(st);
//        deleteData(st);

//        Using prepared Statements

        insert(con);
        update(con);
        delete(con);
    }

    public static void getData(Statement statement) throws SQLException {
        String query = "select * from logdetails";
        ResultSet rs = statement.executeQuery(query);

        if (rs == null) {
            System.out.println("Data Not found!");
        } else {
            System.out.println("userid \t username \t email ");
            while (rs.next()) {

                System.out.print(rs.getInt(1) + "\t ");
                System.out.print(rs.getString(2) + "\t ");
                System.out.print(rs.getString(3) + "\n");
            }
        }
    }

    public static void insertData(Statement statement) throws SQLException {

        String query = "insert into logdetails values (2,'alvin','alvin@gmail.com')";
        System.out.println("data is inserted with no. " + statement.executeUpdate(query));

    }

    public static void updateData(Statement st) throws SQLException {

        String query = " UPDATE logdetails SET name='auro' WHERE id=2";
        st.executeUpdate(query);
        System.out.println("data is updated");

    }

    public static void deleteData(Statement st) throws SQLException {

        String query = " Delete from  logdetails  WHERE id =1";
        st.executeUpdate(query);
        System.out.println("data is updated");

    }

    public static void insert(Connection con) throws SQLException {

        String query = "insert into logdetails(name,email) values(?,?);";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, "dpr");
        pst.setString(2, "dpr@gmail");

        pst.executeUpdate(query);
        System.out.println("data inserted");

    }

    public static void update(Connection con) throws SQLException {

        String query = " UPDATE logdetails SET email= ?  WHERE  id = ? ";
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, "auro@gmail.com");
        pst.setInt(2, 2);

        pst.executeUpdate(query);
        System.out.println("data updated");

    }

    public static void delete(Connection con) throws SQLException {

        String query = " Delete from  logdetails  WHERE id =?";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, 2);
        pst.executeUpdate(query);

        System.out.println("data updated");

    }

}
