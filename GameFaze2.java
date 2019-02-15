import java.util.Scanner;
import java.io.*;
public class GameFaze2{
	public  ConsoleHandler console = new  ConsoleHandler();
	public int level = 1;
	public  AI ai = new  AI();
	public int [][] uIndexes = new int [2][20];
	public char [][] uMap = new char [10][10];
	public int uHitCounter=0;
	public boolean loop = true;
	public int endStatus = 0;
	public char [][] hitMissMap = new char [10][10];
	public String [][] instructions = {
		{"\t Movement:"},
		{"\t 9: change viev mode to single map "},
		{"\t 3: change view mode to double map "},
		{" "},
		{"\t 8: up"},
		{"\t 2: down"},
		{"\t 4: left"},
		{"\t 6: right"},
		{"\t 5: accept"},
		{"\t 7: return to menu"}

	};

	public int [][] aIndexes = new int [2][20];
	public int aHitCounter=0;

	public int mode = 0;
	
	public GameFaze2(int _level,char[][]_map, int[][]_indexes){

		console.clear();
		level=_level;
		uIndexes=_indexes;
		uMap=_map;
		ai.setLevel(level);
		ai.addIndexes(uIndexes);
		ai.startAI();
		aIndexes = ai.aIndexes;
		for(int i = 0 ; i<10; i++){
			for(int j = 0; j < 10; j++){
				hitMissMap[i][j]='~';
			}
		}
	}
	
	public void endGame(int status){
		this.loop = false;
		if(status==1){
			console.clear();
			System.out.println("YOU WON THE GAME");
		}
		if(status==2){
			console.clear();
			System.out.println("YOU LOST");
		}
		console.getch();
		 MainMenu menu = new  MainMenu();
		menu.menuLoop();
	}

	public void exit(){
		this.loop = false;
		 MainMenu menu = new  MainMenu();
		menu.menuLoop();
	}

	public void aHit(int x, int y){
		uMap[y][x]='H';
		aHitCounter++;
	}
	public void aMiss(int x, int y){
		uMap[y][x]='*';
	}
	public void printDouble(int cx,int cy){
			char [][] hitMissMapPr=new char [10][10];
			for(int i = 0; i<10; i++){
				for(int j = 0; j< 10; j++){
					hitMissMapPr[i][j]=hitMissMap[i][j];
				}
			}
			hitMissMapPr[cy][cx]='#';
		for(int i = 0; i<10; i++){
			System.out.print(i);
			for(int j = 0; j<10; j++){
				System.out.print(uMap[i][j]+" ");		
			}
			System.out.println("\t"+instructions[i][0]);
		}
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				System.out.print(" " + " ");
			}
			System.out.print(i);
			for(int k = 0 ; k<10; k++){
				System.out.print(hitMissMapPr[i][k]+" ");
			}
			System.out.println();
		}
//		for(int i = 0; i<10; i++){
//			for(int j = 0; j<10; j++){
//				
//			}
//		}
	}
	
	public void printSingle(int cx, int cy, int userOrAi){
		if(userOrAi==1){
			char [][] hitMissMapPr=new char [10][10];
			for(int i = 0; i<10; i++){
				for(int j = 0; j< 10; j++){
					hitMissMapPr[i][j]=hitMissMap[i][j];
				}
			}
			hitMissMapPr[cy][cx]='#';
			for(int i = 0; i < 10; i++){
				System.out.print(i);
				for(int j = 0; j < 10; j++){
					System.out.print(" " + hitMissMapPr[i][j]);
				}
				System.out.println("\t"+instructions[i][0]);
			
			}
		}
		if(userOrAi==2){
		
			for(int i = 0; i<10;i++){
				for(int j = 0; j<10; j++){
					System.out.print(" " + uMap[i][j]);
				}
				System.out.println();
			
			}
			console.getch();
		
		}
	}

	public void printScreen(int cx,int cy, int userOrAi){
		console.clear();
		if(mode==0){
			this.printSingle(cx,cy,userOrAi);
		}

		if(mode==1){
			this.printDouble(cx,cy);
		}
	}

	public void uMiss(int x, int y){
		hitMissMap[y][x]='*';	
	}
	public void uHit(int x, int y){
		hitMissMap[y][x]='H';
		uHitCounter++;
	}
	public boolean uShoot(int x, int y){
		boolean shootLoop=true;
		while(shootLoop){
			if(hitMissMap[y][x]!='~'){ 
				shootLoop=false;
				return true;
			}
			for(int i=0; i<20; i++){
				if(aIndexes[0][i]==x&&aIndexes[1][i]==y&&hitMissMap[y][x]=='~'){
					this.uHit(x,y);
					shootLoop=false;
					break;
				}
			}
			if(hitMissMap[y][x]=='~'){
				this.uMiss(x,y);
				shootLoop=false;
			}
		}
		return false;
	}

	public void startFaze2(){
		
			int x = 0;
			int y = 0;
		while(loop){

			 IOHandler checker = new  IOHandler();
			Scanner scan = new Scanner(System.in);
			boolean uTurn = true;
		
			while(uTurn){


				this.printScreen(x,y,1);

				int key=checker.inputHandler(scan);
			
				if(endStatus!=0){
					this.endGame(endStatus);
				}
		
				if(key==9){
					mode = 0;
				}
				if(key==3){
					mode = 1;
				}
				if(key==8&&y>0){
					y--;
				}
				
				if(key==2&&y<9){
					y++;
				}
				if(key==6&&x<9){
					x++;
				}
				if(key==4&&x>0){
					x--;
				}
			

			
				if(key==5){
					uTurn=this.uShoot(x,y);
					
				}


				if(key==7){
					this.exit();
					uTurn=false;
				}
			}
			
			boolean aiTurn = true;
			
			while(aiTurn){

				ai.shoot();
				int aiX = ai.aiX;
				int aiY = ai.aiY;
				
				for(int i = 0; i < 20 ; i++){
					if(uIndexes[0][i]==aiX && uIndexes[1][i]==aiY && uMap[aiY][aiX]=='x'){
						this.aHit(aiX,aiY);
						aiTurn=false;
						break;
					}
				}
				if(uMap[aiY][aiX]=='~'){
					this.aMiss(aiX,aiY);
					aiTurn=false;
				}
				
			}
				this.printScreen(x,y,2);
			
			if(aHitCounter>=20 && uHitCounter<20){
				endStatus=2;
			}
	
			if(uHitCounter>=20 && aHitCounter<20){
				endStatus=1;
			}
		
		}
	}
	public static void main (String [] args){
	}
}

