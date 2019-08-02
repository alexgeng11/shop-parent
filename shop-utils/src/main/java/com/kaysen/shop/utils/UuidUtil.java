package com.kaysen.shop.utils;

import java.util.UUID;

/**
 * 描叙：取uuid
 * 创建人：HeGuifang
 * 创建时间：2016年5月23日 下午4:26:57
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}

