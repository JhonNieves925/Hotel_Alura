package Factory;

import java.sql.Connection;


public class ConexionBase {

	public DataSource dataSou;

	public ConexionBase() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
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
