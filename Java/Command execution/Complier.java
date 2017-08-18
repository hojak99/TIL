
public class Complier {
	public static void main(String[] args) {
		Cmd cmd = new Cmd();
	
		StringBuffer buffer = new StringBuffer();
		buffer.append("public class Test");
		buffer.append("{ public static void main(String[] args)");
		buffer.append("{ System.out.println(\"sdadadasdadasdasd\");} }");
		
		String command = cmd.inputSource(buffer.toString());
		String result = cmd.execCommand(command);
		
		System.out.println(result);
	}
}
