package ftpcc.network;

import ftpcc.utils.Log;

/**
 * A Connection object represents a connection to a destination. What kind of
 * Connection and how it will be established depends on the implementation.
 * 
 * @author RWilmes
 * 
 */
public abstract class Connection {

	public enum CONNECTION_STATUS {
		PREMATURE, CONNECTING, ALIVE, DISCONNECTED, ERROR, RECONNECTING
	}

	private CONNECTION_STATUS status;

	protected NetworkAddress destination;
	protected ConnectionManager manager;

	public Connection(NetworkAddress destination, ConnectionManager manager) {
		this.destination = destination;
		this.manager = manager;
		this.setStatus(CONNECTION_STATUS.PREMATURE);
	}

	public NetworkAddress getDestination() {
		return destination;
	}

	public abstract void disconnect();

	protected void setStatus(CONNECTION_STATUS status) {
		Log.log("new status: " + status);
		this.status = status;
	}

	public CONNECTION_STATUS getStatus() {
		return status;
	}

	public boolean isConnected() {
		return getStatus().equals(CONNECTION_STATUS.ALIVE);
	}

}
