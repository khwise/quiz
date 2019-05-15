package com.quiz.core.services.admin;

import com.quiz.commons.exception.BusinessException;
import com.quiz.core.entity.CommonCodeGroup;
import com.quiz.core.entity.CommonCodeItem;
import com.quiz.core.persistences.repository.CommonCodeGroupRepository;
import com.quiz.core.persistences.repository.CommonCodeItemRepository;
import com.quiz.web.dto.CommonCodeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// todo: 전역 캐싱 map 구현
// todo: createItems
// todo: createItems 하면서 transaction 정의
// todo: update
// todo: create update 시 evict 구현

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
    public CommonCodeGroup createGroup(CommonCodeRequest request) {
        codeGroupRepository.findById(request.getCode()).ifPresent(e -> {throw new BusinessException();});
        return this.saveCodeGroup(request);
    }

    @Override
    public CommonCodeItem createItem(String id, CommonCodeRequest request) {
        return this.saveCodeItem(id, request);
    }

   private CommonCodeGroup saveCodeGroup(CommonCodeRequest request) {
       return codeGroupRepository.save(CommonCodeGroup
               .builder()
                   .groupId(request.getCode())
                   .codeName(request.getCodeName())
                   .codeValue(request.getCodeValue())
                   .used(true)
                   .cache(true)
               .build());
   }

    private CommonCodeItem saveCodeItem(String id, CommonCodeRequest request) {
        return codeItemRepository.save(CommonCodeItem
                .builder()
                    .groupId(id)
                    .code(request.getCode())
                    .codeName(request.getCodeName())
                    .codeValue(request.getCodeValue())
                    .codeDesc(request.getCodeDesc())
                    .used(true)
                .build());
    }
}