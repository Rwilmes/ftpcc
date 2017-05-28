package ftpcc.network;

import java.util.List;

import ftpcc.network.Connection.CONNECTION_STATUS;

/**
 * A ConnectionManager manages several Connection objects.
 * 
 * @author RWilmes
 *
 */
public abstract class ConnectionManager {

	private List<Connection> connections;

	public Connection connect(NetworkAddress destination) {
		return connect(getConnection(destination));
	}

	protected abstract Connection getConnection(NetworkAddress destination);

	public abstract Connection connect(Connection connection);

	public Connection disconnect(NetworkAddress destination) {
		return disconnect(getConnection(destination));
	}

	public abstract Connection disconnect(Connection connection);

	public CONNECTION_STATUS getConnectionStatus(NetworkAddress destination) {
		return getConnectionStatus(getConnection(destination));
	}

	public abstract CONNECTION_STATUS getConnectionStatus(Connection connection);
}
