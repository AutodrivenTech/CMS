/**
 * Project Name		:	CMS
 * File Name		:	BaseService.java
 * Package Name		:	com.huazhu.application.base.service
 * Date				:	2018年7月11日下午5:55:56
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * ClassName		:	BaseService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午5:55:56 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface BaseService<T> {
	/**
	 * 
	 * selectByPrimaryKey		:	(通过主键查询一条数据). <br/>
	 * 根据主键字段进行查询. <br/>
	 * 方法参数必须包含完整的主键属性. <br/>
	 * 查询条件使用等号. <br/>
	 * @author					:	Alex Hu
	 * @param entityId
	 * @return
	 * @since					:	JDK 1.8
	 */
	T selectByPrimaryKey(Long entityId);

	/**
	 * 
	 * select		:	(根据对象查询数据列表). <br/>
	 * 根据实体中的属性值进行查询. <br/>
	 * 查询条件使用等号. <br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> select(T record);

	/**
	 * 
	 * selectAll		:	(查询全部结果). <br/>
	 * 查询全部结果. <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectAll();

	/**
	 * 
	 * selectOne		:	(查询一条数据). <br/>
	 * 根据实体中的属性进行查询.<br/>
	 * 只能有一个返回值.<br/>
	 * 有多个结果是抛出异常.<br/>
	 * 查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	T selectOne(T record);

	/**
	 * 
	 * selectByExample		:	(根据Example条件进行查询). <br/>
	 * 根据Example条件进行查询.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectByExample(Object example);

	/**
	 * 
	 * selectByExampleAndRowBounds		:	(根据example条件和RowBounds进行分页查询). <br/>
	 * 根据example条件和RowBounds进行分页查询.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @param rowBounds
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

	/**
	 * 
	 * selectCount		:	(根据实体中的属性查询总数). <br/>
	 * 根据实体中的属性查询总数.<br/>
	 * 查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int selectCount(T record);

	/**
	 * 
	 * selectCountByExample		:	(根据Example条件进行查询总数). <br/>
	 * 根据Example条件进行查询总数.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int selectCountByExample(Object example);

	/**
	 * 
	 * selectByRowBounds		:	(根据实体属性和RowBounds进行分页查询). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @param rowBounds
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectByRowBounds(T record, RowBounds rowBounds);

	/**
	 * 
	 * existsWithPrimaryKey		:	(判断主键是否存在). <br/>
	 * 根据主键字段查询总数.<br/>
	 * 方法参数必须包含完整的主键属性.<br/>
	 * 查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param key
	 * @return
	 * @since					:	JDK 1.8
	 */
	boolean existsWithPrimaryKey(Long entityId);

	/**
	 * 
	 * insert		:	(保存一个实体，null的属性也会保存，不会使用数据库默认值). <br/>
	 * 保存一个实体，null的属性也会保存，不会使用数据库默认值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int insert(T record);

	/**
	 * 
	 * insertSelective		:	(保存一个实体，null的属性不会保存，会使用数据库默认值). <br/>
	 * 保存一个实体.<br/>
	 * null的属性不会保存.<br/>
	 * 会使用数据库默认值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int insertSelective(T record);

	/**
	 * 
	 * deleteByPrimaryKey		:	(根据主键字段进行删除，方法参数必须包含完整的主键属性). <br/>
	 * 根据主键字段进行删除，方法参数必须包含完整的主键属性.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param entityId
	 * @return
	 * @since					:	JDK 1.8
	 */
	int deleteByPrimaryKey(Long entityId);

	/**
	 * 
	 * delete		:	根据实体属性作为条件进行删除，查询条件使用等号. <br/>
	 * 根据实体属性作为条件进行删除，查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int delete(T record);

	/**
	 * 
	 * deleteByExample		:	(根据Example条件删除数据). <br/>
	 * 根据Example条件删除数据.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int deleteByExample(Object example);

	/**
	 * 
	 * updateByExample		:	(根据Example条件更新实体`record`包含的全部属性，null值会被更新). <br/>
	 * 根据Example条件更新实体`record`包含的全部属性，null值会被更新.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByExample(@Param("record") T record, @Param("example") Object example);

	/**
	 * 
	 * updateByExampleSelective		:	(根据Example条件更新实体`record`包含的不是null的属性值). <br/>
	 * 根据Example条件更新实体`record`包含的不是null的属性值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

	/**
	 * 
	 * updateByPrimaryKey		:	(根据主键更新实体全部字段，null值会被更新). <br/>
	 * 根据主键更新实体全部字段，null值会被更新.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByPrimaryKey(T record);

	/**
	 * 
	 * updateByPrimaryKeySelective		:	(根据主键更新属性不为null的值). <br/>
	 * 根据主键更新属性不为null的值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByPrimaryKeySelective(T record);
}
