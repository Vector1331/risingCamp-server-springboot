package com.example.demo.src.save;

import com.example.demo.src.save.model.GetSaveRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SaveDao {
    private final EntityManager em;
    private int episodeCnt =1;
    public List<GetSaveRes> getSaveContents(int profileIdx) {

        String jpql = "SELECT s.save_content_idx, c.content_idx, c.title, c.age," +
                " COUNT(s.content_idx), c.sample_img_url" +
                " FROM save_content s" +
                " JOIN content c" +
                " ON c.content_idx = s.content_idx" +
                " WHERE s.profile_idx = :profileIdx" +
                " GROUP BY c.content_idx";
        //NativeQuery로 직접 날림
        Query nativeQuery = em.createNativeQuery(jpql)
                .setParameter("profileIdx", profileIdx);
        List<Object[]> resultList = nativeQuery.getResultList();
        List<GetSaveRes> getSaveRes = new ArrayList<>();
        for(Object[] row: resultList) {
            int saveContentIdx = (Integer)row[0];
            Integer  contentIdx = ((BigInteger)row[1]).intValue();
            String title = (String)row[2];
            Integer age = (Integer)row[3];
            Integer episodeCnt = ((BigInteger)row[4]).intValue();
            String sampleImgUrl = (String)row[5];
            getSaveRes.add(new GetSaveRes(saveContentIdx,contentIdx, title, age, episodeCnt, sampleImgUrl));
        }
        return getSaveRes;


    }
}
