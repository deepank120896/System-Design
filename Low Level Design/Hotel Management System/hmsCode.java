class Hotel {
	String Name;
	Integer id;
	Location hotelLocation;
	List<Room> roomList;
}

class Location {
	Integer pin;
	String street;
	String area;
	String city;
	String country;
}

class Room {
	String roomNumber;
	RoomStyle roomStyle;
	RoomStatus roomStatus;
	Double bookingPrice;
	List<RoomKey> roomKeys;
	/* A Room HAS-A Housekeeping log */
	List<HouseKeepingLogs> houseKeepingLogs;
}

public enum RoomStyle {
	STANDARD, DELUXE, FAMILY_SUITE;
}

public enum RoomStatus {
	AVAILABLE, RESERVED, NOT_AVAILABLE, OCCUPIED, SERVICE_IN_PROGRESS;
}

class RoomKey {
	String keyId;
	String barcode;
	Date issuedAt;
	boolean isActive;
	boolean isMaster;
	
	public void assignRoom(Room room);
}

class HouseKeepingLogs {
	String description;
	Date startDate;
	int duration;
	HouseKeeper houseKeeper;
	
	public void addRoom(Room room);
}
