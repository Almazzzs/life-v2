/**
 * User: artpe_000
 * Date: 23.08.14
 * Time: 12:46
 */
package life2;
public class Game2Impl implements Game2 {

    public static final int BOUND = 5;
    int[][] state;

    @Override
    public void init(int[][] init)
    {
        state = init;
    }

    @Override
    public void iterate()
    {
        int[][] newState = new int[BOUND][BOUND];
        for (int i = 0; i<BOUND; i++)
        {
            for (int j = 0 ; j<BOUND ; j++)
            {
                if (state[j][i] == 0)
                {
                    if (calcAliveNeighbours(j,i) == 3)
                    {
                        newState[j][i] = 1;
                    }
                    else
                    {
                        newState[j][i] = 0;
                    }
                }
                else
                {
                    if (!(calcAliveNeighbours(j, i) == 2 || calcAliveNeighbours(j, i) == 3))
                    {
                        newState[j][i] = 0;
                    }
                    else
                    {
                        newState[j][i] = 1;
                    }
                }
            }
        }
        state = newState;
    }

    private boolean isOutOfBound(int i, int j)
    {
        return i<=0 || i>=BOUND || j<=0 || j>=BOUND;
    }

    /**
     *
     * @return 0 - dead, 1 - alive
     */
    private int alive(int i, int j)
    {
        if (!isOutOfBound(i,j))
        {
            return state[i][j];
        }
        return 0;
    }


    @Override
    public int calcAliveNeighbours(int i, int j)
    {
        return alive(i-1, j) + alive(i-1, j-1) + alive(i-1, j+1) +
                alive(i, j+1) + alive(i, j-1) +
                alive(i+1, j) + alive(i+1, j-1) + alive(i+1, j+1);

    }


    @Override
    public int[][] getState()
    {
        return state;
    }
}