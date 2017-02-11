package com.lb.jwitter.util;

public class ConditionReport<ValueClass> {
	private String col;
	private ValueClass value1;
	private ValueClass value2;
	private String operator;
	private String type;
	
	/**
	 * @return the col
	 */
	public String getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public ValueClass getValue1() {
		return value1;
	}
	public void setValue1(ValueClass value1) {
		this.value1 = value1;
	}
	public ValueClass getValue2() {
		return value2;
	}
	public void setValue2(ValueClass value2) {
		this.value2 = value2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
