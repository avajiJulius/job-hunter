package com.jobhunter.employeeform.dao;

import com.jobhunter.employeeform.domain.EmployeeForm;
import com.jobhunter.employeeform.exception.DaoException;

import java.util.List;

public interface EmployeeFormDao {
    Long saveEmployeeForm(EmployeeForm employeeForm) throws DaoException;
    List<EmployeeForm> getEmployeeForm() throws DaoException;
}
