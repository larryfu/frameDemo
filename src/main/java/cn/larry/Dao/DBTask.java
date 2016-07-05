package cn.larry.Dao;

import org.hibernate.Session;

public interface DBTask<E> {
	E excute(Session ss);
}
