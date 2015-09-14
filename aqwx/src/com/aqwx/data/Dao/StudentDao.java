package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.student;

public abstract interface StudentDao
{
  public abstract student getStudent(student paramstudent);

  public abstract student getStudentById(student paramstudent);

  public abstract void update(student paramstudent);

  public abstract void add(student paramstudent);

  public abstract boolean delete(student paramstudent);

  public abstract List<student> getStudents(Map paramMap);

  public abstract int selectCount();
}

