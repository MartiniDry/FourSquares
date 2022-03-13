package tools;

public enum EAlgo {
	METHOD_1("Méthode 1"), //
	METHOD_2("Méthode 2"), //
	METHOD_3("Méthode 3"), //
	METHOD_4("Méthode 4"), //
	METHOD_5("Méthode 5"), //
	METHOD_6("Méthode 6");

	public String description;

	private EAlgo(String desc) {
		this.description = desc;
	}
}