public class Mover extends Command {

	private String instructions;
	public Mover (String instructions) {
		super(instructions);
	}

	public String getCommand() {
		return instructions;
	}
	
	public void setCommand(String instructions) {
		this.instructions = instructions;
	}
}
