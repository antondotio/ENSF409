//package ex3;

public class Demo5 {
	
	//Uncomment this part to test your program!
	
	public static void main(String [] args)
	{
		Demo5 d = new Demo5();
		d.test();

	}


	 public void test(){
		 Date d1 = new Date(2, 3, 1990);
		 Date d2 = new Date(2, 3, 1991);
		 Date d3 = new Date(2, 3, 1992);
		 Date d4 = new Date(2, 3, 1993);

		 LinkedList <Date> dates = new LinkedList <Date>();
		 dates.push_back(1000,  d1);
		 dates.push_back(1001,  d2);
		 dates.push_back(1002,  d3);
		 dates.push_back(1003,  d4);

		 System.out.println("\nPrinting list of dates just after its creation ...\n");
		 dates.print();

		 LinkedList <Integer> intlist = new LinkedList<Integer> ();
		 intlist.push_back(2000,  23);
		 intlist.push_back(2001,  24);
		 intlist.push_back(2002,  266);
		 intlist.push_back(2003,  323);

		 System.out.println("\nPrinting list of Integers just after its creation ...\n");
		 intlist.print();

		 LinkedList<Product> ltpr = new LinkedList<Product>();

		 if (ltpr.size() != 0){
		 System.out.println("\n1. Error: Incorrect size \n");
		 System.exit(1);
		 }

		 Product a = new Product ("Video Card", 2, 11, 1998, 33);
		 Product b = new Product ("Controller", 22, 10, 2008, 93);
		 Product c = new Product ("RAM", 31, 9, 2007, 3);
		 Product d = new Product ("Monitor", 2, 11, 1998, 83);

		 ltpr.push_back(3000, a);
		 ltpr.push_back(3001, b);
		 ltpr.push_back(3002, c);
		 ltpr.push_back(3003, d);

		 if(ltpr.size() != 4){
		 System.out.println("\n2. Error Incorrect size.\n");
		 System.exit(1);
		 }

		 System.out.println("\nPrinting list of products with 4 items ...\n");
		 ltpr.print();
		 ltpr.remove(3000);
		 ltpr.remove(3003);

		 if (ltpr.size() != 2){
		 System.out.println( "\n4. Error: Incorrect size. \n");
		 System.exit(1);
		 }

		 System.out.println( "\nPrinting list of products after two remove operations.\n");
		 ltpr.print();

		 System.out.println ("\nLet's look up some product names ...\n");
		 try_to_find(ltpr, 3002);
		 try_to_find(ltpr, 4000);
		 try_to_find(ltpr, 3001);
		 try_to_find(ltpr, 3000);

		 Point p1 = new Point(6, 8);
		 Point p2 = new Point(11, 34);
		 Point p3 = new Point(9, 109);

		 LinkedList<Point> ltp = new LinkedList<Point> ();
		 ltp.push_back(5000,p1);
		 ltp.push_back(5001, p2);
		 ltp.push_back(5002,p3);

		 System.out.println("\nPrinting list of Points.\n");
		 ltp.print();

		 System.out.println ("\n***----Finished testing----------------***");
		 }

	
	 
	 void print   (LinkedList<?> lt)
		{
			if (lt.size() == 0)
				System.out.println( "  list is EMPTY.\n");
			for (lt.go_to_first(); lt.cursor_ok(); lt.step_fwd()) {
				System.out.println(lt);
			}
		}

		<TYPE> void try_to_find(LinkedList<TYPE>  lt, Integer key)
		{
			lt.find(key);
			if (lt.cursor_ok())

				System.out.println ("Found: " + lt );

			else
				System.out.println("Sorry, couldn't find key: " +  key + " in the table.\n");
		}

}




