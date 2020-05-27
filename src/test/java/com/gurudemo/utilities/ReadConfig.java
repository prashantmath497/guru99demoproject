package com.gurudemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties props;

	File scr = new File("./Configurations/config.properties");

	public ReadConfig() {
		FileInputStream file;
		try {
			file = new FileInputStream(scr);
			props = new Properties();
			props.load(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String url = props.getProperty("baseurl");
		return url;
	}

	public String getUserId() {
		String userid = props.getProperty("userid");
		return userid;
	}

	public String getPassword() {
		String password = props.getProperty("password");
		return password;
	}

	public String getName() {
		String name = props.getProperty("name");
		return name;

	}

	public String getGender() {
		String gender = props.getProperty("gender");
		return gender;
	}

	public String getDob() {
		String dob = props.getProperty("dob");
		return dob;
	}

	public String getAddress() {
		String add = props.getProperty("address");
		return add;
	}

	public String getCity() {
		String city = props.getProperty("city");
		return city;
	}

	public String getState() {
		String state = props.getProperty("state");
		return state;
	}

	public String getPin() {
		String pin = props.getProperty("pin");
		return pin;
	}

	public String getMobile() {
		String mobile = props.getProperty("mobile");
		return mobile;
	}

	public String getEmail() {
		String email = props.getProperty("email");
		return email;
	}

	public String getPassword1() {
		String pass = props.getProperty("password1");
		return pass;
	}
}
