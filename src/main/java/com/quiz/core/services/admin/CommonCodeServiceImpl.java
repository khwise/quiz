package com.quiz.core.services.admin;

import com.quiz.core.entity.CommonCodeGroup;
import com.quiz.core.persistences.repository.CommonCodeGroupRepository;
import com.quiz.core.persistences.repository.CommonCodeItemRepository;
import com.quiz.web.dto.CommonCodeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommonCodeServiceImpl implements CommonCodeService {
    private final Logger log = LoggerFactory.getLogger(CommonCodeServiceImpl.class);

    private CommonCodeGroupRepository codeGroupRepository;

    private CommonCodeItemRepository codeItemRepository;

    @Autowired
    public CommonCodeServiceImpl(
            @Qualifier("commonCodeGroupRepository") CommonCodeGroupRepository codeGroupRepository,
            @Qualifier("commonCodeItemRepository") CommonCodeItemRepository codeItemRepository
    ) {

        this.codeGroupRepository = codeGroupRepository;
        this.codeItemRepository = codeItemRepository;
    }

    @Override
    public void createGroupCode(CommonCodeRequest request) {
        codeGroupRepository.save(CommonCodeGroup
                .builder()
                    .groupId(request.getCode())
                    .codeName(request.getCodeName())
                    .codeValue(request.getCodeValue())
                    .used(true)
                    .cache(true)
                .build());
    }
}
