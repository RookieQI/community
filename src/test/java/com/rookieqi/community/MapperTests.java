package com.rookieqi.community;

import com.rookieqi.community.dao.DiscussPostMapper;
import com.rookieqi.community.dao.UserMapper;
import com.rookieqi.community.entity.DiscussPost;
import com.rookieqi.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectById(111);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.newcoder.com/101.png");
        user.setCreateTime(new Date());

        int i = userMapper.insertUser(user);
        System.out.println(i);

        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int i = userMapper.updateStatus(150, 1);
        System.out.println(i);

        i = userMapper.updateHeader(150, "www.baidu.com");
        System.out.println(i);

        i = userMapper.updatePassword(150, "hello");
        System.out.println(i);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        System.out.println("帖子总数  " + discussPosts.size());
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
    }

}
