package com.dct.swocean.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

public interface BaseMapper2<T> {
	/**
	 * count查询
	 * 
	 * @param sql
	 * @return
	 */
	@Select("${sql}")
	long count(@Param("sql") String sql);

	/**
	 * Entity查询
	 * 
	 * @param sql
	 * @return
	 */
	@Select("${sql}")
	T findOne(@Param("sql") String sql);

	/**
	 * List<Entity>查询
	 * 
	 * @param sql
	 * @return
	 */
	@Select("${sql}")
	List<T> findList(@Param("sql") String sql);

	/**
	 * 插入
	 * 
	 * @param sql
	 */
	@Insert("${sql}")
	void insert(@Param("sql") String sql);

	/**
	 * 删除/删除所有
	 * 
	 * @param sql
	 */
	@Delete("${sql}")
	void delete(@Param("sql") String sql);

	/**
	 * 修改
	 * 
	 * @param sql
	 */
	@Update("${sql}")
	void update(@Param("sql") String sql);

	/**
	 * 调用存储过程
	 * 
	 * @param sql
	 * @return
	 */
	@Select("${sql}")
	@Options(statementType = StatementType.CALLABLE)
	T call(@Param("sql") String sql);
}
