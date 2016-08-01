package w1_d5;

public enum Days {
	Mon("Go to Gym"), Tue("Go to School"), Wed("Go to Park"), Thu("Go to Sleep"), Fri("Go to Ocean Park"), Sat(
			"Go to Disneyland"), Sun("Go to Church");

	private String value;

	Days(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}