ParkingService {
	Ticket entry(VheficleType type);
	double exit(long ticketId);
}

Ticket {
	long Id;
	Date entryTime, exitTime;
	ParkingSlot slot;
	String vehicleNumber;
}

ParkingSlot {
	long Id;
	VehicleType type;
	State state;
}

enum VehicleType {
	SMALL,
	MEDIUM,
	LARGE
}

enum State {
	OCCUPIED,
	UNOCCUPIED,
	UNDERREVIEW
}