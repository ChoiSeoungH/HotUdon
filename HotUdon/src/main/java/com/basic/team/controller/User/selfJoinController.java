package com.basic.team.controller.User;

import java.io.IOException;

import com.basic.team.DAO.UserDAO;
import com.basic.team.VO.User;
import com.basic.team.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class selfJoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		System.out.println(id);
		if(id == null) {
			return "user/selfJoin";
		}
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String nickname = req.getParameter("nickname");
		
		User u = new User(id, pw, name, phone, nickname);
		
		int cnt = UserDAO.getInstance().userInsert(u);
		if(cnt>0) {
			return "user/MyPage";
//			req.removeAttribute("center");
		} else {
			return "user/selfJoin";
//			req.setAttribute("center", "user/join");
		}
		
	}

}