package com.wellsfargo.batch7.basics.service;

import com.wellsfargo.batch7.basics.model.Employee;

@FunctionalInterface
public interface Selectable {
	boolean selected(Employee emp);
}
