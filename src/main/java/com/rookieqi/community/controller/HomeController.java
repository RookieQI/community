package com.rookieqi.community.controller;

import com.rookieqi.community.entity.DiscussPost;
import com.rookieqi.community.entity.Page;
import com.rookieqi.community.entity.User;
import com.rookieqi.community.service.DiscussPostService;
import com.rookieqi.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/index")
    public String getIndexPage(Model model, Page page){
        // 方法调用前,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.
        page.setPath("/index");
        page.setRows(discussPostService.findDiscussPostRows(0));

        //先查询DiscussPost(帖子)集合
        List<DiscussPost> list = discussPostService.findDiscussPost(0, page.getOffset(), page.getLimit());
        //再根据帖子的userId字段查询User表得到帖子所属用户的完整信息
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(list != null){
            for(DiscussPost post : list){
                Map map = new HashMap();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "index";
    }
}
