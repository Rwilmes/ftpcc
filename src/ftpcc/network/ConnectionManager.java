package ftpcc.network;

import java.util.ArrayList;
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

	public ConnectionManager() {
		this.connections = new ArrayList<Connection>();
	}

	protected void addConnection(Connection c) {
		this.connections.add(c);
	}

	protected void removeConnection(Connection c) {
		this.connections.remove(c);
	}

	public abstract Connection connect(NetworkAddress destination);

	protected Connection getConnection(NetworkAddress destination) {
		for (Connection c : this.connections) {
			if (c.getDestination().equals(destination))
				return c;
		}

		return null;
	}

	public Connection disconnect(NetworkAddress destination) {
		Connection c = getConnection(destination);
		c.disconnect();
		return c;
	}

	public void disconnect(Connection connection) {
		connection.disconnect();
	}

	public CONNECTION_STATUS getConnectionStatus(NetworkAddress destination) {
		return getConnectionStatus(getConnection(destination));
	}

	public CONNECTION_STATUS getConnectionStatus(Connection connection) {
		return connection.getStatus();
	}
}
