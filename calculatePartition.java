package calculatePartition;

import java.math.BigInteger;
import java.math.BigDecimal;

import static nthRoot.nthRoot.nthRoot;

/*
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

		BigDecimal partitionFactor = calculatePartition( spatialSize, rootFactor );
		System.out.print( partitionFactor.toString( ) );
	}

	public static final BigDecimal calculatePartition( String spatialSize, int rootFactor ){
		BigDecimal size = new BigDecimal( spatialSize );
		
		BigDecimal root = BigDecimal.ONE;
		BigDecimal previousRoot = BigDecimal.ZERO;
		do{
			previousRoot = root;
			root = root.subtract( root.pow( rootFactor ).subtract( size )
				.divide( ( new BigDecimal( rootFactor ) ).multiply( root.pow( rootFactor - 1 ) ) ) );
			System.out.println( root.toString( ) );
		}while( root.compareTo( previousRoot ) == 0 );

		return root;		
	}
}