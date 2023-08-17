package org.sp.model2board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sp.model2board.domain.Board;
import org.sp.model2board.model.BoardDAO;

//클라이언트가 전송한 수정 폼의 내용을 넘겨받아 오라클에 update
public class EditServlet extends HttpServlet{
	BoardDAO boardDAO;
	
	public void init() throws ServletException {
		boardDAO= new BoardDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기
		//update board set title=넘겨받은 값, writer=넘겨받은 값, content= 넘겨받은 값
		//where board_idx=사용자가 읽은 바로 그 글의 idx
		request.setCharacterEncoding("utf-8"); //파라미터에 대한 인코딩
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");;
		String content=request.getParameter("content");;
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		
		System.out.println("title="+title);
		System.out.println("writer="+writer);
		System.out.println("content="+content);
		System.out.println("board_idx="+board_idx);
		
		Board board=new Board(); //empty
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_idx(board_idx);
		
		//DAO에게 수정을 시킨다
		int result=boardDAO.update(board);
		
		//JSP에서 page 지시영역과 동일효과
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		out.print("<script>");
		if(result>0) {
			out.print("alert('수정성공');");
			out.print("location.href='/board/content.jsp?board_idx="+board_idx+"';");
		}else {
			out.print("alert('수정실패');");
			out.print("history.back();");
		}
		out.print("</script>");
	}
}



