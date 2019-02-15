import java.util.Scanner;
public class  MainMenu{

	public int option = 1;

	public int level = 1;
	public boolean loop = true;
	public String [][] menu = {	
					{"1:New Game" ," ", " "},
					{"2:Dfficulty: "," ", " "},
					{"3:Exit", " ", " "},
					{"8-up 2-down 6-right 4-left 5-accept","",""}
	};


	public  MainMenu(){
		;
	}

	public void exit(){
		this.loop=false	;
	}

	public void StartGame(){

		this.loop = false;
		 GameFaze1 game = new  GameFaze1(this.level);
		game.start();
	}
	
	public void menuLoop(){

	Scanner scan = new Scanner(System.in);
	 ConsoleHandler console = new  ConsoleHandler(); 
	 IOHandler checker = new  IOHandler();
		while(loop){
			for(int i = 0; i < 4; i++){
				for(int j=0; j < 3; j++){
					menu[option-1][2]="<-";
					if(level==1){
						menu[1][1]="Easy";
					}
					if(level==2){
						menu[1][1]="Medium";
					}
					if(level==3){
						menu[1][1]="Hard";
					}
					if(level==4){
						menu[1][1]="Impossible";
					}
					System.out.print(menu[i][j]);
				}
				System.out.println();
			}
			menu[option-1][2]=" ";

			int key = checker.inputHandler(scan);
			if( key == 5){
				switch (option){

					case 1:  this.StartGame();
						 break;
					
					case 2: break;
					
					case 3: this.exit();
						System.exit(0);
						break;
				}
			}
			if( key == 8 /*|| key =="^[[A")*/&& option>1){ option--;}
			if( key == 2 /*|| key =="^[[B")*/ && option<3){ option++;}
			if( key == 4 /*|| key =="^[[D")*/&& option == 2 && level>1){ level--;}
			if( key == 6 /*|| key =="^[[C")*/&& option == 2 && level<4){ level++;}
		// 	System.out.println( option + " " + level );
			console.clear();
		}
	}
	public static void main (String [] args){
		 MainMenu mainMenu = new  MainMenu();
		mainMenu.menuLoop();
	}

}
