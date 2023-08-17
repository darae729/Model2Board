package org.sp.model2board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sp.model2board.model.BoardDAO;

//파라미터를 받아와서 오라클에 레코드 1건 삭제 (DAO를 이용하여..)
public class DeleteServlet extends HttpServlet{
	BoardDAO boardDAO;
	
	public void init() throws ServletException {
		boardDAO=new BoardDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		
		int result=boardDAO.delete(board_idx); //삭제 수행
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.print("<script>");
		if(result>0) {
			out.print("alert('삭제성공');");
			out.print("location.href='/board/list.jsp';");
		}else {
			out.print("alert('삭제실패');");
			out.print("history.back();");
		}
		out.print("</script>");
		
	}
	
}




