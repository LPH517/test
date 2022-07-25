package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        List<User> users = userService.findAllUsers();
        System.out.println("servlet....."+users);
        ApiResult<List<User>> result = ApiResult.success(users);

        ObjectMapper om = new ObjectMapper();

        String s = om.writeValueAsString(result);

        resp.getWriter().print(s);
    }
}
