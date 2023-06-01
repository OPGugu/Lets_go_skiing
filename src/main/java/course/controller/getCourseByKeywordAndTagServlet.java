package course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import course.dao.impl.CourseDaoImpl;
import course.entity.Course;


@WebServlet("/course_GBKAT")
public class getCourseByKeywordAndTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
			
		String  keyWord = request.getParameter("keyWord");
		Integer courseLevel =  Integer.valueOf(request.getParameter("courseLevel"));
		Integer courseSkill =  Integer.valueOf(request.getParameter("courseSkill"));
		
		CourseDaoImpl dao = new CourseDaoImpl();
		List<Course> list = dao.getCourseByKeywordAndTag(keyWord, courseSkill, courseLevel);				
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
			
			
		

	
	}
}

