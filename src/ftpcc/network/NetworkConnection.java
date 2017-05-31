package ftpcc.network;

public class NetworkConnection extends Connection {

	public NetworkConnection(NetworkAddress destination,
			ConnectionManager manager) {
		super(destination, manager);
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

}
