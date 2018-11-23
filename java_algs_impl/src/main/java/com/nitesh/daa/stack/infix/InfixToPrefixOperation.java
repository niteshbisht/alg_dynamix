package com.nitesh.daa.stack.infix;

import java.util.LinkedList;

class SymbolType {
	String symName;
	int symWeight;
	public SymbolType() {
		
	}
}

public class InfixToPrefixOperation {

	LinkedList<SymbolType> tempStack = new LinkedList<>();
	StringBuilder sb = new StringBuilder();
	public void solve(char[] data) {
		for(int i=0;i<data.length; i++) {
			char c = data[i];
			SymbolType checkSymbolType = checkSymbolType(c);
			if(checkSymbolType==null) {
				this.sb.append(c);
			}else {
				if(tempStack.size()>0) {
					int prior = this.priority(checkSymbolType);
					if(prior==0) {
						SymbolType pop = tempStack.pop();
						sb.append(pop.symName);
					}
					if(prior==1) {
						SymbolType pop = tempStack.pop();
						sb.append(pop.symName);
						tempStack.push(checkSymbolType);
						continue;
					}
					if(prior==-1) {
						tempStack.push(checkSymbolType);
						continue;
					}
				}else {
					tempStack.push(checkSymbolType);
				}
			}
		}
	}
	
	SymbolType checkSymbolType(char c){
		SymbolType sym = null;
		if(c=='(') {
			sym = new SymbolType();
			sym.symName = "left(";
			sym.symWeight = 4;
		}
		if(c==')') {
			sym = new SymbolType();
			sym.symName = "right)";
			sym.symWeight = 4;
		}
		if(c=='*') {
			sym = new SymbolType();
			sym.symName = "star";
			sym.symWeight = 3;
		}
		if(c=='/') {
			sym = new SymbolType();
			sym.symName = "slash";
			sym.symWeight = 3;
		}
		if(c=='+') {
			sym = new SymbolType();
			sym.symName = "plus";
			sym.symWeight = 2;
		}
		if(c=='-') {
			sym = new SymbolType();
			sym.symName = "minus";
			sym.symWeight = 2;
		}
		
		return sym;
	}
	
	int priority(SymbolType nextSymbol) {
		SymbolType symAtTop = this.tempStack.peek();
		if(symAtTop.symName.equalsIgnoreCase(nextSymbol.symName)) {
			return 0;
		}else {
			if(symAtTop.symWeight == nextSymbol.symWeight) {
				return 0;
			} else if(symAtTop.symWeight > nextSymbol.symWeight) {
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
