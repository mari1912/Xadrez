public class Transformar extends Command {

	private String instructions;
	public Transformar (String instructions) {
		super(instructions);
	}

	public String getCommand() {
		return instructions;
	}
	public void setCommand(String instructions) {
		this.instructions = instructions;
	}
}
