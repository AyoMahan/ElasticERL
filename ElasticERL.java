package ElasticERL;
//main file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElasticERL {
	
public void intSetEINThreshold(int size) {
	if (size<=100)
		System.out.println("small data, use");
	else if (size>=100 && size<500000)
		System.out.println("flexible");
	else if(size<=500000)
		System.out.println("large data");
	
}

public void generate() {
	
}

public void allKeys(ElasticERL a) {
	//returns all keys in a sorted sequence
	
}
	
public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		NodeList<Integer> list=new NodeList<Integer>();
		
		
		
		 try {
		      File myObj = new File("EHITS_test_file1.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        int newData=Integer.parseInt(data);
		        list.addLast(newData);
		       
		        
		        //System.out.println(data);
		      }
		      
		      myReader.close();
		     // Temp.setNext(list);
		    } catch (FileNotFoundException e) {
		      System.out.println("File not found.");
		      e.printStackTrace();
		    }
		 ListNode<Integer> p=(ListNode<Integer>) list.first();
//		 while(p.getNext()!=null) {
//			 System.out.println((p.getElement()).toString());
//			 p=p.getNext();
//			 
//		 }
			 
			// System.out.println(p.getElement().toString());//p.next returns a new position pointer from current position
			 System.out.println((list.first()).getElement().toString());
			
			
		 
}
}
