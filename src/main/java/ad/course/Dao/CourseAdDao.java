package ad.course.Dao;

import java.util.List;

import ad.course.vo.CourseAd;
import core.CoreDao;
import course.entity.Course;



public interface CourseAdDao extends CoreDao {

	int insert(CourseAd courseAd);

	int delete(Integer id);

	int update(CourseAd ncourseAd);

	CourseAd selectAd(Integer id);

	List<CourseAd> selectAll();
	
	Course getCourseByID(Integer courseID);

	List<Course> selectAllCourses();
	List<Course> searchCourses(String keyword);
	List<Course> selectActiveCourse();
	Course getInfoByID(Integer courseID);
}