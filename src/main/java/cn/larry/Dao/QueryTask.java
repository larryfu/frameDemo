package cn.larry.Dao;

import org.hibernate.Session;

import java.util.List;

/*
 * 
 * @author gzfu
 */
public interface QueryTask<E> {
	  List<E> excute(Session ss);
}
