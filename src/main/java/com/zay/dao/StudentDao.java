package com.zay.dao;

import com.zay.po.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author ZhuAoYun
 * @Date 2020/10/1
 */

public interface StudentDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from student")
    @Results(id="StudentResult",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Student> selectAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from student where id=#{id}")
    @ResultMap("StudentResult")
    Student selectOne(String id);

    /**
     * 添加
     * @param student
     * @return
     */
    @Insert("insert into student(id,name,age) values(#{id},#{name},#{age})")
    int insert(Student student);

    /**
     * 修改
     * @param student
     * @return
     */
    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    int update(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from student where id=#{id}")
    int delete(String id);
}
