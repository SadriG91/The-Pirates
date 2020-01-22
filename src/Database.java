import javax.swing.*;
import java.sql.*;
import java.util.Objects;

public class Database {

	private static String username;
	private static String password;

	static void loginUsername(){
		username = JOptionPane.showInputDialog(null, "Enter username", "Username", JOptionPane.QUESTION_MESSAGE);
		//return username;
	}

public static void loginPassword() {
		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setEchoChar('*');
		passwordField.getCursor();
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Password: "));
		myPanel.add(passwordField);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			password = String.valueOf(passwordField.getPassword());
			//return password;
		}
		//return null;

	}

public static Connection createConnection() {
//boolean connected ;
	try {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/simulator", username, password);

	} catch (SQLException e) {
		e.printStackTrace();
	}
//	connected = true;
	return null;

}


		public static void statement(String query) {
			{
				try {
					Statement myStatement = Objects.requireNonNull(createConnection()).createStatement();
					ResultSet myRs = myStatement.executeQuery(query);
					while (myRs.next()) {
						System.out.println(myRs.getString("name"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}



public static void main (String[] args){
		loginUsername();
		loginPassword();
		createConnection();
		statement("Select * from ships");

}



}
