package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionBase {

	public DataSource dataSou;

	public ConexionBase() {
		final CommonDataSource comboPool = new CommonDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/hotel_alura_co?serverTimezone=UTC&useLegacyDatetimeCode=false");
		comboPool.setUser("root");
		comboPool.setPassword("root");

		this.dataSou = comboPool;
	}

	public Connection conectarBase() {
		try {
			return this.dataSou.getConnection();
		} catch (SQLException e) {
			System.out.println("hubo un error");
			throw new RuntimeException(e);
		}

	}
}
