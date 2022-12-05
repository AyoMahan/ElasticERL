package ElasticERL;

//main file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElasticERL<E> {

	public ElasticERL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void intSetEINThreshold(int size) {
		if (size <= 100)
			System.out.println("small data, use");
		else if (size >= 100 && size < 500000)
			System.out.println("flexible");
		else if (size <= 500000)
			System.out.println("large data");

	}

	public void generate() {

	}

	public void allKeys(ElasticERL a) {
		// returns all keys in a sorted sequence

	}

	public static Position add(NodeList list, int key, String v) {
		list.addLast(key);
		ListNode p = (ListNode) list.tail.getPrev();
		p.setValue(v);
		return p;
	}

	public static int remove(NodeList list, int key) {
		ListNode p = (ListNode) list.first();
		int removedVal;
		while (p.getNext() != null) {
			if (key == (int) p.getElement()) {
				System.out.println("Key found");
				removedVal = (int) p.getElement();
				list.remove(p);
				return removedVal;
			}
			p = p.getNext();
		}
		System.out.println("Key not found");
		return -1;
	}
	
	public static String getValues(NodeList list, int key) {
		ListNode p = (ListNode) list.first();
		String v;
		while (p.getNext() != null) {
			if (key == (int) p.getElement()) {
				System.out.println("Key found");
				v = (String) p.getValue();
				return v;
			}
			p = p.getNext();
		}
		return "The key " + key + " was not found";
	}
	
	public static int rangeKey(NodeList list, int key1, int key2) {
		ListNode p = (ListNode) list.first();
		boolean flag = false;
		int counter = 0;
		while (p.getNext() != null) {
			if (key1 == (int) p.getElement()) {
				flag = true;
				if	(counter > 1) {
					System.out.println("Same key is found again");
				}
				else {
					System.out.println("1st key is found");
				}
			}

			if	(flag == true) {
				counter++;
			}
			
			if	(counter != 1 && key2 == (int) p.getElement()) {
				System.out.println("2nd key is found");
				flag = false;
				break;
			}
			p = p.getNext();
		}
		return counter-2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList<Integer> list = new NodeList<Integer>();
		try {
			File myObj = new File("EHITS_test_file1.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				int newData = Integer.parseInt(data);
				list.addLast(newData);

				// System.out.println(data);
			}

			myReader.close();
			// Temp.setNext(list);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		ListNode p = (ListNode) list.first();
		System.out.println(p.getElement().toString());
		add(list, 123, "This is the value of node with key 123");
		long ans = rangeKey(list, 33240013, 123);
		System.out.println("The number of elements betwen the two keys is: " + ans);

//		System.out.println(list.tail.getPrev().getElement().toString());
//		System.out.println(list.tail.getPrev().getValue());
//		System.out.println(getValues(list, 123));
//		System.out.println(getValues(list, 0));
//		 while(p.getNext()!=null) {
//			 System.out.println((p.getElement()).toString());
//			 p=p.getNext();
//			 
//		 }

		// System.out.println(p.getElement().toString());//p.next returns a new position
		// pointer from current position
		//System.out.println((list.first()).getElement().toString());

	}
}
