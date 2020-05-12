package com.sam.controller;


import com.sam.dao.UserMapper;
import com.sam.entity.User;
import com.sam.response.CommonReturnType;
import com.sam.service.Msg;
import com.sam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/members")
    public String list(Model model) {
        Integer lastUserId = userService.getLastUserId();

        List<User> users = new ArrayList<>();
        int[] genders = {1,2};
        String[] registerModes = {"","wexin","alipay"};
        for (int i = lastUserId+1; i < lastUserId + 11; i++) {
            int index = (int)Math.random()*genders.length;
            int indexRegisterMode = (int)Math.random()*registerModes.length;
            User u = new User();
            u.setName("javaboy:"+i);
            //u.setId(i);
            //u.setGender(genders[index]);
            u.setGender(1);
            u.setAge(150);
            u.setTelephone("13526532135");
            u.setRegisterMode("wexin");
            if(u.getRegisterMode().length() > 0){
                u.setThirdPartyId("wexin"+i);
            }

            userService.insert(u);
            users.add(u);

        }

        model.addAttribute("users",users);
        model.addAttribute("username","李柳柳");
        //return "admin/member/list";
        return "/admin/member/list";

    }

    @PostMapping("/add")
    @ResponseBody
    public CommonReturnType addMember(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",19);
        //map.put("phone",reqUser.getPhone());
        return CommonReturnType.create(map);
        //return "add success";
    }
}
