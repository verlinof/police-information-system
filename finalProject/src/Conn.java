import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    static Connection con;
    public static  Connection getCon(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projek_akhir","root","");
        }
        catch (Exception ex){
            System.out.println(""+ex);
        }
        return con;
}
}
