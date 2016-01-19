package jp.softbank.cas.pegasus2.amazon.monthly.web;

import jp.softbank.cas.pegasus2.amazon.monthly.domain.User;
import jp.softbank.cas.pegasus2.amazon.monthly.domain.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserAccount {
    private Log log = LogFactory.getLog(UserAccount.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/userSignUp")
    public String userSignUp(HttpServletRequest request, HttpServletResponse response) {
        return "register";
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String redirectUrl = request.getParameter("amazon-redirect-url");

        User user = new User(userName, password);
        userRepository.save(user);

        String encodedUserName = response.encodeURL(userName);
        String encodedPassword = response.encodeURL(password);
        String amazonDirectUrl = new StringBuilder().append(redirectUrl)
                .append("&")
                .append("infoFiled1=")
                .append(encodedUserName)
                .append("&infoField2=")
                .append(encodedPassword).toString();
        log.info("###url: " + amazonDirectUrl);
        response.sendRedirect(amazonDirectUrl);
    }
}
