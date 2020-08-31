SlotService {
	ParkingSlot allocate(VehicleType type);
	boolean unAllocate(long ParkingSlotId);
}

PricingService {
	double calculate(VehicleType type, Date inTime, Date outTime);
}