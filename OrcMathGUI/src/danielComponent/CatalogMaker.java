package danielComponent;

import java.util.ArrayList;

public class CatalogMaker 
{
	private ArrayList<Movie> movies;
	
	public CatalogMaker()
	{
		movies = new ArrayList<Movie>();
		
		movies.add(0,new Movie("The Terminator", "James Cameron", 1984));
		movies.add(1, new Movie("The Titanic", "James Cameron", 1997));
		
	}
	
	public static void main(String[] args) 
	{
		
	}

}
