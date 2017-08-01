
public class Complier {
	public static void main(String[] args) {
		Cmd cmd = new Cmd();
	
		String command = cmd.inputCommand("ipconfig");
		String result = cmd.execCommand(command);
		
		System.out.println(result);
	}
}
