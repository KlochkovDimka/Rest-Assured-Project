package org.example.generet;

import org.example.dto.curse.CurseEntity;
import org.example.dto.exam.ExamEntity;
import org.example.dto.module.ModuleCurse;
import org.example.dto.module.ModuleEntity;
import org.example.dto.quest.DataEntity;
import org.example.dto.quest.LTP;
import org.example.dto.quest.UpdateQuest;
import org.example.dto.quest.VersionDetails;
import org.example.dto.quiz.QuizEntity;
import org.example.dto.quiz.Variation;
import org.example.dto.template.Course;
import org.example.dto.template.Exam;
import org.example.dto.template.Template;
import org.example.dto.users.UserAuthentication;

import java.util.List;

public class SetEntity {

    public UpdateQuest findUpdateQuest(Integer questId, String name) {
        return new UpdateQuest(
                "", "version", questId,
                new LTP(new DataEntity(
                        "",
                        "",
                        List.of(),
                        List.of(),
                        "",
                        List.of(),
                        name,
                        List.of(),
                        "",
                        "test test",
                        List.of(),
                        List.of(),
                        "",
                        questId)
                ),
                new VersionDetails(0, 0, 1, "1.0.0")
        );
    }
    public UpdateQuest findUpdateQuestAddResponse(Integer questId, String response, String questName) {
        return new UpdateQuest(
                "", "version", questId,
                new LTP(new DataEntity(
                        "",
                        "",
                        List.of(),
                        List.of(),
                        "",
                        List.of(),
                        questName,
                        List.of(),
                        "",
                        response,
                        List.of(),
                        List.of(),
                        "",
                        questId)
                ),
                new VersionDetails(0, 0, 1, "1.0.0")
        );
    }

    public UserAuthentication findUserAuthentication(String login, String password) {
        return new UserAuthentication(login, password);
    }

    public QuizEntity findQuiz(String name) {
        return new QuizEntity("quiz", true, name, List.of(),
                List.of(new Variation("", true),
                        new Variation("", null),
                        new Variation("", null)));
    }

    public ModuleEntity findModule(String name) {
        return new ModuleEntity(name,
                List.of(1000, 1001, 1002, 1005));
    }

    public CurseEntity findCurse(String curseName, String moduleName, Integer idModule) {
        return new CurseEntity(curseName,
                List.of(new ModuleCurse(idModule, moduleName)));
    }

    public ExamEntity findExam(String name) {
        return new ExamEntity(name, 60, List.of());
    }

    public Template findTemplate(String name, Integer examId, Integer courseId) {
        return new Template(name, name,
                List.of(new Exam(examId)),
                List.of(new Course(courseId)));
    }
}
