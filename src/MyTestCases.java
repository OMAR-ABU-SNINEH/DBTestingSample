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

	@BeforeTest
	public void setUp() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123456");
	}

	@Test
	public void getData() {

	}

	@AfterTest
	public void cleanUp() {

	}
}
