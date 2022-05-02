package model;

public class List {
	Turn head;
	Turn tail;
	
	public void add() {
		Turn turn = new Turn();
		if(head==null) {
			turn.setValue(1);
			head=turn;
			tail=turn;
			head.setNext(head);
			head.setPrev(head);
		}else {
			int t = tail.getValue()+1;
			turn.setValue(t);
			tail.setNext(turn);
			
			turn.setPrev(tail);
			
			head.setPrev(turn);
			turn.setNext(head);
			
			tail = turn;
		}
	}
	public void print() {
		if(null==head) {
			System.out.println("There is no turns in this list");
			return;
		}
		System.out.println(head.getValue());
	}
	public boolean deleteActualTurn() {
		boolean out = false;
		if(head==null) {
			return false;
		}else {
			if(head==head.getNext()) {
				head=null;
				return true;
			}
			tail.setNext(head.getNext());
			head.getNext().setPrev(tail);
			head=head.getNext();
			out=true;
		}
		return out;
	}
	public void passTurn() {
		if(null==head) {
			System.out.println("There is no turns in this list");
			return;
		}
		head.setPassed(head.getPassed()+1);
		if(head.getPassed()>=3) {
			deleteActualTurn();
		}else {
			Turn t = head.getNext();
			tail=head;
			head=t;
		}
	}
	
}
