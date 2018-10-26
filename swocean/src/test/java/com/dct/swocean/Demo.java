package com.dct.swocean;

import java.util.Date;
import java.util.Random;

import com.dct.swocean.util.DateUtil;

public class Demo {

	public static void main(String[] args) {
		/*
		 * String format = DateUtil.format(new Date(), "yyyyMMddHHmmss"); for (int i =
		 * 0; i < 10; i++) { String random = String.format("%02d", new
		 * Random().nextInt(100)); String id = "user" + format + random;
		 * System.out.println(id); }
		 */
		for (int i = 0; i < 10; i++) {
			System.out.println((int) ((Math.random() * 9 + 1) * 1000));
		}
	}

}
