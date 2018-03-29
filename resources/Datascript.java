import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.sql.*;
public class Datascript {

    public Datascript(){

    }

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/whats_eat";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            for(int i=1;i<27639;i++){
                String filename = String.format("%05d", i);
                System.out.println(filename);
                Object obj = parser.parse(new FileReader("/Users/bowenjiang/Desktop/Development/food data/Yummly28K" +
                        "/metadata27638/meta"+ filename+ ".json"));

                JSONObject jsonObject = (JSONObject) obj;

                String name = (String) jsonObject.get("name");
                name = name.replaceAll("\"", "");
                name = name.replaceAll("\'", "");

//                int serving = 0;
//                if(jsonObject.get("numberOfServings") != null){
//                    serving = ((Long) jsonObject.get("numberOfServings")).intValue();
//                }


                // loop array
                JSONArray ingredients = (JSONArray) jsonObject.get("ingredientLines");
                Iterator iterator = ingredients.iterator();
                String ingredient = "";
                while (iterator.hasNext()) {
                    ingredient = ingredient + " " + iterator.next();
                    ingredient = ingredient.replaceAll("\"", "");
                    ingredient = ingredient.replaceAll("\'", "");

                }



                JSONArray nutrition = (JSONArray) jsonObject.get("nutritionEstimates");
                Iterator niterator = nutrition.iterator();
                int calories = 0;
                while (niterator.hasNext()) {
                    JSONObject n= (JSONObject) niterator.next();
                    String attr = (String) n.get("attribute");
                    if(attr.equals("ENERC_KCAL")) {
                        calories = ((Double) n.get("value")).intValue();
                    }

                }

//                System.out.println(serving);
//
//                if(serving>0) calories/=serving;



                System.out.println(calories);

                stmt = conn.createStatement();
                String sql = String.format("insert into Food values(Null, '%s', %d, '%s')",
                        name,
                        calories,
                        ingredient);
                stmt.executeUpdate(sql);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}