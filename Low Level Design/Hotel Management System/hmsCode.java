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
	String roomId;
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



abstract class Person {
	String name;
	Account accountDetail;
	String phone;
}

public class Account {
	String username;
	String password;
	AccountStatus accountStatus;
}

public enum AccountStatus {
	ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person {
	public List<Room> getRoomsServiced(Date date);
}

class Guest extends Person {
	Search searchObj;
	Booking bookingObj;
	
	public void checkInGuest(Guest guest, RoomBooking bookingInfo);
	public void checkOutGuest(Guest guest, RoomBooking bookingInfo);
}

class Admin extends Person {
	public void addRoom(RoomDetail roomDetail);
	public void deleteRoom(String roomId);
	public void editRoom(RoomDetail roomDetail);
}

class Search {
	public List<Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration);
}

class Booking {
	public RoomBooking createBooking(Guest guestInfo);
	public RoomBooking cancelBooking(int bookingId);
}

class RoomBooking {
	String bookingId;
	Date startDate;
	Int durationInDays;
	BookingStatus bookingStatus;
	List<Guest> guestList;
	List<Room> roomInfo;
	BaseRoomCharge totalRoomCharges;
}



/* DECORATOR design pattern to solve the room charge problem */
interface BaseRoomCharge {
	Double getCost();
}

class RoomCharge implements BaseRoomCharge {
	double cost;
	Double getCost(){
		return cost;
	}
	void setCost(double cost){
		this.cost = cost;
	}
}

class RoomServiceCharge implements BaseRoomCharge {
	double cost;
	BaseRoomCharge baseRoomCharge;
	Double getCost() {
		baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
		return baseRoomCharge.getCost();
	}
}

class InRoomPurchaseCharges implements BaseRoomCharge {
	double cost;
	BaseRoomCharge baseRoomCharge;
	Double getCost() {
		baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
		return baseRoomCharge.getCost();
	}
}