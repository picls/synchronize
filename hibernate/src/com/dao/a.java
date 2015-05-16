package com.dao;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.*;

import javax.naming.*;

@SuppressWarnings("unused")
public class a {

	private final int[] ii = { 1, 2, 3 };
	public final int iii = 5;
	public int i = 0;
	
	public static void test() {
		out.println(5>2?1:0);
		int i = 1;
		Name n;
		Context c;
		Queue<?> q;
		ArrayList<?> al = new ArrayList<String>();
		Iterator<?> it = al.iterator();
		List<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.removeAll(new LinkedList());
		out.println(l.toString());
		ListIterator lia = l.listIterator();
		ListIterator lib = l.listIterator();
		//lib.add(5);
		lia.next();
		lia.add(4);
		for(Integer ii : l){
			System.out.println(ii);
		}
		//out.println(l.get(0));
		out.println(l.toString());
		HashMap<String,String> hm;
		
		Set set = new HashSet();
		set.add(1);
		set.add(2);
		set.add(8);
		set.add(5);
		TreeSet<Integer> ts = new TreeSet<Integer>(set);
		out.println("-----------------");
		for(Integer ii : ts)
			out.println(ii);
		
		Comparator com;
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue();
		pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
		pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
		pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
		pq.add(new GregorianCalendar(1910,Calendar.JULY,22));
		
		out.println("iterating:");
		for(GregorianCalendar date : pq)
			out.println(date.get(Calendar.YEAR));
		out.println("removing:");
		while(!pq.isEmpty())
			out.println(pq.remove().get(Calendar.YEAR));
		
		
		
	}

	public static void main(String args[]) {
		test();
		exit(0);
		System.out.println(new int[] {1,2,3}.getClass().getName());
		System.out.println(new String[10].getClass().getName());
		System.out.println(new ArrayList<String>().getClass().getName());
		int i = 3;
		{
			//int i = 5;
		}
		Scanner sc = new Scanner(in);
		//out.println("input sa:");
		//String sa = sc.nextLine();
		out.printf("hello,%s.You'll be in room %,d. %n", "yjx", 246460);
/*		out.println(System.getProperty("user.dir"));
		Properties p = System.getProperties();
		p.list(out);
		out.flush();*/
		
		
		a ab = new a();
		ab.ii[1] = 0;
		System.out.println(ab.ii[1]);
		StringBuffer sb;

		String s = "hello";
		String ss = "he";
		String sss = "llo";
		ss = ss + sss;
		System.out.println(s == ss);
		System.out.println(s.getBytes());
		for (Byte b : s.getBytes())
			System.out.print(b + " ");
		try {
			System.out.println();
			for (Byte b : s.getBytes("utf-8"))
				System.out.print(b + " ");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		out.println("a".compareTo("i"));
		out.println("xxxxxxxxxxxxxxx".hashCode());
		
		StringBuilder builder;
		StringBuffer buffer;
	}

}
