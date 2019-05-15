package com.quiz.core.services.admin;

import com.quiz.core.entity.CommonCodeGroup;
import com.quiz.core.entity.CommonCodeItem;
import com.quiz.web.dto.CommonCodeRequest;

public interface CommonCodeService {

    CommonCodeGroup createGroup(CommonCodeRequest request);
    CommonCodeItem createItem(String id, CommonCodeRequest request);
}
