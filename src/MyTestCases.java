import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
//	WebDriver driver = new ChromeDriver();

	Connection con;
	Statement stmt;
	ResultSet rs;

	@BeforeTest(description = "my sample DB from this link 'https://www.mysqltutorial.org/wp-content/uploads/2023/10/mysqlsampledatabase.zip'")
	public void setUp() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123456");
	}

	@Test
	public void getData() throws SQLException {

		stmt = con.createStatement();

		rs = stmt.executeQuery("select * from customers where country = 'Australia'");

		int row = 0;
		while (rs.next()) {
			
			++row;

			int customerNumber = rs.getInt("customerNumber");
			String customerName = rs.getString("customerName");
			String phone = rs.getString("phone");

			System.out.println("***************************************** " + row);
			System.out.println("the customer number is " + customerNumber);
			System.out.println("the customer name is " + customerName);
			System.out.println("the customer phone number is " + phone);

		}
		System.out.println("\nThe total number of rows equal "+row);
	}

	@AfterTest
	public void cleanUp() {

	}
}
