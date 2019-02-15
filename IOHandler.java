import java.util.*;
public class IOHandler{

	public IOHandler(){
		;
	}
	
	public int inputHandler(Scanner input){
		int output = 0;
		boolean error = false;
		do{
			try{
				output = Integer.parseInt(input.next());
				return output;	
			}catch(Exception x){
				error = true;
				System.out.println("Error! Not valid control!");
				input.reset();
			}
		}while(error);
		return output;
	}

}
