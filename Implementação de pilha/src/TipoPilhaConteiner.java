
public class TipoPilhaConteiner {
	
	public final int N = 4;
	Container dados[] = new Container[N];
	int topo;
	
	
	public void init()
	{
		topo = 0;
	}
	public boolean isFull()
	{
		if(topo == N)
			return true;
		else
			return false;
	}
	public boolean isEmpty()
	{
		if(topo == 0)
			return true;
		else 
			return false;
	}
	public void push(Container valor)
	{
		if(!isFull())
		{
			dados[topo] = valor;
			topo++;
		}
		else
			System.out.println("Stack Over Flow!");
	}
	public Container pop()
	{
		topo--;
		return dados[topo];
	}
	public Container top()
	{
		return dados[topo-1];
	}
	public void esvaziar()
	{
		while(!isEmpty())
		{
			System.out.println(" " + pop());
		}
	}
	
}
