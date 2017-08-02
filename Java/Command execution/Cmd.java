import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cmd {
	
	private StringBuffer buffer;
	private Process process;
	private BufferedReader bufferedReader;
	private StringBuffer readBuffer;
	
	private File file;
	private BufferedWriter bufferWriter;
	
	private final String FILENAME = "Test.java";
	
	public String inputSource(String source) {
		
		buffer = new StringBuffer();
		
		buffer.append("cmd.exe ");	
		buffer.append("/c  ");
		buffer.append("javac Test.java");
		
		createFileAsSource(source);

		return buffer.toString();
	}
	
	private void createFileAsSource(String source) {
		try {
			file = new File(FILENAME);
			bufferWriter = new BufferedWriter(new FileWriter(file, false));
			
			bufferWriter.write(source);
			bufferWriter.flush();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}finally {
			try {
				bufferWriter.close();
			}catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	public String execCommand(String cmd) {
		try {
			process = Runtime.getRuntime().exec(cmd);
			process = Runtime.getRuntime().exec(runClass());
			
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line = null;
			readBuffer = new StringBuffer();
			
			while((line = bufferedReader.readLine()) != null) {
				readBuffer.append(line);
				readBuffer.append("\n");
			}
			
			file.delete();
			return readBuffer.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String runClass() {
		buffer = new StringBuffer();
		
		buffer.append("cmd.exe ");	
		buffer.append("/c ");
		buffer.append("java Test");

		return buffer.toString();
	}
}
