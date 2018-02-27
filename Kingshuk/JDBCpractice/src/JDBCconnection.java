import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCconnection {
	static String driver;
	static String url;
	static String user;
	static String pass;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/abhishek";// here we enter
		// database name
		user = "root";
		pass = "root";
	}

	static Connection con = null;
	static Statement stmt = null;
	static PreparedStatement pst=null;
	static ResultSet rs;

	static void insertEmp()

	{
		String sQry = "insert into emp values(4605,'Abhishek','Shiloh')";
		try {
			stmt.executeUpdate(sQry);
			System.out.println("Insert successfully");
		} catch (SQLException e1) {
			System.out.println(e1);

		}
	}
	
	static void findByEmployeeId(int empId){
		String str="Select * from emp where EId=?";
		try {
			pst=con.prepareStatement(str);
			pst.setInt(1, 4605);
			rs=pst.executeQuery();
			
			if(rs.next()){
				System.out.println("Emp name:"+rs.getString("eName"));
			}
		} catch (SQLException e) {
			
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);// connection
																// done here
			stmt = con.createStatement();// create statement done here
			System.out.println("connection done");
			// Creating table from here
			// String
			// iQry="create table Emp(EId int, eName varchar(20),ProjectName varchar(30))";
			// stmt.executeUpdate(iQry);
			System.out.println("cretae successfully");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException se) {
			System.out.println(se);
		}
		insertEmp();
		findByEmployeeId(4605);

	}
}
