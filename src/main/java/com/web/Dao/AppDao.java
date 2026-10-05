package com.web.Dao;

import com.web.bean.AppBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author Ari
 * Date 2026/1/21
 * Desc
 */
@Mapper
public interface AppDao {

    @Select("select * " +
            "from users_info " +
            "where username = #{username}")
    public AppBean getUser( @Param("username") String username);

    //gender,age,occupation,zip_code
    //@Insert("insert into users(name, age) values(#{name}, #{age})")
    @Insert("insert into admin " +
            "VALUES (#{username},#{gender},#{age},#{occupation},#{zipCode})")
    public void register(AppBean appBean);


}
