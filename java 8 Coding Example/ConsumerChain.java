/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.function.Consumer;

class Movie{
	String name;
	Movie(String name){
		this.name = name;
	}
}
public class ConsumerChain {

	public static void main(String[] args) {

		Consumer<Movie> c1 =  m->System.out.println(m.name+ " Created");
		Consumer<Movie> c2 =  m->System.out.println(m.name+ " Released");
		Consumer<Movie> c3 =  m->System.out.println(m.name+ " Floop");
		c1.andThen(c2).andThen(c3).accept(new Movie("EK tha tiger"));
	}

}


