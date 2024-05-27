package com.kh.springProject.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 * Lombok(濡щ났)
 * -�옄�룞 肄붾뱶 �깮�꽦 �씪�씠釉뚮윭由�
 * -諛섎났�릺�뒗 getter,setter,toString �벑�쓽 硫붿냼�뱶 �옉�꽦肄붾뱶瑜� 以꾩뿬二쇰뒗 �씪�씠釉뚮윭由�
 * 
 * �꽕移섎갑踰�
 * 1.�씪�씠釉뚮윭由� �떎�슫�썑 �쟻�슜(maven pom.xml dependency 二쇱엯)
 * 2.�씪�씠釉뚮윭由� �꽕移섎맂 寃쎈줈 李얠븘媛��꽌 jar�뙆�씪 �떎�뻾 �썑 �꽕移�
 * 3.IDE �옱�떎�뻾
 * 
 * Lombok �궗�슜�떆 二쇱쓽�궗�빆 
 * uName,pName �� 媛숈� �븵湲��옄媛� �쇅�옄�씤 �븘�뱶紐낆� 留뚮뱾吏� 留먭쾬.
 * 異뷀썑 el�몴湲곕쾿�쓣 �궗�슜�븯�뿬ㅇㅇ �븘�뱶 �젒洹쇱떆 getter硫붿냼�뱶 �샇異쒕릺�뒗�뜲 �씠�븣 �옄�룞�셿�꽦�맂 �삎�깭�뒗 getuName 怨� 媛숈� �삎�깭�씠湲곕븣臾몄뿉 �삤瑜섎컻�깮
 * ㅇㅇ
 * */
@NoArgsConstructor //湲곕낯�깮�꽦�옄
@AllArgsConstructor //紐⑤뱺 �븘�뱶 留ㅺ컻蹂��닔濡� 媛뽯뒗 �깮�꽦�옄
//@Setter //setter 硫붿냼�뱶
//@Getter //getter 硫붿냼�뱶
//@ToString //toString 硫붿냼�뱶
//@EqualsAndHashCode // equals�� hashcode 硫붿냼�뱶 
@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.  媛� �룷�븿�맂 �뼱�끂�뀒�씠�뀡
public class Member {
	private String userId;	//	USER_ID	VARCHAR2(30 BYTE)
	private String userPwd;//	USER_PWD	VARCHAR2(100 BYTE)
	private String userName;	//	USER_NAME	VARCHAR2(15 BYTE)
	private String email;//	EMAIL	VARCHAR2(100 BYTE)
	private String gender;//	GENDER	VARCHAR2(1 BYTE)
	private int age;//	AGE	NUMBER
	private String phone;//	PHONE	VARCHAR2(13 BYTE)
	private String address;//	ADDRESS	VARCHAR2(100 BYTE)
	private Date enrollDate;//	ENROLL_DATE	DATE
	private Date modifyDate;//		MODIFY_DATE	DATE
	private String status;//	STATUS	VARCHAR2(1 BYTE)
}
