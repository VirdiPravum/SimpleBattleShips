import java.io.IOException;
import java.util.Scanner;

public class  ConsoleHandler{
	public  ConsoleHandler(){
		;
	}
		
	public void windowsClear(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(IOException | InterruptedException ex){}
	}
	

	public void nixClear(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	

	public void clear(){
		String os = System.getProperty("os.name");
		if(os.contains("Windows")){
			this.windowsClear();
		}
		else{
			this.nixClear();
		}
	}
	
	public void getch(){

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public static void main(String[]args){
		;
	} 
}
