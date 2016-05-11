package basics;

class TestStatic {

	static class TestInner{
		int p ;
		int z;
		String str;
		public TestInner() {
		}
	
		public void testInnerAnonym(){
			
		}
	}
	
	public static void main(String[] args) {
		TestInner tic = new TestInner();
		tic.testInnerAnonym();
		System.out.println(tic.str);
	}
	
}
