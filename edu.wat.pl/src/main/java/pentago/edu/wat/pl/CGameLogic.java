package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

import exceptions.ExceptionNotMove;
import exceptions.ExceptionNotRotate;
import exceptions.CGameStateChecker;

public final class CGameLogic 
{
	    
	private final static CGameLogic instance = new CGameLogic();
	public int win=0;
    public boolean player=false;
    public int state = 0;
    public Point Board1[][] = new Point[3][3];
    public boolean BBoard1[][] = new boolean[3][3];
    public Color KBoard1[][] = new Color[3][3];
    public Point Board2[][] = new Point[3][3];
    public boolean BBoard2[][] = new boolean[3][3];
    public Color KBoard2[][] = new Color[3][3];
    public Point Board3[][] = new Point[3][3];
    public boolean BBoard3[][] = new boolean[3][3];
    public Color KBoard3[][] = new Color[3][3];
    public Point Board4[][] = new Point[3][3];
    public boolean BBoard4[][] = new boolean[3][3];
    public Color KBoard4[][] = new Color[3][3];
    public Color KCompleteBoard[][] = new Color[6][6];
    private JButton Rotatel1, Rotatep1, Rotatel2, Rotatep2, Rotatel3, Rotatep3, Rotatel4, Rotatep4;
    public int reset = 0;
    public int now = 0;
    
	public static CGameLogic getInstance()
	{
		return instance;
	}

	private CGameLogic() 
	{
	    	
	}
	
	public void getbuttons(JButton l1, JButton p1, JButton l2, JButton p2, JButton l3, JButton p3, JButton l4, JButton p4)
	{
		this.Rotatel1=l1;
		this.Rotatep1=p1;
		this.Rotatel2=l2;
		this.Rotatep2=p2;
		this.Rotatel3=l3;
		this.Rotatep3=p3;
		this.Rotatel4=l4;
		this.Rotatep4=p4;
	}
	
	public void buttons(Object source)
	{
		try 
		{
			CGameStateChecker.ifRotate(state, win);
			if(source == Rotatel1)
			{
				KBoard1 = rotatee1(KBoard1);
				BBoard1 = rotatee(BBoard1);		
			}
			if(source == Rotatel2)
			{
				KBoard2 = rotatee1(KBoard2);
				BBoard2 = rotatee(BBoard2);
			}
			if(source == Rotatel3)
			{
				KBoard3 = rotatee1(KBoard3);
				BBoard3 = rotatee(BBoard3);
			}
			if(source == Rotatel4)
			{
				KBoard4 = rotatee1(KBoard4);
				BBoard4 = rotatee(BBoard4);
			}
			if(source == Rotatep1)
			{
				KBoard1 = rotatee1(KBoard1);
				KBoard1 = rotatee1(KBoard1);
				KBoard1 = rotatee1(KBoard1);
				BBoard1 = rotatee(BBoard1);
				BBoard1 = rotatee(BBoard1);
				BBoard1 = rotatee(BBoard1);
			}
			if(source == Rotatep2)
			{
				KBoard2 = rotatee1(KBoard2);
				KBoard2 = rotatee1(KBoard2);
				KBoard2 = rotatee1(KBoard2);
				BBoard2 = rotatee(BBoard2);
				BBoard2 = rotatee(BBoard2);
				BBoard2 = rotatee(BBoard2);
			}
			if(source == Rotatep3)
			{
				KBoard3 = rotatee1(KBoard3);
				KBoard3 = rotatee1(KBoard3);
				KBoard3 = rotatee1(KBoard3);
				BBoard3 = rotatee(BBoard3);
				BBoard3 = rotatee(BBoard3);
				BBoard3 = rotatee(BBoard3);
			}
			if(source == Rotatep4)
			{
				KBoard4 = rotatee1(KBoard4);
				KBoard4 = rotatee1(KBoard4);
				KBoard4 = rotatee1(KBoard4);
				BBoard4 = rotatee(BBoard4);
				BBoard4 = rotatee(BBoard4);
				BBoard4 = rotatee(BBoard4);	
			}
			CheckWin();
			player=!player;
			state=0;
		}
		catch (ExceptionNotRotate e)
		{
			e.printStackTrace();
		}
	}
	
	public void mouse(int x, int y)
	{
		try
		{
		CGameStateChecker.ifPaw(state);
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(win==0 && x>=Board1[i][j].getX() && x<=(Board1[i][j].getX()+75) && y>=Board1[i][j].getY() && y<=(Board1[i][j].getY()+75))
				{
					if(player==true && KBoard1[i][j] == Color.WHITE)
					{
						BBoard1[i][j] = true;
						KBoard1[i][j] = Color.RED;
						state=1;
					}
					else if (player == false && KBoard1[i][j] == Color.WHITE)
					{
						BBoard1[i][j] = true;
						KBoard1[i][j] = Color.BLUE;
						state=1;
					}
				}
				if(win==0 && x>=Board2[i][j].getX() && x<=(Board2[i][j].getX()+75) && y>=Board2[i][j].getY() && y<=(Board2[i][j].getY()+75))
				{
					if(player==true && KBoard2[i][j] == Color.WHITE)
					{
						BBoard2[i][j] = true;
						KBoard2[i][j] = Color.RED;
						state=1;
					}
					else if (player == false && KBoard2[i][j] == Color.WHITE)
					{
						BBoard2[i][j] = true;
						KBoard2[i][j] = Color.BLUE;
						state=1;
					}
				}
				if(win==0 && x>=Board3[i][j].getX() && x<=(Board3[i][j].getX()+75) && y>=Board3[i][j].getY() && y<=(Board3[i][j].getY()+75))
				{
					if(player==true && KBoard3[i][j] == Color.WHITE)
					{
						BBoard3[i][j] = true;
						KBoard3[i][j] = Color.RED;
						state=1;
					}
					else if (player == false && KBoard3[i][j] == Color.WHITE)
					{
						BBoard3[i][j] = true;
						KBoard3[i][j] = Color.BLUE;
						state=1;
					}
				}
				if(win==0 && x>=Board4[i][j].getX() && x<=(Board4[i][j].getX()+75) && y>=Board4[i][j].getY() && y<=(Board4[i][j].getY()+75))
				{
					if(player==true && KBoard4[i][j] == Color.WHITE)
					{
						BBoard4[i][j] = true;
						KBoard4[i][j] = Color.RED;
						state=1;
					}
					else if (player == false && KBoard4[i][j] == Color.WHITE)
					{
						BBoard4[i][j] = true;
						KBoard4[i][j] = Color.BLUE;
						state=1;
					}
				}
				CheckWin();
			}
		}
		}
		catch (ExceptionNotMove e)
		{
		e.printStackTrace();
		}
	}
	
	public void fillBoard()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				Board1[i][j] = new Point(75*(j+1),75*(i+1));
				Board3[i][j] = new Point(75*(j+1),225 + 75*(i+1));
				Board2[i][j] = new Point(225 + 75*(j+1),75*(i+1));
				Board4[i][j] = new Point(225 + 75*(j+1),225 + 75*(i+1));
				BBoard1[i][j] = false;
				BBoard2[i][j] = false;
				BBoard3[i][j] = false;
				BBoard4[i][j] = false;
				KBoard1[i][j] = Color.WHITE;
				KBoard2[i][j] = Color.WHITE;
				KBoard3[i][j] = Color.WHITE;
				KBoard4[i][j] = Color.WHITE;
			}
		}
	}
	
	public static boolean[][] rotatee(boolean P[][])
	{
		boolean N[][] = new boolean[3][3];
		boolean K[] = new boolean[3];
		for(int j=0; j<3; j++)
		{
		 K[2] = P[j][0];
		 K[1] = P[j][1];
		 K[0] = P[j][2];
		 N[0][j] = K[0];
		 N[1][j] = K[1];
		 N[2][j] = K[2];
		}
		return N;
	}
	
	public static Color[][] rotatee1(Color P[][])
	{
		Color N[][] = new Color[3][3];
		Color K[] = new Color[3];
		for(int j=0; j<3; j++)
		{
		 K[2] = P[j][0];
		 K[1] = P[j][1];
		 K[0] = P[j][2];
		 N[0][j] = K[0];
		 N[1][j] = K[1];
		 N[2][j] = K[2];
		}
		return N;
	}
	
	public void CheckWin()
	{				
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCompleteBoard[i][j] = KBoard1[i][j];
			}
		}
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCompleteBoard[i][j+3] = KBoard2[i][j];
			}
		}
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCompleteBoard[i+3][j] = KBoard3[i][j];
			}
		}
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCompleteBoard[i+3][j+3] = KBoard4[i][j];
			}
		}
		horizontally();
		perpenidcularly();
		askew();
		draww();
	}
	
	public void horizontally()
	{
		for(int i=0; i <6 ; i++)
		{
		int licznikn = 0;
		int licznikc = 0;
			for(int j=0; j<5 ; j++)
			{
				if(KCompleteBoard[i][0] != Color.WHITE)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
			licznikn = 0;
			licznikc = 0;
			for(int j=1; j<6 ; j++)
			{
				if(KCompleteBoard[i][5] != Color.WHITE)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}	
		}
	}
	
	public void perpenidcularly()
	{
		for(int i=0; i <6 ; i++)
		{
		int licznikn = 0;
		int licznikc = 0;
			for(int j=0; j<5 ; j++)
			{
				if(KCompleteBoard[0][i] != Color.WHITE)
				{
					if(KCompleteBoard[j][i]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[j][i]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
			
			licznikn = 0;
			licznikc = 0;
			for(int j=1; j<6 ; j++)
			{
				if(KCompleteBoard[5][i] != Color.WHITE)
				{
					if(KCompleteBoard[j][i]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[j][i]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}	
		}
	}
	
	public void askew()
	{
		int licznikn = 0;
		int licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCompleteBoard[0][0] != Color.WHITE && i==j)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=1; j<6 ; j++)
			{
				if(KCompleteBoard[5][5] != Color.WHITE && i==j)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCompleteBoard[5][0] != Color.WHITE && 5==j+i)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=5; j>0 ; j--)
			{
				if(KCompleteBoard[0][5] != Color.WHITE && 5==j+i)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=1; j<6 ; j++)
			{
				if(KCompleteBoard[i][j] != Color.WHITE && 6==j+i)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCompleteBoard[i][j] != Color.WHITE && 4==j+i)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCompleteBoard[i][j] != Color.WHITE && 1==i-j)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=1; j<6 ; j++)
			{
				if(KCompleteBoard[i][j] != Color.WHITE && 1==j-i)
				{
					if(KCompleteBoard[i][j]==Color.BLUE) licznikn++;
					else if(KCompleteBoard[i][j]==Color.RED) licznikc++;
					if(licznikn==5) win=1;
					if(licznikc==5) win=2;
				}
			}
		}
	}
	
	public void draww()
	{
	boolean all=false;
		for(int i=0; i <6 ; i++)
		{
			for(int j=0; j<6 ; j++)
			{
				if(KCompleteBoard[i][j] != Color.WHITE)
				{
					all=true;
				}
				else
				{
					all=false;
					break;
				}
			}
			if(all==false) break;	
		}
		if(all==true && win==0)
		{
			win=3;
		}
	}
	
	public void reset()
	{
		if(reset==1)
		{
			fillBoard();
			win =0;
			state =0;
			reset=0;
			now=0;
		}
	}
}
