public class  AI{

	

	public int level=1;
	public boolean aLoop=true;
	public int [][] uIndexes = new int[2][20];
	public int [][] aIndexes = new int[2][20];
	public char [][] aMap = new char [10][10];
	public int aiCounter = 0;
	public char [] alphabeth = {'A','B','C','D','E','F','G','H','I','J'};
	public int numOf4Ships = 1;
	public int numOf3Ships = 2;
	public int numOf2Ships = 3;
	public int numOf1Ships = 4;
	
	public int currentSize = 4;

	public  AI(){
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10; j++){
				aMap[i][j]='~';
			}
		}
	}
		
	public void makeIndexes(int orientation,int x ,int y){
		System.out.println("Random map generator - adding ship"+aiCounter+"\n"+x+" "+y);	
		boolean test = true;
		int size = currentSize;

		if(orientation == 1){
		
		for(int i = 0; i<currentSize; i++){

			boolean testPlace=(aMap[y][x]=='x');				
			boolean testXLeft=(x>=9||y>=(9-currentSize)||(x>0 && y<(9-currentSize)&& aMap[y+i][x-1]=='x'));
			boolean testXRight=(x>=9||y>=(9-currentSize)||(x<9 && y<(9-currentSize) && aMap[y+i][x+1]=='x'));

			boolean testYDown=((y+currentSize>9)||(y<(9-currentSize) && aMap[y+currentSize][x]=='x'));
			boolean testYUp=(y<0 && aMap[y-1][x]=='x');

			boolean testXYLeftUp=(y>0 && x>0 && aMap[y-1][x-1]=='x' );
			boolean testXYLeftDown=((y+currentSize)>9||(x>0 && y<(9-currentSize) && aMap[x-1][y+currentSize]=='x'));
			boolean testXYRightUp=(y>0 && x<9 && aMap[y-1][x+1]=='x');
			boolean testXYRightDown=((y+currentSize)>9||(x<9 && y<(9-currentSize) && aMap[x+1][y+currentSize]=='x'));

			boolean fullTest=(testPlace||testXLeft || testXRight || testYUp || testYDown || testXYLeftUp || testXYLeftDown || testXYRightUp || testXYRightDown);

				if(fullTest){
					test = false;
					break;
						
				}
		}
		System.out.println(test);
			if(test){
				int j = 0;	
				for(int i =aiCounter; j<currentSize; i++){
					aIndexes[0][i]=x;
					aIndexes[1][i]=y+j;
					j++;
				}
				for(int i = 0; i<currentSize; i++){ 
					aMap[y+i][x]='x';
				}
				if(currentSize == 1 && numOf1Ships>0){
					numOf1Ships--;
					aiCounter++;
				
					if(numOf1Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 2 && numOf2Ships>0){
					numOf2Ships--;
					aiCounter+=2;	
					
					if(numOf2Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 3 && numOf3Ships>0){
						numOf3Ships--;
						aiCounter+=3;
				
					if(numOf3Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 4 && numOf4Ships>0){
					numOf4Ships--;
				
					if(numOf4Ships==0){
						currentSize--;
						aiCounter+=4;
					}
				}
		
			
			}

		}				
		if(orientation == 2) 	{
		
		for(int i = 0; i<currentSize; i++){

			boolean testPlace=(aMap[y][x]=='x');				
			boolean testXLeft=(x>0 && aMap[y][x-1]=='x');
			boolean testXRight=(x>(9-currentSize)||(x<(9-currentSize) && aMap[y][x+currentSize]=='x'));
			System.out.println(testXRight);
			boolean testYDown=((y<9&&x<(10-currentSize) && aMap[y+1][x+i]=='x')||(x+currentSize)>9);
			boolean testYUp=((x+currentSize>9)||(y>0 && x<(10-currentSize)&&aMap[y-1][x+i]=='x'));

			boolean testXYLeftUp=(y>0 && x>0 && aMap[y-1][x-1]=='x' );
			boolean testXYLeftDown=(x>0 && y<9 && aMap[x-1][y+1]=='x');
			boolean testXYRightUp=((y>0 && x<(10-currentSize) && aMap[y-1][x+currentSize]=='x')||(x+currentSize)>9);
			boolean testXYRightDown=((y<9 && x<(10-currentSize) && aMap[x+currentSize][y+1]=='x')||(x+currentSize)>9);

			boolean fullTest=(testPlace||testXLeft || testXRight || testYUp || testYDown || testXYLeftUp || testXYLeftDown || testXYRightUp || testXYRightDown);
			
				if(fullTest){
					test = false;	
					break;
				}
		}
		System.out.println(test);
			if(test){	
				int j = 0;
				for(int i =aiCounter; j<currentSize; i++){
					aIndexes[0][i]=x+j;
					aIndexes[1][i]=y;
					j++;
				}
				for(int i = 0; i<currentSize; i++){ 
					aMap[y][x+i]='x';
				}
				if(currentSize == 1 && numOf1Ships>0){
					numOf1Ships--;
					aiCounter++;
				
					if(numOf1Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 2 && numOf2Ships>0){
					numOf2Ships--;
					aiCounter+=2;	
					
					if(numOf2Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 3 && numOf3Ships>0){
						numOf3Ships--;
						aiCounter+=3;
				
					if(numOf3Ships==0){
						currentSize--;
					}
				}
				if(currentSize == 4 && numOf4Ships>0){
					numOf4Ships--;
				
					if(numOf4Ships==0){
						currentSize--;
						aiCounter+=4;
					}
				}
						
			}
		}
	
	}
	

	public void endAI(){
		this.aLoop=false;
	
	}
		
	
	public int aiX=0;
	public int aiY=0;
	public int randCounter = 0;
	public int indexCounter = 0;
//	public int indexShooted = new index[20];
//	public int i = 0 ;
	public void shoot(){
		if(level==1){
			randCounter++;
			if(randCounter<10){
				aiX=( int)(Math.random()*10);
				aiY=( int)(Math.random()*10);
			}
			else{
				aiX=uIndexes[0][indexCounter];
				aiY=uIndexes[1][indexCounter];
				indexCounter++;
				randCounter=0;
			}
		}
		if(level==2){
			randCounter++;
			if(randCounter<5){
				aiX=( int)(Math.random()*10);
				aiY=( int)(Math.random()*10);	
			}
			else{
				aiX=uIndexes[0][indexCounter];
				aiY=uIndexes[1][indexCounter];
				indexCounter++;
				randCounter=0;
			}
		}
		if(level==3){
			randCounter++;
			if(randCounter<3){
				aiX=( int)(Math.random()*10);
				aiY=( int)(Math.random()*10);	
			}
			else{
				
				aiX=uIndexes[0][indexCounter];
				aiY=uIndexes[1][indexCounter];
				indexCounter++;
				System.out.println("\n\n\t "+  indexCounter);
				randCounter=0;
			}
		}
		if(level==4){
			
				System.out.println("\n\n\t "+  indexCounter);
			aiX=uIndexes[0][indexCounter];
			aiY=uIndexes[1][indexCounter];
			indexCounter++;
		}
	}
		
	public void setLevel(int _level){
		level = _level;
	}

	public void addIndexes(int[][] _uIndexes){
		uIndexes = _uIndexes;
	}

	public void startAI(){
		while(aLoop){
			int x = (int )(Math.random()*10);
			int y = (int )(Math.random()*10);
			int orientation = 1 + (int )(Math.random()*2);
		
		
			this.makeIndexes(orientation,x,y);
			if(aiCounter==20){
				for(int i=0;i<2;i++){
					for(int j=0; j<20;j++){
						System.out.print(aIndexes[i][j]+" ");
					}
					System.out.println();
				}
				this.endAI();
			}
		}
	}
}
