package board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boarddao.BoardDAO;
import board.boarddto.BoardDTO;
import util.Action;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = 1;
		
		if(request.getParameter("start") != null) {
			start = Integer.parseInt(request.getParameter("start"));
		}

		ArrayList<BoardDTO> list = BoardDAO.getInstance().getList(start);
		
		
		int total = BoardDAO.getInstance().getTotal();
		int nowPage = (start - 1) / 5 + 1;
		
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("start", start);

	}

}
