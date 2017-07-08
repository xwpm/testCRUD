package com.test.dbcfg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 读取 Properties 文件数据
 * 
 * @author Administrator
 *
 */
public class PropertiesConfigRead {

	private static Properties prop = new Properties();

	static {
		InputStream in = PropertiesConfigRead.class.getResourceAsStream("/db.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			System.out.println("读取 Properties 文件数据 异常！" + e.getMessage());
		}
	}

	public static String getPropertyValue(String key) {

		if (!StringUtils.isNotBlank(key.trim())) {
			try {
				throw new Exception("Properties读取时，key 不能为null");
			} catch (Exception e) {
				System.out.println("Properties读取时，key 不能为null");
			}
		}

		String val = prop.getProperty(key);
		return val;

	}

	public static void main(String[] args) {
		String value = PropertiesConfigRead.getPropertyValue("ORCL_ORACLEDRIVER");
		System.out.println(value);
	}

}
