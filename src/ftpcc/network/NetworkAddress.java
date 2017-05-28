package ftpcc.network;

/**
 * An object representing a NetworkAddress.
 * 
 * @author RWilmes
 *
 */
public class NetworkAddress {

	private String name;
	private String address;

	public NetworkAddress(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
