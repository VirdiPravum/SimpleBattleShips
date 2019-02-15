import java.util.Scanner;
public class  GameFaze1{

	public  ConsoleHandler console = new  ConsoleHandler();

	public int level=1;
	public boolean loop=true;
	public char [][] map = new char [10][10];
	public int [][] indexes = new int[2][20];

	public String [][] instructions = {
		{"\t Movement:"},
		{"\t 9: change orientation  to horizontal "},
		{"\t 3: change orientation to vertical "},
		{" "},
		{"\t 8: up"},
		{"\t 2: down"},
		{"\t 4: left"},
		{"\t 6: right"},
		{"\t 5: accept"},
		{"\t 7: return to menu"}

	};
	

	public int uCounter = 0;
	public char [] alphabeth = {'A','B','C','D','E','F','G','H','I','J'};
	public int numOf4Ships = 1;
	public int numOf3Ships = 2;
	public int numOf2Ships = 3;
	public int numOf1Ships = 4;
	
	public int currentSize = 4;

	public  GameFaze1(int _level){
		level=_level;
		for(int i = 0; i < 10; i++){
			for(int j = 0 ; j<10;j++){
				map[i][j]='~';
			}
		}
	}
	
	
	public void addShip(int orientation,int x ,int y){
		
		boolean test = true;
		int size = currentSize;

		if(orientation == 1){
		
		for(int i = 0; i<currentSize; i++){

			boolean testPlace=(map[y][x]=='x');				
			boolean testXLeft=(/*y>=(9-currentSize)||*/(x>0 && y<(9-currentSize)&& map[y+i][x-1]=='x'));
			boolean testXRight=(/*y>=(9-currentSize)||*/(x<9 && y<(9-currentSize) && map[y+i][x+1]=='x'));

			boolean testYDown=(/*(y+currentSize>9)||*/(y<(10-currentSize) && map[y+currentSize][x]=='x'));
			boolean testYUp=(y>0 && map[y-1][x]=='x');

			boolean testXYLeftUp=(y>0 && x>0 && map[y-1][x-1]=='x' );
			boolean testXYLeftDown=(/*(y+currentSize)>9||*/(x>0 && y<(9-currentSize) && map[x-1][y+currentSize]=='x'));
			boolean testXYRightUp=(y>0 && x<9 && map[y-1][x+1]=='x');
			boolean testXYRightDown=(/*(y+currentSize)>9||*/(x<9 && y<(9-currentSize) && map[x+1][y+currentSize]=='x'));

			boolean fullTest=(testPlace||testXLeft || testXRight || testYUp || testYDown || testXYLeftUp || testXYLeftDown || testXYRightUp || testXYRightDown);

				if(fullTest){
					test = false;
					break;
						
				}
		}
		System.out.println(test);
			if(test){
				int j = 0;	
				for(int i =uCounter; j<currentSize; i++){
					indexes[0][i]=x;
					indexes[1][i]=y+j;
					j++;
				}
				for(int i = 0; i<currentSize; i++){ 
					map[y+i][x]='x';
				}
				if(currentSize == 1 && numOf1Ships>0){
					numOf1Ships--;
					uCounter++;
				
					if(numOf1Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 2 && numOf2Ships>0){
					numOf2Ships--;
					uCounter+=2;	
					
					if(numOf2Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 3 && numOf3Ships>0){
						numOf3Ships--;
						uCounter+=3;
				
					if(numOf3Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 4 && numOf4Ships>0){
					numOf4Ships--;
				
					if(numOf4Ships==0){
						currentSize--;
						uCounter+=4;
					}
				}
		
			
			}

		}				
		if(orientation == 2) 	{
		
		for(int i = 0; i<currentSize; i++){

			boolean testPlace=(map[y][x]=='x');				
			boolean testXLeft=(x>0 && map[y][x-1]=='x');
			boolean testXRight=(/*x>(9-currentSize)||*/(x<(9-currentSize) && map[y][x+currentSize]=='x'));
			System.out.println(testXRight);
			boolean testYDown=((y<9&&x<(10-currentSize) && map[y+1][x+i]=='x')/*||(x+currentSize)>9*/);
			boolean testYUp=(/*(x+currentSize>9)||*/(y>0 && x<(10-currentSize)&&map[y-1][x+i]=='x'));

			boolean testXYLeftUp=(y>0 && x>0 && map[y-1][x-1]=='x' );
			boolean testXYLeftDown=(x>0 && y<9 && map[x-1][y+1]=='x');
			boolean testXYRightUp=((y>0 && x<(10-currentSize) && map[y-1][x+currentSize]=='x')/*||(x+currentSize)>9*/);
			boolean testXYRightDown=((y<9 && x<(10-currentSize) && map[x+currentSize][y+1]=='x')/*||(x+currentSize)>9*/);

			boolean fullTest=(testPlace||testXLeft || testXRight || testYUp || testYDown || testXYLeftUp || testXYLeftDown || testXYRightUp || testXYRightDown);
			
				if(fullTest){
					test = false;	
					break;
				}
		}
		System.out.println(test);
			if(test){	
				int j = 0;
				for(int i =uCounter; j<currentSize; i++){
					indexes[0][i]=x+j;
					indexes[1][i]=y;
					j++;
				}
				for(int i = 0; i<currentSize; i++){ 
					map[y][x+i]='x';
				}
				if(currentSize == 1 && numOf1Ships>0){
					numOf1Ships--;
					uCounter++;
				
					if(numOf1Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 2 && numOf2Ships>0){
					numOf2Ships--;
					uCounter+=2;	
					
					if(numOf2Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 3 && numOf3Ships>0){
						numOf3Ships--;
						uCounter+=3;
				
					if(numOf3Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 4 && numOf4Ships>0){
					numOf4Ships--;
				
					if(numOf4Ships==0){
						currentSize--;
						uCounter+=4;
					}
				}
						
			}
		}
		
	
	
		if(test == false){
			console.clear();
			System.out.println("Place ship elswhere");
			console.getch();
		}
	}
	
	public void printMap(int orientation,int x,int y){
		char [][] currentMap = new char [10][10];

		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				currentMap[i][j]=map[i][j];
			}
		}
		
		for(int i = 0; i <currentSize; i++){
			if(orientation==1){
				currentMap[y+i][x] = 'x';
			}
			if(orientation==2){
				currentMap[y][x+i] = 'x';
			}
		}
		for(int i = 0; i<10; i++){
			System.out.print(" " + alphabeth[i]);
		}
		System.out.println();
		
		for(int i = 0; i<10; i++){
			System.out.print(i);
			for(int j = 0; j<10; j++){
				System.out.print(currentMap[i][j] + " ");
			}
			System.out.println(instructions[i][0]);
		}
			System.out.println("amount " + uCounter);
			System.out.println("4: "+numOf4Ships + " 3: " + numOf3Ships +" 2: "+ numOf2Ships + " 1: " +  numOf1Ships );
			System.out.println("orient: "+orientation+" size: "+ currentSize);
			System.out.println("x: "+ x +" y: "  +y);
		
	}

	public void end(){
		this.loop=false;
		 GameFaze2 game = new  GameFaze2(level,map,indexes);
		game.startFaze2();
	
	}	

	public void exit(){
		this.loop = false;
		 MainMenu menu = new  MainMenu();
		menu.menuLoop();
	}

	public void start(){
			int x = 0;
			int y = 0;
			int orientation = 1;
		while(loop){
			this.printMap(orientation,x,y);
			Scanner scan = new Scanner(System.in);
			 IOHandler checker = new  IOHandler();

			int key = checker.inputHandler(scan);

			if(key == 5){
				this.addShip(orientation,x,y);
			}
			if (key == 8 && y>0){
				y--;
			}
			if (key == 2 && ((orientation == 1 && y+currentSize<10) || (orientation==2 && y<10))){
				y++;
			}
			if (key == 4 && x>0){
				x--;
			}
			if (key == 6 && ((orientation==2&&x+currentSize<10)||(orientation==1 && x<10))){
				x++;
			}
			if (key == 9 && x<=10-currentSize){
				orientation=2;
			}
			if (key == 3 && y<=10-currentSize){
				orientation=1;
			}
			if (key == 7){
			//	ai.indexCounter=0;
				this.exit();
			}
			
			
			if(uCounter == 20){
			//	ai.indexCounter=0;
				for( int i = 0 ; i<2; i++){
					for(int j = 0; j<20; j++){
						System.out.print(indexes[i][j]);
					}
					System.out.println();
				}
				this.end();
			}
			console.clear();
		}
	}
	public static void main (String [] args){
		 GameFaze1 game = new  GameFaze1(1);
		game.start();
	}	
}
