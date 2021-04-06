
public class Container {

	int id;
	int contMove;
	
	public Container(int id)
	{
		this.id = id;
		this.contMove = contMove++;
	}
	
	
	//Getters
	public int getId()
	{
		return id;
	}
	public int getContMove()
	{
		return contMove;
	}
	//Setters
	public void setId(int id)
	{
		this.id = id;
	}
	public void setContMove(int contMove)
	{
		this.contMove = contMove;
	}
	
	@Override
	public String toString() {
		return "Container [id=" + id + ", contMove=" + contMove + "]";
	}
	
}
