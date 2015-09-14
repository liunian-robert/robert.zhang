package com.aqwx.data.Dao;

import com.aqwx.bean.movie;
import java.util.List;
import java.util.Map;

public abstract interface MovieDao
{
  public abstract movie getMovie(movie parammovie);

  public abstract movie getMovieById(movie parammovie);

  public abstract void update(movie parammovie);

  public abstract void add(movie parammovie);

  public abstract boolean delete(movie parammovie);

  public abstract List<movie> getMovies(Map paramMap);

  public abstract int selectCount();
}

/* Location:           C:\Users\ZHANGYAPO\Desktop\www\WEB-INF\classes\
 * Qualified Name:     com.aqwx.data.Dao.MovieDao
 * JD-Core Version:    0.6.2
 */