package com.wangsd.web.controller.common;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.wangsd.common.base.BaseController;
import com.wangsd.common.scan.BusinessException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 登录控制器
 *
 * @author Gaojun.Zhou
 * @date 2016年12月14日 下午2:54:01
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping("/login")
    public String login(Model model) throws Exception {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    @RequestMapping("/login2")
    public String login2(Model model) throws Exception {
        model.addAttribute("error", "sdg");
        return "login";
    }

    @RequestMapping("/login3")
    public String login3() throws Exception {
        throw new BusinessException("业务执行异常");
    }

    @RequestMapping("/login4")
    public String login4() throws Exception {
        throw new RuntimeException("业务执行异常");
    }

    /**
     * 执行登录
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(String loginName, String password, String captcha,
                          @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe,
                          RedirectAttributesModelMap model) {
//        if (StringUtils.isBlank(captcha)) {
//            throw new RuntimeException("验证码不能为空");
//        }
//        if (!dreamCaptcha.validate(request, response, captcha)) {
//            throw new RuntimeException("验证码错误");
//        }
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        //token.setRememberMe(1 == rememberMe);
        boolean bl = currentUser.isAuthenticated();
        if (!currentUser.isAuthenticated()) {
            try {
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                model.addFlashAttribute("error", "未知用户");
                return "redirect:/login";
            } catch (IncorrectCredentialsException e) {
                model.addFlashAttribute("error", "密码错误");
                return "redirect:/login";
            } catch (LockedAccountException e) {
                model.addFlashAttribute("error", "账号已锁定");
                return "redirect:/login";
            } catch (AuthenticationException e) {
                model.addFlashAttribute("error", "服务器繁忙");
                return "redirect:/login";
            }
        }
        bl = currentUser.isAuthenticated();
        return "redirect:/index";
    }

    /**
     * 未授权
     * @return {String}
     */
    @GetMapping("/unauth")
    public String unauth() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:/login";
        }
        return "unauth";
    }

    /**
     * 验证码
     */
    @RequestMapping("/captcha")
    @ResponseBody
    public void captcha() throws ServletException, IOException {
        KaptchaExtend kaptchaExtend = new KaptchaExtend();
        kaptchaExtend.captcha(request, response);
    }
}
