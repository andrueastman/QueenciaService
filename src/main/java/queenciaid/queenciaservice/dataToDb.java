/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queenciaid.queenciaservice;

/**
 * @author daniel
 */

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class dataToDb {

    final static Logger logger = Logger.getLogger(dataToDb.class);

    public static Connection getRemoteConnection() {
        //System.out.println ("Inside getRemoteConnection()............");
        try {
            //System.out.println ("Now Hitting the database............");
            Class.forName("com.mysql.jdbc.Driver");

            //String jdbcUrl = "";
            String jdbcUrl = "jdbc:mysql://localhost:3306/Queencia?user=<>&password=<>";

            logger.trace("Getting remote connection with connection string from environment variables.");
            //System.out.println ("Getting remote connection with connection string from environment variables.............");
            Connection con = DriverManager.getConnection(jdbcUrl);
            logger.info("Remote connection successful.");
            //System.out.println ("Remote connection successful............");


            return con;
        } catch (ClassNotFoundException e) {
            logger.warn(e.toString());
            System.out.println(e.toString());
            return null;
        } catch (SQLException e) {
            logger.warn(e.toString());
            System.out.println(e.toString());
            return null;
        }
    }

    public void insertDataToDatabase(Connection conn, String imei, double waterLevel, double signalStrength, String deviceType) throws SQLException {
        // To be changed to reflect dbo.table in use
        String sql = "INSERT INTO DeviceData (imei,waterLevel,signalStrength,deviceType) VALUES(?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, imei);
        pstmt.setDouble(2, waterLevel);
        pstmt.setDouble(3, signalStrength);
        pstmt.setString(4, deviceType);
        pstmt.executeUpdate();
    }


    public void insertSMSDeviceDataintoDatabase(Connection conn, String shortCode, String message, String linkId, String dateGeneratedOnDevice, String devicePhoneNumber) throws SQLException {

        // To be changed to reflect dbo.table in use
        String sql = "INSERT INTO DeviceDataSMS (shortCode,message,linkId,dateGeneratedOnDevice,devicePhoneNumber) VALUES(?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, shortCode);
        pstmt.setString(2, message);
        pstmt.setString(3, linkId);
        pstmt.setString(4, dateGeneratedOnDevice);
        pstmt.setString(5, devicePhoneNumber);
        pstmt.executeUpdate();
    }

    // Pieces of SMS data
    public void insertSMSProcessedDataToDatabase(Connection conn, double waterLevel) throws SQLException {
        // To be changed to reflect dbo.table in use
        String sql = "INSERT INTO DeviceData (waterLevel) VALUES(?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, waterLevel);
        pstmt.executeUpdate();
    }

}
