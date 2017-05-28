package ftpcc.network;

public abstract class Connection {

	public enum CONNECTION_STATUS {
		PREMATURE, CONNECTING, ALIVE, DISCONNECTED, ERROR, RECONNECTING
	}

	private CONNECTION_STATUS status;

	private NetworkAddress destination;
	private ConnectionManager manager;

	public Connection(NetworkAddress destination, ConnectionManager manager) {
		this.destination = destination;
		this.manager = manager;
		this.status = CONNECTION_STATUS.PREMATURE;
	}

	public NetworkAddress getDestination() {
		return destination;
	}

	public Connection disconnect() {
		return this.manager.disconnect(this);
	}
}
