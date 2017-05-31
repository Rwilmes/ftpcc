package ftpcc.network;

import java.io.File;

import com.alee.managers.log.Log;

/**
 * Simulates a local filesystem as a network connection.
 * 
 * @author RWilmes
 * 
 */
public class FsConnection extends Connection {

	public FsConnection(NetworkAddress destination, ConnectionManager manager) {
		super(destination, manager);
		this.setStatus(CONNECTION_STATUS.CONNECTING);
		File f = new File(destination.getAddress());
		if (!f.exists()) {
			Log.warn("Fs '" + destination.getAddress() + "' does not exist");
		} else if (!f.isDirectory()) {
			Log.warn("Fs '" + destination.getAddress() + "' is not a directory");
		} else if (!f.canRead()) {
			Log.warn("Fs '" + destination.getAddress() + "' can not be read");
		} else if (!f.canWrite()) {
			Log.warn("Fs '" + destination.getAddress() + "' is read only");
		} else {
			this.setStatus(CONNECTION_STATUS.ALIVE);
		}
	}

	public String[] ls() {
		return ls("/");
	}

	public String[] ls(String dir) {
		if (!isConnected()) {
			Log.warn("fs '" + this.destination.getAddress()
					+ "' not connected!");
			return new String[0];
		}

		File f = new File(destination.getAddress());
		return f.list();
	}

	@Override
	public void disconnect() {
		setStatus(CONNECTION_STATUS.DISCONNECTED);
	}

}
