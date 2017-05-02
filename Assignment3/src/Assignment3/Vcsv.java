package Assignment3;

public class Vcsv {
	private String regNum;
	private String driverName;
	private String vehiclesType;

	public Vcsv(String driverName, String regNum, String vehiclesType) {
		this.regNum = regNum;
		this.driverName = driverName;
		this.vehiclesType = vehiclesType;
//		System.out.println(driverName+" "+regNum+" "+vehiclesType);
	}
	
	public String getRegNum(){
		return regNum;
	}
	
	public String getVehiclesType(){
		return vehiclesType;
	}
}
