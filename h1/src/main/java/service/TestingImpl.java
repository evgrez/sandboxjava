package service;

import model.AnswerOption;
import model.Question;

import java.util.List;
import java.util.Map;

public class TestingImpl implements Testing {
    private final IOService ioService;
    private final DaoQuestion daoQuestion;
    private Map<Question, Integer> questionLongMap;

    public TestingImpl(IOService ioService, DaoQuestion daoQuestion) {
        this.ioService = ioService;
        this.daoQuestion = daoQuestion;
    }

    @Override
    public void run() {
        List<Question> questionList = daoQuestion.getAll();
        for (Question question : questionList){
            questionLongMap.put(question, ascQuestion(question));
        }
        printResult(questionLongMap);
    }

    private Integer ascQuestion(Question question){
        ioService.write("question No:" + question.getId());
        ioService.write(question.getMsq());
        question.getAnswerOptions().forEach(answerOption -> {
            ioService.write(answerOption.getId() + ": " + answerOption.getMsg());
        });
        return Integer.valueOf(ioService.read());
    }

    private void printResult(Map<Question, Integer> questionLongMap) {
        ioService.write("Result");
        int right = 0;
        int wrong = 0;
        for (Map.Entry<Question, Integer> entry : questionLongMap.entrySet()) {
            Question question = entry.getKey();
            Integer answer = entry.getValue();
            ioService.write("question No:" + question.getId());
            ioService.write(question.getMsq());
            ioService.write("Right answer:" + question.getRes().getMsg());
            if (question.getRes().getId().equals(answer)) {
                right++;
            } else wrong ++;
        }
        ioService.write("Right: "+ right);
        ioService.write("Wrong: "+ wrong);
    }

}
