/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queenciaid.queenciaservice;

/**
 *
 * @author daniel
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.json.JSONArray;
import org.json.JSONObject;

@RestController
public class ServerController{

    dataToDb databaseOperations = new dataToDb();
    public Connection conn = databaseOperations.getRemoteConnection();

    @RequestMapping("/testusers")            //
    public Users testUsers(
                                    @RequestParam(value="firstName") String firstName,
                                    @RequestParam(value="lastName")  String lastName,
                                    @RequestParam(value="phoneNumber") String phoneNumber) throws SQLException
                                    
    {
                      /* ALGORITHM
                            1. Process data received
                            2. Convert to json file (deviceDetails.json) to enable saving to dynamoDB
                            3. Publishing to Endpoints for dashboard (Upande guys)
                            4. Find out how long this method takes to execute; should be optimized to facilitate many transactions concurrently
                            5. 
                     */
         //Processing before saving to DB take place here
        // if (waterLevel <= 90)        // Minimum water level
               //send_SMS_to_clustomer();
              //procesing.Logs(signalStrength, imei, waterLevel, deviceType);   //signalStrength, imei, waterLevel, deviceType
              conn = databaseOperations.getRemoteConnection();
              //databaseOperations.insertDataToDatabase(conn, <>,<>,<>,<>);
                                                
            

               
        return new Users( firstName, lastName ,phoneNumber);    //call back return Json 
                              
                              
    }
    
    
    
    public static void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
      if (e instanceof SQLException) {
        if (ignoreSQLException(((SQLException)e).getSQLState()) == false) {
          e.printStackTrace(System.err);
          System.err.println("SQLState: " + ((SQLException)e).getSQLState());
          System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
          System.err.println("Message: " + e.getMessage());
          Throwable t = ex.getCause();
          while (t != null) {
            System.out.println("Cause: " + t);
            t = t.getCause();
          }
        }
      }
    }
  }
    
    public static boolean ignoreSQLException(String sqlState) {
    if (sqlState == null) {
      System.out.println("The SQL state is not defined!");
      return false;
    }
    // X0Y32: Jar file already exists in schema
    if (sqlState.equalsIgnoreCase("X0Y32"))
      return true;
    // 42Y55: Table already exists in schema
    if (sqlState.equalsIgnoreCase("42Y55"))
      return true;
    return false;
  }
        
     
}
