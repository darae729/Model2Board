package org.sp.model2board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sp.model2board.domain.Board;
import org.sp.model2board.model.BoardDAO;

public class RegistServlet extends HttpServlet{
	BoardDAO boardDAO;
	
	public RegistServlet() {
		boardDAO = new BoardDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = boardDAO.insert(board);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script>");
		if(result >0) {
			out.print("alert('등록성공');");
			out.print("location.href='/board/list.jsp';");
		}else {
			out.print("alert('등록실패');");
			out.print("history.back();");
		}
		out.print("</script>");
	}
}





