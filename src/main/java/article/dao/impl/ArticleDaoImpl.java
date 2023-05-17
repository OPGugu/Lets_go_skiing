package article.dao.impl;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
import java.util.List;

//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

//import com.mysql.cj.Query;

//import com.mysql.cj.xdevapi.PreparableStatement;

import article.dao.ArticleDao;
import article.vo.Article;
import article.core.HibernateUtil;
import article.core.coreDao;

public class ArticleDaoImpl implements ArticleDao, coreDao{

	@Override
	public int insert(Article article) {
//		String sql = "insert into Article values(?,?,?,?,?,?,?,?,?)";
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///team6", "root", "password");
//		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
//		SessionFactory sf=HibernateUtil.getSessionFactory();
//		Session session=sf.getCurrentSession();
//		Transaction tr=session.getTransaction();
//		try {
//			Transaction tr = session.beginTransaction();
//			tr.begin();
//			session.persist(article);
			getSession().persist(article);
//			tr.commit();
//		} catch (HibernateException e) {
//			tr.rollback();
//			e.printStackTrace();
//		}
		
//				PreparedStatement ps = conn.prepareStatement(sql);) {
//			ps.setInt(1, article.getArticleID());
//			ps.setInt(2, article.getUserID());
//			ps.setString(3, article.getArticleType());
//			ps.setString(4, article.getArticleTitle());
//			ps.setString(5, article.getArticleContent());
//			ps.setTimestamp(6, article.getArticleDateTime());
//			ps.setTimestamp(7, article.getArticleModified());
//			ps.setInt(8, article.getArticleLike());
//			ps.setString(9, article.getArticleStatus());
//			return ps.executeUpdate(); // 回傳影響0到n筆資料
//		return 1;
		return article.getArticleID();

//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return -1;
	}

	// 複製insert
	@Override
	public int deleteByArticleID(Integer articleID) {
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session s = sf.getCurrentSession();
//		Transaction tr = s.getTransaction();
//		try {
//			tr.begin();
//			Article article = s.get(Article.class, articleID);
			// load:拿值 /get:拿物件
//			s.remove(article);
		     Article article = getSession().get(Article.class, articleID);
		     getSession().remove(article);
		     return articleID;
//			s.delete(article);
//			tr.commit();
//		} catch (Exception e) {
//			tr.rollback();
//		}
//		String sql = "delete from Article where articleID = ?";
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///team6", "root", "password");
//				PreparedStatement ps = conn.prepareStatement(sql);) {
//			ps.setInt(1, articleID);
//			return ps.executeUpdate(); // 回傳影響0到n筆資料
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return -1;
	}

	// 複製insert
	// 開MySQL，點你要的TABLE右鍵->Send to SQL Editor->Update Statement
	// 全選複製(第一行只留資料庫名,跳號全刪)，貼在sql裡面
	@Override
	public int updateByArticleID(Article article) {
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session s = sf.getCurrentSession();
//		Transaction tr = s.getTransaction();
//		try {
//			tr.begin();
//			s.update(article);
			 getSession().update(article);
		     return article.getArticleID();
//			tr.commit();
//		} catch (Exception e) {
//			tr.rollback();
			// TODO: handle exception
//		}
		// 後面沒逗號都可以刪掉\r\n
//		String sql = "UPDATE team6.Article\r\n" + "SET\r\n" + "articleID = ?," + "userID = ?," + "articleType = ?,"
//				+ "articleTitle = ?," + "articleContent = ?," + "articleDateTime = ?," + "articleModified = ?,"
//				+ "articleLike = ?," + "articleStatus = ?\r\n" + "WHERE articleID = ?;";
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///team6", "root", "password");
//				PreparedStatement ps = conn.prepareStatement(sql);) {
//			ps.setInt(1, article.getArticleID());
//			ps.setInt(2, article.getUserID());
//			ps.setString(3, article.getArticleType());
//			ps.setString(4, article.getArticleTitle());
//			ps.setString(5, article.getArticleContent());
//			ps.setTimestamp(6, article.getArticleDateTime());
//			ps.setTimestamp(7, article.getArticleModified());
//			ps.setInt(8, article.getArticleLike());
//			ps.setString(9, article.getArticleStatus());
//			ps.setInt(10, article.getArticleID());
//			return ps.executeUpdate(); // 回傳影響0到n筆資料
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return -1;
	}

	// 複製insert
	@Override
	public Article selectByArticleID(Integer articleID) {
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session s = sf.getCurrentSession();
//		Transaction tr = s.getTransaction();
//		try {
//			tr.begin();
//			Article article = s.get(Article.class, articleID);
//			System.out.println(article);
			 Article article = getSession().get(Article.class, articleID);
		     return article;
//			tr.commit();
//		} catch (Exception e) {
//			tr.rollback();
			// TODO: handle exception
//		}
//		String sql = "select * from Article where articleID = ?";
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///team6", "root", "password");
//				PreparedStatement ps = conn.prepareStatement(sql);) {
//			ps.setInt(1, articleID);
//			try (ResultSet rs = ps.executeQuery();) { // 用rs保存它
//				// rs.next() 從0指到n資料，如果有資料會回傳true
//				if (rs.next()) { // 用if不用while是因為只有一筆資料，也可以用while
//					Article article = new Article();
//					article.setArticleID(rs.getInt("articleID"));
//					article.setUserID(rs.getInt("userID"));
//					article.setArticleType(rs.getString("articleType"));
//					article.setArticleTitle(rs.getString("articleTitle"));
//					article.setArticleContent(rs.getString("articleContent"));
//					article.setArticleDateTime(rs.getTimestamp("articleDateTime"));
//					article.setArticleModified(rs.getTimestamp("articleModified"));
//					article.setArticleLike(rs.getInt("articleLike"));
//					article.setArticleStatus(rs.getString("articleStatus"));
//					return article; // 回傳一個物件
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return null; // 失敗回傳null給我
	}

	// 複製select
	// List袋子裝，只能裝Article
	@Override
	public List<Article> selectAll() throws ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session s = sf.getCurrentSession();
//		Transaction tr = s.getTransaction();
//		try {
		
		 return getSession().createQuery("FROM Article", Article.class).list();
//			tr.begin();
//			Query<Article> query1 = s.createQuery("FROM Article", Article.class);
//			List<Article> list1 = query1.getResultList();
//			tr.commit();
//			return list1;
//		} catch (Exception e) {
//			tr.rollback();
			// TODO: handle exception
//		}
//		return new ArrayList<>();
//		String sql = "select * from Article";
//		try (
//				
//				Connection conn = DriverManager.getConnection("jdbc:mysql:///team6", "root", "password");
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//				) {
//			List<Article> list = new ArrayList<Article>();
//
//			while (rs.next()) { // 查詢多筆資料，所以用while
//				Article article = new Article(); // 建個物件來裝
//				article.setArticleID(rs.getInt("articleID"));
//				article.setUserID(rs.getInt("userID"));
//				article.setArticleType(rs.getString("articleType"));
//				article.setArticleTitle(rs.getString("articleTitle"));
//				article.setArticleContent(rs.getString("articleContent"));
//				article.setArticleDateTime(rs.getTimestamp("articleDateTime"));
//				article.setArticleModified(rs.getTimestamp("articleModified"));
//				article.setArticleLike(rs.getInt("articleLike"));
//				article.setArticleStatus(rs.getString("articleStatus"));
//				list.add(article); // 把資料丟進陣列
//			}
//			return list; // 回傳一個陣列
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.getCurrentSession();
		Transaction tr=session.getTransaction();
		ArticleDao dao = new ArticleDaoImpl();
		try {
			tr.begin();
			
			//新增
//			Article article1 = new Article(null, 2, "a", "b", "c", Timestamp.valueOf("2023-04-30 00:00:00"), Timestamp.valueOf("2023-04-30 00:00:00"), 3, "d");
//			dao.insert(article1);
			
			//刪除ID
//			dao.deleteByArticleID(4);
			
			//修改
//			Article article2 = new Article(3, 3, "e", "f", "g", Timestamp.valueOf("2023-04-30 00:00:00"), Timestamp.valueOf("2023-04-30 00:00:00"), 4, "h");
//			dao.updateByArticleID(article2);
			
			//查詢ID
//			dao.selectByArticleID(2);
			System.out.println(dao.selectByArticleID(2));
			
			//查詢全部
//			List<Article> list = new ArticleDaoImpl().selectAll();
//			System.out.println(list);
			System.out.println(dao.selectAll());
			
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			// TODO: handle exception
		}
		
		
		
		
		
		
		//------------------------------------------------------------------

		// new byte[]{0, 1, 2, 3} 圖片
		//新增
//		Article article1 = new Article(2, 2, "a", "b", "c", Timestamp.valueOf("2023-04-30 00:00:00"), Timestamp.valueOf("2023-04-30 00:00:00"), 3, "d");
//		dao.insert(article1);
		
		//查詢ID
//		System.out.println(dao.selectByArticleID(1));
		
		//查詢全部
//		for (Article article : dao.selectAll()) {
//			System.out.println(article.getArticleContent());
//		}
		
		//刪除
//		dao.deleteByArticleID(2);
		
		//修改
//		Article article2 = new Article(2, 3, "e", "f", "g", Timestamp.valueOf("2023-04-30 00:00:00"), Timestamp.valueOf("2023-04-30 00:00:00"), 4, "h");
//		dao.updateByArticleID(article2);
	}

}
