package com.tencent.lucas.demo.mybatis.dal;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by lucasfu on 2016/12/29.
 */
public interface EveningBonusPoolMapper {

    Integer getCurrentRound();

    void updatePoolStatus(@Param("status") int status, @Param("roundId") int roundId);

    void updatePoolShowStatus(@Param("showStatus") int showStatus, @Param("roundId") int roundId);

    void updateOfficialSupply(@Param("officialSupply") int officialSupply, @Param("roundId") int roundId);

    void updateBonusHuadou(@Param("roundId") int huadou, @Param("roundId") int roundId);

    void insertTest(Map<String, Object> map);
}
