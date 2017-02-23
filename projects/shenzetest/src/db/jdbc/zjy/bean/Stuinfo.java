package db.jdbc.zjy.bean;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.math.BigDecimal;

public class Stuinfo implements Serializable {
	private String score;
	private String classes;
	private String name;
	private Integer id;

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getClasses() {
		return this.classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}