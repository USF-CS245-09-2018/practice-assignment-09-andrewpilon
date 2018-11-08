// Andrew Pilon

public class BinaryHeap {
	
	int size;
	int capacity;
	int [] heap;

	public BinaryHeap() {
		capacity = 10;
		size = 0;
		heap = new int[capacity]; // initialize array with length 10
	}

	public void add(int data) {
		if (size == capacity) { // check if we need to expand the heap array
			growArray();
		}
		heap[size++] = data; // add data to end of array and increment size
		// now place data at correct index in array
		int prev = size-1;
		int parent = (prev-1)/2;
		while (prev > 0 && heap[prev] < heap[parent]){
			swap(prev, parent);
			prev = parent;
			parent = (prev-1)/2;
		}
	}

	public int remove() {
		int removed = heap[0]; // we will remove the root entry
		heap[0] = heap[size-1];
		size--;
		shiftdown(0);
		return removed;
	}

	public void swap(int a, int b){
		int temp =	heap[a];
		heap[a] =	heap[b];
		heap[b] = temp;
	}

	public void shiftdown(int parent){
		int child = parent*2+1;
		if (child >= size){ // last step
			return;
		}
		// check left and right values
		if (heap[child + 1] < heap[child]){
			child++;
		}
		if (heap[parent] > heap[child]){
			swap(child, parent);
			shiftdown(child);
		}
	}

	public void growArray(){
		int[] newHeap = new int[capacity*2];
		for (int i = 0; i < capacity; i++){ // populate new array
			newHeap[i] = heap[i];
		}
		heap = newHeap;
		capacity *= 2;
	}
}