import java.sql.*;

public class Database {
	/*
	 * private static String username; private static String password;
	 * 
	 * static void loginUsername() { username = JOptionPane.showInputDialog(null,
	 * "Enter username", "Username", JOptionPane.QUESTION_MESSAGE); // return
	 * username; }
	 * 
	 * public static void loginPassword() { JPasswordField passwordField = new
	 * JPasswordField(10); passwordField.setEchoChar('*'); JPanel myPanel = new
	 * JPanel(); myPanel.add(new JLabel("Password: ")); myPanel.add(passwordField);
	 * 
	 * int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter Password",
	 * JOptionPane.OK_CANCEL_OPTION); if (result == JOptionPane.OK_OPTION) {
	 * password = String.valueOf(passwordField.getPassword()); // return password; }
	 * // return null;
	 * 
	 * }
	 */
	public static Connection createConnection() {
		// boolean connected ;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulator", "root", "0011291.sS");
			return conn;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connected = true;
		return null;

	}

	public static Object createShip(Statement myStatement, String myString) throws SQLException {
		ResultSet myRs = myStatement.executeQuery(myString);
		// ResultSetMetaData rsmd = myRs.getMetaData();
		int rowNumber = myRs.getRow();
		int count = 0;
		while (myRs.next()) {
			// for (int i = 1; i <= rowNumber; i++) {
			// if (i > 1) System.out.print(", ");
			// String columnValue = myRs.getString(i);
			// System.out.print(columnValue + " " + rsmd.getColumnName(i));
			String _name = myRs.getString("name");
			int _maxWeight = myRs.getInt("maxWeight");
			int _currentWeight = myRs.getInt("currentWeight");
			int _maxSpeed = myRs.getInt("maxSpeed");
			int _cruiseSpeed = myRs.getInt("cruiseSpeed");
			int _x = myRs.getInt("position_X");
			int _y = myRs.getInt("position_Y");
			String _destination = myRs.getString("destination");
			int _order_id = myRs.getInt("order_id");
			boolean _in_harbor = myRs.getBoolean("in_harbor");
			String _harborName = myRs.getString("harborName");
			int _pathNumber = myRs.getInt("pathNumber");
			Ship myNewShip = new Ship(_name, _maxWeight, _currentWeight, _maxSpeed, _cruiseSpeed, _x, _y, _destination,
					_order_id, _in_harbor, _harborName, _pathNumber);
			return myNewShip;
			// System.out.println(myNewShip);

		}
		// System.out.println("");
		return null;
	}

}
