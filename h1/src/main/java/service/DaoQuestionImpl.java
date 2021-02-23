package service;

import exception.DaoException;
import model.AnswerOption;
import model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DaoQuestionImpl implements DaoQuestion{


    @Override
    public List<Question> getAll() {
        List<Question> questionList = new ArrayList<>();
        URL resource = getClass().getResource("question.csv");
        if(resource != null){
            try {
                URI uri = resource.toURI();
                Path path = Paths.get(uri.getPath());
                BufferedReader bufferedReader = Files.newBufferedReader(path);
                bufferedReader.lines().forEach(s -> {
                    String[] split = s.split(";");
                    Question question = map(split);
                    questionList.add(question);
                });
            } catch (URISyntaxException | IOException e) {
                throw new DaoException("Error reading source of question", e.getCause());
            }
        }
        return questionList;
    }

    private Question map(String[] source) {
        int i = 0;
        Question question = new Question();
        question.setId(Integer.valueOf(source[i]));
        question.setMsq(source[++i]);
        List<AnswerOption> answerOptions = new ArrayList<>();
        answerOptions.add(new AnswerOption(Integer.valueOf(source[++i]), source[++i]));
        answerOptions.add(new AnswerOption(Integer.valueOf(source[++i]), source[++i]));
        answerOptions.add(new AnswerOption(Integer.valueOf(source[++i]), source[++i]));
        question.setAnswerOptions(answerOptions);
        question.setRes(new AnswerOption(Integer.valueOf(source[++i]), source[++i]));
        return question;
    }
}
