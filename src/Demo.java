
public class Demo {
	
	public static void main(String[] args) {
		
		int array[] = new int [] {12,-7,9,-8,3,2,1};
		
		int min = Integer.MAX_VALUE;
		
		int min1Index = -1;
		int min2Index = -1;
		
		
		for(int i=0; i<array.length; i++) {
			int x = array[i];
			for(int j=i+1; j<array.length; j++) {
				int y = array[j];
				
				int diff = Math.abs(x+y);
				if(diff<min) {
					min = diff;
					min1Index = i;
					min2Index = j;
				}
			}
		}
		
		System.out.println("Element 1 = "+array[min1Index]);
		System.out.println("Element 2 = "+array[min2Index]);
	}

}

interface Animal {
	public void bark();
	public default void eat() {
		System.out.println("I am eating");
	}
}

class Dog implements Animal {

	@Override
	public void bark() {
		
		System.out.println("bbbbbb");
	}
	
}


class Cat implements Animal {

	@Override
	public void bark() {
		
		System.out.println("bbbbbb");
	}
	
}


class Human implements Animal {

	@Override
	public void bark() {
		
		System.out.println("bbbbbb");
	}
	
}

