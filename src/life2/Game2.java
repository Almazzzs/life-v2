package life2;

public interface Game2 {
	
	void init(int[][] init);
	
	void iterate();
	
	int calcAliveNeighbours(int i,int j);
	
	int[][] getState();
	
}
