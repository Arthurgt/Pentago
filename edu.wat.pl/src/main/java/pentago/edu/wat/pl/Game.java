package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

public final class Game 
{
	    
	private final static Game instancja = new Game();
	public int wygrana=0;
    public boolean gracz=false;
    public int faza = 0;
    public Point Plansza1[][] = new Point[3][3];
    public boolean BPlansza1[][] = new boolean[3][3];
    public Color KPlansza1[][] = new Color[3][3];
    public Point Plansza2[][] = new Point[3][3];
    public boolean BPlansza2[][] = new boolean[3][3];
    public Color KPlansza2[][] = new Color[3][3];
    public Point Plansza3[][] = new Point[3][3];
    public boolean BPlansza3[][] = new boolean[3][3];
    public Color KPlansza3[][] = new Color[3][3];
    public Point Plansza4[][] = new Point[3][3];
    public boolean BPlansza4[][] = new boolean[3][3];
    public Color KPlansza4[][] = new Color[3][3];
    public Color KCalaPlansza[][] = new Color[6][6];
    private JButton Obrotl1, Obrotp1, Obrotl2, Obrotp2, Obrotl3, Obrotp3, Obrotl4, Obrotp4;
	   
	public static Game getInstance()
	{
		return instancja;
	}

	private Game() 
	{
	    	
	}
	
	public void przyjmij(JButton l1, JButton p1, JButton l2, JButton p2, JButton l3, JButton p3, JButton l4, JButton p4)
	{
		this.Obrotl1=l1;
		this.Obrotp1=p1;
		this.Obrotl2=l2;
		this.Obrotp2=p2;
		this.Obrotl3=l3;
		this.Obrotp3=p3;
		this.Obrotl4=l4;
		this.Obrotp4=p4;
	}
	
	public void przyciski(Object source)
	{
		if(faza == 1 && wygrana==0  )
		{
			if(source == Obrotl1)
			{
				KPlansza1 = obrot1(KPlansza1);
				BPlansza1 = obrot(BPlansza1);		
			}
			if(source == Obrotl2)
			{
				KPlansza2 = obrot1(KPlansza2);
				BPlansza2 = obrot(BPlansza2);
			}
			if(source == Obrotl3)
			{
				KPlansza3 = obrot1(KPlansza3);
				BPlansza3 = obrot(BPlansza3);
			}
			if(source == Obrotl4)
			{
				KPlansza4 = obrot1(KPlansza4);
				BPlansza4 = obrot(BPlansza4);
			}
			if(source == Obrotp1)
			{
				KPlansza1 = obrot1(KPlansza1);
				KPlansza1 = obrot1(KPlansza1);
				KPlansza1 = obrot1(KPlansza1);
				BPlansza1 = obrot(BPlansza1);
				BPlansza1 = obrot(BPlansza1);
				BPlansza1 = obrot(BPlansza1);
			}
			if(source == Obrotp2)
			{
				KPlansza2 = obrot1(KPlansza2);
				KPlansza2 = obrot1(KPlansza2);
				KPlansza2 = obrot1(KPlansza2);
				BPlansza2 = obrot(BPlansza2);
				BPlansza2 = obrot(BPlansza2);
				BPlansza2 = obrot(BPlansza2);
			}
			if(source == Obrotp3)
			{
				KPlansza3 = obrot1(KPlansza3);
				KPlansza3 = obrot1(KPlansza3);
				KPlansza3 = obrot1(KPlansza3);
				BPlansza3 = obrot(BPlansza3);
				BPlansza3 = obrot(BPlansza3);
				BPlansza3 = obrot(BPlansza3);
			}
			if(source == Obrotp4)
			{
				KPlansza4 = obrot1(KPlansza4);
				KPlansza4 = obrot1(KPlansza4);
				KPlansza4 = obrot1(KPlansza4);
				BPlansza4 = obrot(BPlansza4);
				BPlansza4 = obrot(BPlansza4);
				BPlansza4 = obrot(BPlansza4);	
			}
			SprawdzWygrana();
			gracz=!gracz;
			faza=0;
		}
	}
	
	public void myszka(int x, int y)
	{
		if(faza==0)
		{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(wygrana==0 && x>=Plansza1[i][j].getX() && x<=(Plansza1[i][j].getX()+75) && y>=Plansza1[i][j].getY() && y<=(Plansza1[i][j].getY()+75))
				{
					if(gracz==true && KPlansza1[i][j] == Color.WHITE)
					{
						BPlansza1[i][j] = true;
						KPlansza1[i][j] = Color.RED;
						faza=1;
					}
					else if (gracz == false && KPlansza1[i][j] == Color.WHITE)
					{
						BPlansza1[i][j] = true;
						KPlansza1[i][j] = Color.BLUE;
						faza=1;
					}
				}
				if(wygrana==0 && x>=Plansza2[i][j].getX() && x<=(Plansza2[i][j].getX()+75) && y>=Plansza2[i][j].getY() && y<=(Plansza2[i][j].getY()+75))
				{
					if(gracz==true && KPlansza2[i][j] == Color.WHITE)
					{
						BPlansza2[i][j] = true;
						KPlansza2[i][j] = Color.RED;
						faza=1;
					}
					else if (gracz == false && KPlansza2[i][j] == Color.WHITE)
					{
						BPlansza2[i][j] = true;
						KPlansza2[i][j] = Color.BLUE;
						faza=1;
					}
				}
				if(wygrana==0 && x>=Plansza3[i][j].getX() && x<=(Plansza3[i][j].getX()+75) && y>=Plansza3[i][j].getY() && y<=(Plansza3[i][j].getY()+75))
				{
					if(gracz==true && KPlansza3[i][j] == Color.WHITE)
					{
						BPlansza3[i][j] = true;
						KPlansza3[i][j] = Color.RED;
						faza=1;
					}
					else if (gracz == false && KPlansza3[i][j] == Color.WHITE)
					{
						BPlansza3[i][j] = true;
						KPlansza3[i][j] = Color.BLUE;
						faza=1;
					}
				}
				if(wygrana==0 && x>=Plansza4[i][j].getX() && x<=(Plansza4[i][j].getX()+75) && y>=Plansza4[i][j].getY() && y<=(Plansza4[i][j].getY()+75))
				{
					if(gracz==true && KPlansza4[i][j] == Color.WHITE)
					{
						BPlansza4[i][j] = true;
						KPlansza4[i][j] = Color.RED;
						faza=1;
					}
					else if (gracz == false && KPlansza4[i][j] == Color.WHITE)
					{
						BPlansza4[i][j] = true;
						KPlansza4[i][j] = Color.BLUE;
						faza=1;
					}
				}
				SprawdzWygrana();
			}
		}
		}
	}
	
	public void wypelnijPlansze()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				Plansza1[i][j] = new Point(75*(j+1),75*(i+1));
				Plansza3[i][j] = new Point(75*(j+1),225 + 75*(i+1));
				Plansza2[i][j] = new Point(225 + 75*(j+1),75*(i+1));
				Plansza4[i][j] = new Point(225 + 75*(j+1),225 + 75*(i+1));
				BPlansza1[i][j] = false;
				BPlansza2[i][j] = false;
				BPlansza3[i][j] = false;
				BPlansza4[i][j] = false;
				KPlansza1[i][j] = Color.WHITE;
				KPlansza2[i][j] = Color.WHITE;
				KPlansza3[i][j] = Color.WHITE;
				KPlansza4[i][j] = Color.WHITE;
			}
		}
	}
	
	public boolean[][] obrot(boolean P[][])
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
	
	public Color[][] obrot1(Color P[][])
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
	
	public void SprawdzWygrana()
	{				
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCalaPlansza[i][j] = KPlansza1[i][j];
			}
		}
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCalaPlansza[i][j+3] = KPlansza2[i][j];
			}
		}
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCalaPlansza[i+3][j] = KPlansza3[i][j];
			}
		}
		for(int i=0; i <3 ; i++)
		{
			for(int j=0; j<3 ; j++)
			{
				KCalaPlansza[i+3][j+3] = KPlansza4[i][j];
			}
		}
		poziomo();
		pionowo();
		skos();
		remis();
	}
	
	public void poziomo()
	{
		for(int i=0; i <6 ; i++)
		{
		int licznikn = 0;
		int licznikc = 0;
			for(int j=0; j<5 ; j++)
			{
				if(KCalaPlansza[i][0] != Color.WHITE)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
			licznikn = 0;
			licznikc = 0;
			for(int j=1; j<6 ; j++)
			{
				if(KCalaPlansza[i][5] != Color.WHITE)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}	
		}
	}
	
	public void pionowo()
	{
		for(int i=0; i <6 ; i++)
		{
		int licznikn = 0;
		int licznikc = 0;
			for(int j=0; j<5 ; j++)
			{
				if(KCalaPlansza[0][i] != Color.WHITE)
				{
					if(KCalaPlansza[j][i]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[j][i]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
			
			licznikn = 0;
			licznikc = 0;
			for(int j=1; j<6 ; j++)
			{
				if(KCalaPlansza[5][i] != Color.WHITE)
				{
					if(KCalaPlansza[j][i]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[j][i]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}	
		}
	}
	
	public void skos()
	{
		int licznikn = 0;
		int licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCalaPlansza[0][0] != Color.WHITE && i==j)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=1; j<6 ; j++)
			{
				if(KCalaPlansza[5][5] != Color.WHITE && i==j)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCalaPlansza[5][0] != Color.WHITE && 5==j+i)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=5; j>0 ; j--)
			{
				if(KCalaPlansza[0][5] != Color.WHITE && 5==j+i)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=1; j<6 ; j++)
			{
				if(KCalaPlansza[i][j] != Color.WHITE && 6==j+i)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=1; i <6 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				if(KCalaPlansza[i][j] != Color.WHITE && 1==i-j)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
		
		licznikn = 0;
		licznikc = 0;
		for(int i=0; i <5 ; i++)
		{
			for(int j=1; j<6 ; j++)
			{
				if(KCalaPlansza[i][j] != Color.WHITE && 1==j-i)
				{
					if(KCalaPlansza[i][j]==Color.BLUE) licznikn++;
					else if(KCalaPlansza[i][j]==Color.RED) licznikc++;
					if(licznikn==5) wygrana=1;
					if(licznikc==5) wygrana=2;
				}
			}
		}
	}
	
	public void remis()
	{
	boolean wszystkie=false;
		for(int i=0; i <6 ; i++)
		{
			for(int j=0; j<6 ; j++)
			{
				if(KCalaPlansza[i][j] != Color.WHITE)
				{
					wszystkie=true;
				}
				else
				{
					wszystkie=false;
					break;
				}
			}
			if(wszystkie==false) break;	
		}
		if(wszystkie==true && wygrana==0)
		{
			wygrana=3;
		}
	}
}
