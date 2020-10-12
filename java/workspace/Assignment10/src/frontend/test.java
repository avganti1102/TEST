package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import backend.Basic;

public class test {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Basic.connectDB();
	}
}
