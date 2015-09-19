package com.base.java.generics.type.inference;

public class BoxDemo {
	
	// Type inference is a Java compiler's ability to look at each method
		// invocation and corresponding declaration to determine the type argument
		// (or arguments) that make the invocation applicable. The inference
		// algorithm determines the types of the arguments and, if available, the
		// type that the result is being assigned, or returned. Finally, the
		// inference algorithm tries to find the most specific type that works with
		// all of the arguments.
	
	public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
		Box<U> box = new Box<>();
		box.setU(u);
		boxes.add(box);
	}

	public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
		int counter = 0;
		for (Box<U> box : boxes) {
			U boxContents = box.getU();
			System.out.println("Box #" + counter + " contains ["
					+ boxContents.toString() + "]");
			counter++;
		}
	}

	public static void main(String[] args) {
		java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();
		BoxDemo.<Integer> addBox(Integer.valueOf(10), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		BoxDemo.outputBoxes(listOfIntegerBoxes);
	}
}
