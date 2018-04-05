package voiture.option;

public class VehiculeOption {

	private int vehiculeId;
	private int optionId;
	
	public VehiculeOption(int _vehiculeId, int _optionId)
	{
		vehiculeId = _vehiculeId;
		optionId = _optionId;
	}
	
	public int getVehiculeId() {
		return vehiculeId;
	}

	public int getoptionId() {
		return optionId;
	}

}
