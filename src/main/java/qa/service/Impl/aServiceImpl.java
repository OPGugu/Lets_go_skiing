package qa.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import qa.Dao.QaDao;
import qa.Dao.Impl.QaDaoImpl;
import qa.service.QaService;
import qa.vo.Qa;

public class aServiceImpl implements QaService {

	private QaDao dao;
	public QaServiceImpl() {
		dao = new QaDaoImpl();
	}
	
	//new
	@Override
	public Qa insert(Integer questionType, String questionTitle, String answerContent, Timestamp questionDate) {
		Qa qa = new Qa();
		qa.setQuestionType(questionType);
		qa.setQuestionTitle(questionTitle);
		qa.setAnswerContent(answerContent);
		qa.setQuestionDate(questionDate);
		return qa;
	}
	//delete
	@Override
	public boolean remove(Integer id) {
		return dao.deleteById(id) > 0;
	}
	//update
	@Override
	public Qa edit(Qa qz) {
		Qa qa = dao.selectByID(qz.getQaID());
		qa.setQuestionType(qz.getQuestionType());
		qa.setQuestionTitle(qz.getQuestionTitle());
		qa.setAnswerContent(qz.getAnswerContent());
		qa.setQuestionDate(qz.getQuestionDate());
		dao.updata(qa);
		return qa;
	}
	
	//getAll
	public List<Qa> qalist() {
		return dao.selectAll();
	}
}