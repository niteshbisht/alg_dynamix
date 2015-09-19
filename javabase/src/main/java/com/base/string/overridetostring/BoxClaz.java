package com.base.string.overridetostring;

import java.util.stream.IntStream;

public class BoxClaz {
	int x, y, z;

	public BoxClaz(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String toString(){
		return "Dimensions are "+this.x+" "+this.y+" "+this.z;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxClaz bxc = new BoxClaz(2, 4, 5);
		String s = "The "+bxc;
		Object o = bxc;
		//StringBuilder sb = new StringBuilder((CharSequence)bxc);
		String p = new String(o.toString());
		//System.out.println(sb);
		System.out.println(p.chars());
		System.out.println(p.subSequence(1, 3));
		System.out.println(p);
		Object te = p.toCharArray();
		Object te2 = p.toCharArray();
		Object[] oe = {te2};
		System.out.println(p.toCharArray());
		System.out.println(te.toString());
		System.out.println(te.equals(p.toCharArray()));
		char res[] = (char[]) te;
		System.out.println(res.length);
		for(char c:res){
			System.out.println(c);
		}
		String s1 = " help";
		System.out.println(s1.regionMatches(0, " help", 0, 5));
		s1.startsWith("h");
		s1.endsWith("lp");
		System.out.println(s1.compareToIgnoreCase(" hElp"));
		s1.lastIndexOf(1);
		s1.lastIndexOf(65537);
		s1.lastIndexOf(" he");
		s1.substring(2);
		s1.concat("hh");
		s1.replace('e', 'q');
		System.out.println("eeeeelee".replace('e', 'q'));
		s1.trim();
		System.out.println(s1.valueOf(1));
		System.out.println(BoxClaz.toString(12));
		System.out.println(BoxClaz.toString(29));
		System.out.println(BoxClaz.toString(99));
		char[] buf=new char[3];
		BoxClaz.getChars(109, 3, buf);
		String str = new String(""+1239647568);
		System.out.println(str);
		char[] care = str.toCharArray();
		System.out.println(care.toString());
		String h1 = "hi";
		String h2 = new String(h1);
		System.out.println(h1.intern()==h2.intern());
		System.out.println(h1.equals(h2));
		System.out.println(h1==h2);
		System.out.println(s1.lastIndexOf('l'));
		System.out.println(s1.substring(2));
		System.out.println(s1.concat("hey"));
		System.out.println(s1.toUpperCase());
		IntStream is = s1.codePoints();	
		System.out.println(is);
	}
	
	public static String toString(int i) {
        if (i == Integer.MIN_VALUE)
            return "-2147483648";
        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf);
    }
	
	// Requires positive x
    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }
	
	static void getChars(int i, int index, char[] buf) {
        int q, r;
        int charPos = index;
        char sign = 0;

        if (i < 0) {
            sign = '-';
            i = -i;
        }

        // Generate two digits per iteration
        while (i >= 65536) {
            q = i / 100;
        // really: r = i - (q * 100);
            r = i - ((q << 6) + (q << 5) + (q << 2));
            i = q;
            buf [--charPos] = DigitOnes[r];
            buf [--charPos] = DigitTens[r];
        }

        // Fall thru to fast mode for smaller numbers
        // assert(i <= 65536, i);
        for (;;) {
            q = (i * 52429) >>> (16+3);
            r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) break;
        }
        if (sign != 0) {
            buf [--charPos] = sign;
        }
    }
	
	final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
        99999999, 999999999, Integer.MAX_VALUE };
	
	final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

	final static char [] DigitTens = {
        '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
        '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
        '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
        '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
        '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
        '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
        '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
        '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
        '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
        } ;
	
	final static char [] DigitOnes = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        } ;
}
