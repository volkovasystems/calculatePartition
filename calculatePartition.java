package calculatePartition;

import java.math.RoundingMode;
import java.math.BigDecimal;

import static nthRoot.nthRoot.nthRoot;

/*                                                          ll
	NOTE: Always compile with '-d .' 
		And always run with <package-name>.<class-name> format
*/
public class calculatePartition{
	private static final int DEFAULT_ROOT_FACTOR = 2;
	
	public static void main( String... parameterList ){

		String spatialSize = parameterList[ 0 ];

		int rootFactor = DEFAULT_ROOT_FACTOR;

		if( parameterList.length == 2 ){
			try{
				rootFactor = Integer.parseInt( parameterList[ 1 ] );

			}catch( Exception exception ){
				System.err.print( exception.getMessage( ) );
				return;
			}
		}

		try{
			BigDecimal partitionFactor = calculatePartition( spatialSize, rootFactor );

			System.out.print( partitionFactor.toString( ) );

		}catch( Exception exception ){
			System.err.print( exception.getMessage( ) );
		}
	}

	public static final BigDecimal calculatePartition( String spatialSize, int rootFactor )
		throws Exception
	{
		/*
			Note that this will return the number of partitions not the number of elements per partition.

			Future implementation will require to return multi level partition size.
		*/
		
		BigDecimal partitionFactor = nthRoot( spatialSize, "" + rootFactor, "4", 2 );

		BigDecimal partitionSize = ( new BigDecimal( spatialSize ) ).divide( partitionFactor );

		return partitionSize.setScale( 0, RoundingMode.FLOOR );
	}
}