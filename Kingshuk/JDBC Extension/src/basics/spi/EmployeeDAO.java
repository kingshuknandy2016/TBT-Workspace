package basics.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBCdemo.Employee;

import com.mysql.jdbc.PreparedStatement;

public class EmployeeDAO {

	static String driver, url, user, password;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/EmployeeDb";
		user = "root";
		password = "king";
	}

	private static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	static Connection con;
	static Statement st;

	static java.sql.PreparedStatement pst;
	static ResultSet rs;
	static Employee eRec;

	// using list
	static public List getEmployee() {
		String qry = "Select *from employee";
		List<Employee> list = new ArrayList<Employee>();

		try {
			pst = getConnection().prepareStatement(qry);
			// pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				do {
					eRec = new Employee();
					eRec.setEmpid(rs.getInt("id"));
					eRec.setName(rs.getString("name"));
					eRec.setAddress(rs.getString("address"));
					eRec.setSalary(rs.getInt("salary"));
					list.add(eRec);
				} while (rs.next());
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static Employee findById(int id) {
		String qry = "Select * from employee where id=?";

		try {
			pst = getConnection().prepareStatement(qry);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				eRec = new Employee();
				eRec.setEmpid(rs.getInt("id"));
				eRec.setName(rs.getString("name"));
				eRec.setAddress(rs.getString("address"));
				eRec.setSalary(rs.getInt("salary"));
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eRec;

	}

	public static int insertEmployee(int id, float salary, String... input1) {
		int ret = 0;
		try {
			con = getConnection();
			// st=con.createStatement();
			// ret=st.executeUpdate(iqry);
			pst = con.prepareStatement("insert into employee values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, input1[0]);
			pst.setString(3, input1[1]);
			pst.setInt(4, (int) salary);
			ret = pst.executeUpdate();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return ret;
	}

}
