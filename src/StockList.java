
import java.util.ArrayList;

public class StockList {
	static ArrayList<Stock> arr = new ArrayList<Stock>();
	static final String LEFT_CORNER_LINE_TOP = (char)0x2554+"";
	static final String RIGHT_CORNER_LINE_TOP = (char)0x2557+"";
	static final String MIDDLE_CORNER_LINE_TOP = (char)0x2564+"";
	static final String MIDDLE_CORNER_LINE_DOWN = (char)0x2567+"";
	static final String HORIZONTAL_LINE = (char)0x2550+"";
	static final String LEFT_CORNER_LINE_BOTTOM = (char)0x255A+"";
	static final String RIGHT_CORNER_LINE_BOTTOM = (char)0x255D+"";
	static final String LEFT_CORNER_LINE_CONTENT = (char)0x2560+"";
	static final String RIGHT_CORNER_LINE_CONTENT = (char)0x2563+"";
	
	public static void out(String str){
		System.out.print(str);
	}
	public static String displayPageNumber(){
		String page = "Page: 1 / "+arr.size();
		return page;
	}
	public static String getTotalRecord(){
		String total = "Total Record: "+arr.size();
		return total;
	}
	
	public static String drawHeaderLine(int width, int numBloc, String leftCorner, String middleCorner,String rightCorner){
		String result = leftCorner;
		int intBloc = width / numBloc;
		for(int i=1; i<width-1; i++){
			if(i % intBloc == 0)
				result+=middleCorner;
			result+=HORIZONTAL_LINE;
		}
		result+=rightCorner;
		return result;
	}
	public static String drawContentOrBottomLine(int width, String leftCorner, String rightCorner){
		String result = leftCorner;
		for(int i=0; i<width+2; i++){
			result+=HORIZONTAL_LINE;
		}
		result+=rightCorner;
		return result;
	}
	public static void displayMenu(){
		String topLine = drawContentOrBottomLine(100,LEFT_CORNER_LINE_TOP,RIGHT_CORNER_LINE_TOP);
		String bottomLine = drawContentOrBottomLine(100,LEFT_CORNER_LINE_BOTTOM,RIGHT_CORNER_LINE_BOTTOM);
		String leftAlignFormat = " %10s |%8s |%8s  | %8s | %8s  | %8s  | %10s | %6s | %10s | %n"+
				"    %8s  |%8s  |%10s |%7s |%9s |%10s  |%6s | %10s %n";
		out(topLine+"\n");
		System.out.format(leftAlignFormat, 
				"*)Display", 
				"W)rite", 
				"R)ead", 
				"U)pdate",
				"D)elete",
				"F)irst",
				"P)revious",
				"N)ext",
				"L)ast",
				
				"S)earch",
				"G)o to",
				"Se)t row",
				"S)ave",
				"B)ackup",
				"Re)store",
				"H)elp",
				"E)xit"
				);
		out(bottomLine);
	}
	
	/**
	 * Add default objects to array
	 * @param num : number of objects
	 */
	public static void addDefaultObjectToArray(int num){
		int size = 10_000_000;
		Stock b = new Stock(1,"Name",0.00,0,"01/01/2016");
		for(int i=1; i<=size; i++){
			arr.add(b);			
		}
	}
	public static void readDefaultObjectFromArray(){

		//Read
		String leftAlignFormat = "| %-18d| %-19s| %-19.2f| %-19d| %-18s|%n";
		String contentLine = drawContentOrBottomLine(100,LEFT_CORNER_LINE_CONTENT,RIGHT_CORNER_LINE_CONTENT)+"\n";
		Stock r[] = arr.toArray(new Stock[arr.size()]);		
		
		for(int i=r.length-1;i>=r.length-5;i--){
			
			System.out.format(leftAlignFormat, 
					i+1, 
					r[i].getName(), 
					r[i].getUnitPrice(), 
					r[i].getQty(),
					r[i].getImportedDate()
					);
			
			out(contentLine);
		}
		
		
		
	}
	public static void main(String args[]) {
//		out(drawHeaderLine(15,3,LEFT_CORNER_LINE_TOP,MIDDLE_CORNER_LINE_TOP,RIGHT_CORNER_LINE_TOP)+"\n");
//		out(drawHeaderLine(15,3,LEFT_CORNER_LINE_CONTENT,MIDDLE_CORNER_LINE_DOWN,RIGHT_CORNER_LINE_CONTENT)+"\n");
//		out(drawContentOrBottomLine(15,LEFT_CORNER_LINE_CONTENT,RIGHT_CORNER_LINE_CONTENT)+"\n");
//		out(drawContentOrBottomLine(15,LEFT_CORNER_LINE_BOTTOM,RIGHT_CORNER_LINE_BOTTOM)+"\n");
	
		//displayMenu();
		
		// ArrayList add
		long startTime = System.currentTimeMillis();
		addDefaultObjectToArray(1000_000_000);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);
		
		// read
		String topHeaderLine = drawHeaderLine(100,5,LEFT_CORNER_LINE_TOP,MIDDLE_CORNER_LINE_TOP,RIGHT_CORNER_LINE_TOP);
		String leftAlignFormat = "| %9s         |   %9s        |    %12s    | %13s      | %15s   |%n";
		String underHeaderLine = drawHeaderLine(100,5,LEFT_CORNER_LINE_CONTENT,MIDDLE_CORNER_LINE_DOWN,RIGHT_CORNER_LINE_CONTENT);
		String bottomLine = drawContentOrBottomLine(100,LEFT_CORNER_LINE_BOTTOM,RIGHT_CORNER_LINE_BOTTOM);
		//startTime = System.currentTimeMillis();
		
		out(topHeaderLine+"\n");
		System.out.format(leftAlignFormat, 
				"ID", 
				"NAME", 
				"UNIT PRICE", 
				"QUANTITY",
				"IMPORTED DATE"
				);
		out(underHeaderLine);
		out("\n");
		readDefaultObjectFromArray();
		
		System.out.format("| %-49s %50s |%n",displayPageNumber(),getTotalRecord());
		out(bottomLine);
		out("\n");
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("ArrayList read:  " + duration);
		
		
	}

}
