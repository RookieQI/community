package com.rookieqi.community.dao;

import com.rookieqi.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //分页查询帖子,userId为在<if>里判断的动态条件,为0代表查询所有帖子，否则代表查询特定用户帖子
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset") int offset,@Param("limit") int limit);

    //@Param用于给参数取别名
    //如果只有一个参数，并且在<if>里判断，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
