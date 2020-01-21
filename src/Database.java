import javax.swing.*;
import java.sql.*;

public class Database {

	static String loginUsername(){
		return JOptionPane.showInputDialog(null, "Enter username", "Username", JOptionPane.QUESTION_MESSAGE);
	}

	static String loginPassword(){
		return JOptionPane.showInputDialog(null, "Enter password", "Password", JOptionPane.QUESTION_MESSAGE);
	}

public static void createConnection() {
	try {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulator", loginUsername(), loginPassword() );

		Statement myStatement = myConnection.createStatement();

		ResultSet myRs = myStatement.executeQuery("SELECT * FROM simulator.ships;");

		while (myRs.next()){
			System.out.println(myRs.getString("name"));
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}

}
public static void main (String[] args){
		//Database.loginUsername();
		//Database.loginPassword();
		createConnection();

}



}
