package Test11_8;

class SortedInArray{
	int capacity;
	int size;
	Integer[] rep;
	public SortedInArray(int n) {
		capacity = n;
		rep = new Integer[capacity];
	}
	//开100个对象的空间
	public SortedInArray() {
		this(100);
	}
	//二分查找法:找中间值
	int search(int i, int lower, int upper){
		int index = lower;
		if(upper>=lower){
			int middle = (upper+lower)/2;
			int current = rep[middle].intValue();
			if(current==i){
				index = middle;
			}
			else if(current<i){
				index = search(i,middle+1,upper);
			}
			else{
				index = search(i,lower,middle-1);
			}
		}
		return index;
	}
	int search(int i){
		return search(i,0,size-1);
	}
	
	SortedInArray insert(int i){
		int index =  search(i);//找不到会存在两个数之间插入
		for(int j=size;j>index;--j){
			rep[j] = rep[j-1];
		}
		rep[index] = new Integer(i);
		++size;
		return this;
	}
	
	SortedInArray remove(int i){
		int index = search(i);
		if(rep[index].intValue()==i){
			--size;
			for(int j=index;j<size;j++){
				rep[j]=rep[j+1];
			}
		}
		return this;
	}
	
	public String toString(){
		String toReturn="";
		for(int i=0;i<size;++i){
			toReturn += rep[i].toString()+",";
		}
		return toReturn;
	}
	
	
}

public class BinarySearch {
public static void main(String[] args) {
	SortedInArray anArray = new SortedInArray();
	anArray.insert(4).insert(5).insert(7).insert(7).insert(3).insert(2);
	System.out.println(anArray);
	anArray.remove(7).remove(4);
	System.out.println(anArray);
}
}
