package damianogiusti.casestudy.hashmap;

public class Location extends Address {

	private double lat;
	private double lng;
	private String googleAddress;

	public Location() {
		lat = 0;
		lng = 0;
		googleAddress = "";
	}

	public Location(double lat, double lng, String googleAddress) {
		this.lat = lat;
		this.lng = lng;
		this.googleAddress = googleAddress;
	}

	public Location(String tipoVia, String via, String nomeVia) {
		super(tipoVia, via, nomeVia);
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getGoogleAddress() {
		return googleAddress;
	}

	public void setGoogleAddress(String googleAddress) {
		this.googleAddress = googleAddress;
	}

	public void setAddress(Address a) {
		super.setTipoVia(a.getTipoVia());
		super.setVia(a.getVia());
		super.setNomeVia(a.getNomeVia());
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
