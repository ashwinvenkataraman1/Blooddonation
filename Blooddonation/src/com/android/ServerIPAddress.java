package com.android;

public class ServerIPAddress {
	static String ipaddress = null;
	static String hotelname = null;
	static String uname = null;
	

	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		ServerIPAddress.uname = uname;
	}

	public static String getHotelname() {
		return hotelname;
	}

	public static void setHotelname(String hotelname) {
		ServerIPAddress.hotelname = hotelname;
	}

	public static String getIpaddress() {
		return ipaddress;
	}

	public static void setIpaddress(String ipaddress) {
		ServerIPAddress.ipaddress = ipaddress;
	}
	

}
