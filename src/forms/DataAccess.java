/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import com.mysql.jdbc.Driver;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.*;

/**
 *
 * @author pooja
 */
public class DataAccess {

    public static final String url1 = "jdbc:mysql://localhost:3306/dbmygym";

    public static final String USER = "root";

    public static final String PASS = "root";
    public static  Connection con;
    public static Connection getConnection() throws SQLException {

        try {
            return DriverManager.getConnection(url1, USER, PASS);

        } catch (SQLException ex) {
            System.out.println(ex);

                    DriverManager.registerDriver(new Driver());
}
        return null;

    }

   

   

    public static void dbConnect() throws SQLException {
        try {

           
          con = getConnection();
        } catch (Exception ex) {

        }
    }

    public void dbClose() {
        try {
            con.close();
        } catch (Exception ex) {
            JOptionPane.showInputDialog(ex, "Error in dbClose");
        }

    }

    public void EnterOnlyNumber(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            return;
        }
        
    }

    public void EnterOnlyDate(KeyEvent evt){
      DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
      JFormattedTextField today = new JFormattedTextField(dateFormat);
      today.setName("Today");
      today.setColumns(10);
      today.setEditable(false);
      JLabel todayLabel = new JLabel("Date:");
      todayLabel.setLabelFor(today);
      today.setValue(new Date());        
    }
    public void EnterOnlycharacter(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
    }

    public void ValidContactNumber(JTextField txt) {
        if (txt.getText().length() != 10) {

            JOptionPane.showMessageDialog(null, "Enter Valid Mobile No....", "Valid Mobile No...", JOptionPane.WARNING_MESSAGE);
            // txt.setText("");
            txt.requestFocus();
        }
    }

    public void ValidEmailAddress(JTextField txt) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        if (Pattern.matches(ePattern, txt.getText())) {
            java.util.regex.Matcher m = p.matcher(txt.getText());

        } else {
            
            txt.setText("");
            JOptionPane.showMessageDialog(null, "Enter Valid Email....", "Valid Email...", JOptionPane.WARNING_MESSAGE);
            txt.requestFocus();
        }
    }

    private int flag = 0;
    private int bkSpace = 0;

    public boolean isDot(String str) {
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                val = 1;
                break;
            }
        }
        if (val == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void EnterFloating(java.awt.event.KeyEvent evt, JTextField txt) {
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String curVal = txt.getText().trim();
        // If '.' is encountered for the first time, the flag is incremented  by 2.
        if (c == '.') {
            flag = flag + 2;
        }
        Character cc = new Character(c);
        // Get the Numeric Value from the Character and checking the condition for flag to be 1.
        if ((cc.getNumericValue(c) == -1) && (flag > 1)) {
            // Pass the value of the text as a String to the method isDot and if true (dot is already there),
            // if it is false (dot is not there) set the value back to 0 to allow the user to enter dot again.
            if (!(isDot(curVal))) {
                flag = 0;
            }
        }
        // This will allow the user to enter the numbers as well as dot.
        if (!(((c >= '0' && c <= '9')) || (c == '.') || bkSpace == 1)) {
            evt.consume();
        } else {
            // If the flag is greater than 1 then the dot is not allowed.
            if (flag > 1) {
                if ((c == '.')) {
                    evt.consume();
                }
            }
        }
    }

    public void EnterFloating(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


//driver code  

 public static void main(String[] args) throws SQLException 
    {
        dbConnect();
}
}

