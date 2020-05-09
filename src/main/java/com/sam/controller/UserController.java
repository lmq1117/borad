package com.sam.controller;

import com.google.common.base.Joiner;
import com.sam.controller.viewobject.UserVO;
import com.sam.entity.User;
import com.sam.error.BusinessException;
import com.sam.error.EmBusinessError;
import com.sam.response.CommonReturnType;
import com.sam.service.UserService;
import com.sam.service.model.UserModel;
import com.sam.validator.LoginForm;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @GetMapping("/add")
    public Integer addUser(@Validated User user) {
        user.setId(15);
        return user.getId();
    }




    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service层获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        if(userModel == null){
            //userModel.setEncryptPassword("123");
            //throw new Exception("hadf fds");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }


        UserVO userVO = convertFromModel(userModel);


        //返回通用对象
        return CommonReturnType.create(userVO);
    }

    @RequestMapping("/url")
    @ResponseBody
    public CommonReturnType getUrl(HttpServletRequest request, @RequestParam(name = "id") Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("url",request.getServletPath());
        map.put("url-path-info",request.getPathInfo());
        map.put("id",id);
        map.put("str",Joiner.on(",").join(Arrays.asList(1,5,7,8,7,9)));
        return CommonReturnType.create(map);

    }


    @PostMapping("/login")
    @ResponseBody
    public CommonReturnType login(@Valid LoginForm loginForm, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasFieldErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                System.out.println(fieldError);
            });
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("name",loginForm.getName());
        map.put("password",loginForm.getPassword());
        return CommonReturnType.create(map);
    }


    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

}