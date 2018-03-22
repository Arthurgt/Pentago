package exceptions;

public class ZStanGry 
{
	public static void czyObrot(int faza, int wygrana) throws ExceptionNotRotate
	{
		if(faza == 1 && wygrana == 0)
		{
			
		}
		else
		{
			throw new ExceptionNotRotate("Nie czas na obrot");
		}
	}
	public static void czyPionek(int faza) throws ExceptionNotMove
	{
		if(faza == 0)
		{
			
		}
		else
		{
			throw new ExceptionNotMove("Nie czas na ruch pionka");
		}
	}
}
