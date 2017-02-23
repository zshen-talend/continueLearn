package db.hibernate.zjy.struts.form;

import java.util.*;
import java.sql.*;
import java.math.BigDecimal;
import org.apache.struts.action.ActionForm;

public class StuinfoForm extends ActionForm {
	private Integer id;
	private String score;
	private String classes;
	private String name;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
}