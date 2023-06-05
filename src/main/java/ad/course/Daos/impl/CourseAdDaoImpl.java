package ad.course.Daos.impl;

import java.util.List;

import org.hibernate.query.Query;

import ad.course.Daos.CourseAdDao;
//=======
//import ad.course.dao.CourseAdDao;
//>>>>>>> e6638a84f6a961976edf1a7acf72d24bfb983847
//import core.CoreDao;
//import core.util.HibernateUtil;
import ad.course.vo.CourseAd;
import course.entity.Course;

public class CourseAdDaoImpl implements CourseAdDao {
//	getSession() getSession() = HibernateUtil.getgetSession()Factory().getCurrentgetSession()();

	@Override
	public int insert(CourseAd courseAd) {
		getSession().persist(courseAd);
		return -1;
	}

	@Override
	public Course getCourseByID(Integer courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		CourseAd cAd = getSession().get(CourseAd.class, id);
		getSession().remove(cAd);
		return 1;
	}

	// ???
	@Override
	public int update(CourseAd courseAd) {
		getSession().update(courseAd);
		return 1;
	}

	@Override
	public CourseAd selectAd(Integer id) {
//		return getSession().get(CourseAd.class, id);
		return getSession().get(CourseAd.class, id);
	}

	@Override
	public List<CourseAd> selectAll() {
		return getSession().createQuery("FROM CourseAd", CourseAd.class).list();
	}

	public List<Course> selectAllCourses() {
		return getSession().createQuery("FROM Course", Course.class).list();
	}

	public List<Course> searchCourses(String keyword) {
		String hql = "FROM Course WHERE " + "courseName LIKE :keyword " + "OR level LIKE :keyword "
				+ "OR skill LIKE :keyword";
		Query<Course> query = getSession().createQuery(hql, Course.class);
		query.setParameter("keyword", "%" + keyword + "%");
		return query.getResultList();

	}

	public List<Course> selectActiveCourse() {
		String hql = "FROM Course \r\n" + "WHERE startDate <= CURRENT_TIMESTAMP() AND endDate > CURRENT_TIMESTAMP()";
		Query<Course> query = getSession().createQuery(hql, Course.class);
		return query.getResultList();
	}

	public Course getInfoByID(Integer courseID) {
		String hql = "SELECT courseID, courseName, startDate, endDate\r\n" + "FROM Course\r\n"
				+ "WHERE coachID = :courseID";
		Query<Course> query = getSession().createQuery(hql, Course.class);
		query.setParameter("courseID", courseID);
		return query.getSingleResult();
	}

}