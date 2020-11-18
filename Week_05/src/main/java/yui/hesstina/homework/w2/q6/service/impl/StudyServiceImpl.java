package yui.hesstina.homework.w2.q6.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yui.hesstina.homework.w2.q6.dao.StudyDao;
import yui.hesstina.homework.w2.q6.entity.Study;
import yui.hesstina.homework.w2.q6.pojo.vo.StudyVO;
import yui.hesstina.homework.w2.q6.service.IStudyService;

@Service("studyService")
public class StudyServiceImpl implements IStudyService {

    @Autowired
    private StudyDao studyDao;

    @Override
    public StudyVO getStudyInfo(Integer id) {
        Study study = studyDao.queryStudyOne(id);

        StudyVO vo = new StudyVO();
        BeanUtils.copyProperties(study, vo);

        return vo;
    }

}
