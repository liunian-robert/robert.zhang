package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.team;

public abstract interface TeamDao
{
  public abstract team getTeam(team paramteam);

  public abstract team getTeamById(team paramteam);

  public abstract void update(team paramteam);

  public abstract void add(team paramteam);

  public abstract boolean delete(team paramteam);

  public abstract List<team> getTeams(Map paramMap);

  public abstract int selectCount();
}

