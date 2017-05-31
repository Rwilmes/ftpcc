package ftpcc.network;


/**
 * Manages connections to local filesystems.
 * 
 * @author RWilmes
 * 
 */
public class FsConnectionManager extends ConnectionManager {

	public Connection connect(String dir) {
		FsConnection c = new FsConnection(new NetworkAddress("dir", dir), this);
		this.addConnection(c);
		return c;
	}


	@Override
	public Connection connect(NetworkAddress destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
