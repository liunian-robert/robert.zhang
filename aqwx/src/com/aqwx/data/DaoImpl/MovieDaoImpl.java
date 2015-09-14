package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.movie;
import com.aqwx.data.Dao.MovieDao;
import com.aqwx.util.util;

public class MovieDaoImpl
  implements MovieDao
{
  @Override
public movie getMovie(movie u)
  {
    movie usr = null;
    SqlSession session = util.getSqlsession();
    usr = (movie)session.selectOne("movie.selectOne", u);
    return usr;
  }

  @Override
public void update(movie u)
  {
    SqlSession session = util.getSqlsession();
    session.update("movie.updateOne", u);
    session.commit();
  }

  @Override
public void add(movie u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("movie.insertOne", u);
    session.commit();
  }

  @Override
public List<movie> getMovies(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("movie.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("movie.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(movie u)
  {
    SqlSession session = util.getSqlsession();
    movie pt = new movie();
    pt.setId(u.getId());
    if (session.update("movie.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public movie getMovieById(movie u)
  {
    SqlSession session = util.getSqlsession();
    movie usr = (movie)session.selectOne("movie.selectOneById", u);
    return usr;
  }
}