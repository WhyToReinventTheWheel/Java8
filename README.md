Study Notes: Ref- https://www.tutorialspoint.com/java8/

* http://www.mkyong.com/tutorials/java-8-tutorials/

	* Lambda expression	− Adds functional processing capability to Java.
	* Method references	− Referencing functions by their names instead of invoking them directly.Using functions as parameter.
	* Default method	− Interface to have default method implementation.
	* New tools			− New compiler tools and utilities are added like ‘jdeps’ to figure out dependencies.
	* Stream API		− New stream API to facilitate pipeline processing.
	* Date Time API		− Improved date time API.
	* Optional			− Emphasis on best practices to handle null values properly.
	

Lambda expression
	
	public class Greeter {
		public void greet(Greeting greeting) {
			greeting.perform();
		}
		
		public static void main(String[] args) {
			Greeter greeter = new Greeter();
			Greeting lambdaGreeting = () -> System.out.println("Hello world!");
			
			Greeting innerClassGreeting = new Greeting() {
				public void perform() {
					System.out.println("Hello world!");
				}
			};
			
			greeter.greet(lambdaGreeting);
			greeter.greet(() -> System.out.println("Hello world!"));
			greeter.greet(innerClassGreeting);
		}
	}
		
	
Method Reference 

	* Static methods
	* Instance methods
	* Constructors using new operator (TreeSet::new)
		
	public class MethodReference {
		public static void main(String args[]) {
			Consumer<String> test = (value) -> System.out.println("TEST:" + value);
			List<String> names = new ArrayList();
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
	
	public class MethodReferenceExample {
		public static void main(String[] args) {
			List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Carroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Matthew", "Arnold", 39)
					);
			System.out.println("Printing all persons");
			performConditionally(people, p -> true, System.out::println); // p -> method(p)
		}

		private static void performConditionally(List<Person> people, Predicate<Person> predicate
								, Consumer<Person> consumer) {
			for (Person p : people) {
				if (predicate.test(p)) {
					consumer.accept(p);
				}
			}
		}
	}

Default Methods
	
	public interface vehicle {
		default void print() {
			System.out.println("I am a vehicle!");
		}
	}
	
What is Stream?
	
	Stream represents a sequence of objects from a source, which supports aggregate operations. 
	Following are the characteristics of a Stream −
	Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.

	* Source − Stream takes Collections, Arrays, or I/O resources as input source.

	* Aggregate operations − Stream supports aggregate operations like filter, map, 
		limit, reduce, find, match, and so on.

	* Pipelining − Most of the stream operations return stream itself so that their 
		result can be pipelined. These operations are called intermediate operations and their 
		function is to take input, process them, and return output to the target. collect() 
		method is a terminal operation which is normally present at the end of the pipelining 
		operation to mark the end of the stream.

	* Automatic iterations − Stream operations do the iterations internally over the source elements 
		provided, in contrast to Collections where explicit iteration is required.
		
	
	Generating Streams
	
		stream() − Returns a sequential stream considering collection as its source.
		parallelStream() − Returns a parallel Stream considering collection as its source.
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		long count = strings.stream().filter(string -> string.length() == 3).count();
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
	
Optional Class
	
	Optional is a container object used to contain not-null objects. Optional object is used to 
	represent null with absent value. This class has various utility methods to facilitate code to 
	handle values as ‘available’ or ‘not available’ instead of checking null values.
	
	Integer value1 = null;
	Integer value2 = new Integer(10);

	//Optional.ofNullable - allows passed parameter to be null.
	Optional<Integer> a = Optional.ofNullable(value1);

	//Optional.of - throws NullPointerException if passed parameter is null
	Optional<Integer> b = Optional.of(value2);
	
	
