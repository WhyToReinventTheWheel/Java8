package com.mk;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
@FunctionalInterface
public interface Consumer<T>{
	void accept(T t)
}

Predicate <T>{

}
*/

public class MethodReference {

	public static void main(String args[]) {

		Consumer<String> test = (value) -> System.out.println("TEST:" + value);

		List<String> names = new ArrayList();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);

		names.forEach(test);

		MethodReference obj = new MethodReference();

		names.forEach(obj::instancMethod);
	}

	static void staticMethod(String value) {
		System.out.println("Static-method:" + value);
	}

	void instancMethod(String value) {
		System.out.println("Instanc-Method:" + value);
	}
}
