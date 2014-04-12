package eu.stiekema.jeroen.vocabtrainer.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jeroen Stiekema
 */
@Controller
@RequestMapping("/subjects")
public class SubjectController {

//    @Autowired
//    private VocabTrainerService vocabTrainerService;


    @RequestMapping
    public String getSubjectsPage() {
        return "manageSubjects";
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String addSubject(@RequestBody AddSubjectCommand addSubjectCommand) {
//        addSubjectCommand.setSubjectId(UUID.randomUUID().toString());
//        vocabTrainerService.addSubject(addSubjectCommand);
//        return "OK";
//    }
}
