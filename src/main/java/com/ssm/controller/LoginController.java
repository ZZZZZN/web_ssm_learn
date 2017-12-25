package com.ssm.controller;

import com.ssm.service.Loginservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/6.
 */
@SuppressWarnings({ "rawtypes" })
@Controller
public class LoginController {
    @Resource
    private Loginservice loginservice;


    @RequestMapping("/login")
    @ResponseBody
    public Map login(String username, String password,HttpServletRequest request) throws Exception {
        Map result= new HashMap();
        try {
            // 判断验证码
            //HttpSession session = request.getSession();
            //String sessionCode = (String) session.getAttribute("imgCode");
            //if (sessionCode != null && sessionCode.equalsIgnoreCase(code)) {
            // 密码AES加密
            if(loginservice.selectUserByUser_name(username)==null){
                result.put("state",false);
                result.put("Msg","用户名不存在");
            }else{
                // shiro的登录
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                Subject currentUser = SecurityUtils.getSubject();
                currentUser.login(token); // 失败 会抛出异常
               /* String roleCode = ShiroUtil.getCurrentUser().get("roleCode")+"";
                if("admin".equals(roleCode) || "adm".equals(roleCode) || "xzfw".equals(roleCode)){
                    rb =ReturnBean.getCustomReturnBean("success1");
                }else{
                    rb = ReturnBean.getSuccessReturnBean();
                }*/
                result.put("state",true);
                result.put("Msg","登录成功");
            }
            // 清除验证码
            //	session.removeAttribute("imgCode");
            //} else {
            //	rb = ReturnBean.getCustomReturnBean("code_error");
            //}
        } catch (Exception e) {
            result.put("state",false);
            result.put("Msg","用户名/密码错误");
            e.printStackTrace();
        }

        return result;
    }
}