package edu.demo.trivia.controller;

import edu.demo.trivia.model.Game;
import edu.demo.trivia.model.GodGame;
import edu.demo.trivia.model.GodQuestion;
import edu.demo.trivia.model.Question;
import edu.demo.trivia.service.QuestionBank;
import edu.demo.trivia.service.GodQuestionBank;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TriviaController {
    private final QuestionBank bank;
    private final GodQuestionBank godBank;
    public TriviaController(QuestionBank bank, GodQuestionBank godBank) { this.bank = bank; this.godBank = godBank; }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("total", bank.all().size());
        model.addAttribute("levels", java.util.List.of(
            new Level(1, "Fundamentos", "POO, Java, compilación y datos", bank.forLevel(1).size()),
            new Level(2, "Cómo se relacionan", "Clases, aliases y arreglos", bank.forLevel(2).size()),
            new Level(3, "Modo experto", "ArrayList, excepciones e integración", bank.forLevel(3).size())
        ));
        return "home";
    }

    @PostMapping("/start")
    public String start(@RequestParam int level, HttpSession session) {
        session.setAttribute("level", level);
        session.setAttribute("game", new Game(bank.forLevel(level).size(), level));
        return "redirect:/play";
    }

    @PostMapping("/god/start")
    public String startGodMode(HttpSession session) {
        session.setAttribute("godGame", new GodGame(godBank.all().size()));
        session.removeAttribute("godAnswered");
        return "redirect:/god/play";
    }

    @GetMapping("/god/play")
    public String godPlay(HttpSession session, Model model) {
        GodGame game = godGame(session);
        if (game.isFinished()) return "redirect:/god/results";
        model.addAttribute("game", game);
        model.addAttribute("question", godBank.all().get(game.getCurrentIndex()));
        model.addAttribute("answered", Boolean.TRUE.equals(session.getAttribute("godAnswered")));
        model.addAttribute("selectedAnswer", session.getAttribute("godSelectedAnswer"));
        model.addAttribute("timedOut", Boolean.TRUE.equals(session.getAttribute("godTimedOut")));
        return "god-play";
    }

    @PostMapping("/god/answer")
    public String answerGod(@RequestParam int questionId, @RequestParam(defaultValue = "-1") int answer,
                            @RequestParam(defaultValue = "false") boolean timedOut, HttpSession session) {
        GodGame game = godGame(session);
        GodQuestion question = godBank.all().get(game.getCurrentIndex());
        if (!Boolean.TRUE.equals(session.getAttribute("godAnswered")) && question.id() == questionId) {
            game.answer(!timedOut && answer == question.correctOption());
            session.setAttribute("godAnswered", true);
            session.setAttribute("godSelectedAnswer", answer);
            session.setAttribute("godTimedOut", timedOut);
        }
        return "redirect:/god/play";
    }

    @GetMapping("/god/next")
    public String nextGod(HttpSession session) {
        GodGame game = godGame(session);
        if (!game.isFinished()) game.next();
        session.removeAttribute("godAnswered");
        session.removeAttribute("godSelectedAnswer");
        session.removeAttribute("godTimedOut");
        return game.isFinished() ? "redirect:/god/results" : "redirect:/god/play";
    }

    @GetMapping("/god/results")
    public String godResults(HttpSession session, Model model) {
        model.addAttribute("game", godGame(session));
        return "god-results";
    }

    @GetMapping("/play")
    public String play(HttpSession session, Model model) {
        Game game = game(session);
        if (game.isFinished()) return "redirect:/results";
        model.addAttribute("game", game);
        model.addAttribute("question", bank.forLevel(game.getLevel()).get(game.getCurrentIndex()));
        return "play";
    }

    @PostMapping("/answer")
    public String answer(@RequestParam int questionId, @RequestParam boolean knew, HttpSession session) {
        Game game = game(session);
        Question question = bank.find(questionId);
        if (!game.isFinished()) game.answer(knew);
        return game.isFinished() ? "redirect:/results" : "redirect:/play";
    }

    @GetMapping("/results")
    public String results(HttpSession session, Model model) {
        model.addAttribute("game", game(session));
        return "results";
    }

    private Game game(HttpSession session) {
        Game game = (Game) session.getAttribute("game");
        if (game == null) { game = new Game(bank.forLevel(1).size(), 1); session.setAttribute("game", game); }
        return game;
    }

    private GodGame godGame(HttpSession session) {
        GodGame game = (GodGame) session.getAttribute("godGame");
        if (game == null) { game = new GodGame(godBank.all().size()); session.setAttribute("godGame", game); }
        return game;
    }

    public record Level(int number, String name, String description, int total) {}
}
