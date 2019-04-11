package src1;

import java.io.*;

public class lzw
{
	public static void main ( String[] args )
	{
		FileInputStream  input  = null;
		FileOutputStream output = null;
		
		if( args[0] == "" )
		{
			System.out.println( "Usage: java lzw <filename>" );
			System.exit( 1 );
		}
		
		try
		{
			input = new FileInputStream( args[0] );
		} 
		catch ( FileNotFoundException fnfe )
		{
			System.out.println( "Unable to open input file: " + args[0] );
			System.exit( 1 );
		}
		
		try
		{
			output = new FileOutputStream( "compressed.lzw" );
		} 
		catch ( FileNotFoundException fnfe )
		{
			System.out.println( "Unable to open output file compressed.lzw " );
			System.exit( 1 );
		}

		LZWCompression lzw = new LZWCompression( input, output );
		
		lzw.compress();		/* compress the file */
		
		try
		{
			input.close();
			output.close();
		}
		catch ( IOException ioe )
		{
			System.out.println( "IOException in main()." );
			System.exit(1);
		}
		
		System.out.println( "Done! Compressed file: compressed.lzw");
	}
}
	
