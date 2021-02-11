/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.Date;
import java.util.function.Supplier;

public class SupplyLambdFunction {

	public static void main(String[] args) {

		Supplier<Date> currenDate = () -> new Date();
		System.out.println("Current Date --->>" +currenDate.get());

		Supplier<String> randomValue = () -> {
			String opt = "";
			for (int i = 0; i <= 6; i++) {
				opt = opt + (int) (Math.random() * 10);
			}
			return opt;
		};
		System.out.println("Random Value -->" +randomValue.get());
	}
}
