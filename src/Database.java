import javax.swing.*;
import java.sql.*;

public class Database {

	static String loginUsername(){
		return JOptionPane.showInputDialog(null, "Enter username", "Username", JOptionPane.QUESTION_MESSAGE);
	}

	static String loginPassword() {
		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setEchoChar('*');
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Password: "));
		myPanel.add(passwordField);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			return String.valueOf(passwordField.getPassword());
		}
		return null;

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
		createConnection();

}



}
