package yui.hesstina.homework.w2.q6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yui.hesstina.homework.w2.q6.pojo.vo.StudyVO;
import yui.hesstina.homework.w2.q6.service.IStudyService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IStudyService studyService;

    @GetMapping("/studyInfo")
    public ResponseEntity<StudyVO> getStudyInfo() {
        return ResponseEntity.ok(studyService.getStudyInfo(1));
    }

}
