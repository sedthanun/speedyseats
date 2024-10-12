package test;
import java.sql.*;
import Database.*;

public class testmain {
    public static void main(String[] args) {
        try {
            ResultSet rs = DBquery.getInstance().getSelect("SELECT * FROM Theatre;");
            while (rs.next()) {
                System.out.println(rs.getString("theatre_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
