package com.exam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.dao.OptionDAO;
import com.exam.dao.QuestionDAO;
import com.exam.dao.QuestionToExamDAO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.Triad;

public class GetQuestionSet {
		public static ArrayList<QuestionDTO> getQuestions(String examId) throws SQLException{
			ArrayList<QuestionDTO> examset = new ArrayList<>();
			
			QuestionDAO qdao = new QuestionDAO();
			OptionDAO odao = new OptionDAO();
			QuestionToExamDAO qtedao = new QuestionToExamDAO();
			
			List<Integer> questions = qtedao.retrieveQues(Integer.parseInt(examId));
			System.out.println(questions);
			for(Integer i : questions) {
				System.out.println(i);
				Triad<Integer,String,String> t = qdao.getQuestion(i);
				examset.add(odao.getoptions(i, t.second));
			}
			System.out.println(examset);
			return examset;
		}
}
