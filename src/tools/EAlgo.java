package tools;

public enum EAlgo {
	METHOD_1("1 - Naive"), //
	METHOD_2("2 - C4(mod)"), //
	METHOD_3("3 - C4(mod) + UB"), //
	METHOD_4("4 - C4(mod) + UB + LB"), //
	METHOD_5("5 - C4(cast) + UB + LB"), //
	METHOD_6("6 - C4(cast) + EUB + LB");

	public String description;

	private EAlgo(String desc) {
		this.description = desc;
	}
}