package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.student;
import com.aqwx.data.Dao.StudentDao;
import com.aqwx.util.util;

public class StudentDaoImpl
  implements StudentDao
{
  @Override
public student getStudent(student u)
  {
    student usr = null;
    SqlSession session = util.getSqlsession();
    usr = (student)session.selectOne("student.selectOne", u);
    return usr;
  }

  @Override
public void update(student u)
  {
    SqlSession session = util.getSqlsession();
    session.update("student.updateOne", u);
    session.commit();
  }

  @Override
public void add(student u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("student.insertOne", u);
    session.commit();
  }

  @Override
public List<student> getStudents(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("student.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("student.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(student u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("student.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public student getStudentById(student u)
  {
    SqlSession session = util.getSqlsession();
    student usr = (student)session.selectOne("student.selectOneById", u);
    return usr;
  }
}