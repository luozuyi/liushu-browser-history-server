package com.liushu.utils;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luo
 */
public abstract class Constants {

	/**
	 * 错误
	 */
	public static String ERROR = "-2";
	/**
	 * 失败
	 */
	public static String FAIL = "-1";
	/**
	 * 成功
	 */
	public static String SUCCESS = "0";
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";

	public static final String ZERO_STRING="0";

	public static final String ONE_STRING="1";

	public static final String TWO_STRING="2";

	public static final String Three_STRING="3";

	public static final String FOUR_STRING="4";

	public static final String FIVE_STRING="5";

	public static final String SIX_STRING="6";

	public static final String SEVEN_STRING="7";

	public static final String EIGHT_STRING="8";

	public static final int TWO_INT=2;

	public static final int THREE_INT=3;

	public static final int FOUR_INT=4;

	public static final int SIX_INT=6;

	public static final int EIGHT_INT=8;

	public static final int TEN_INT=10;

	public static final int TWENTY_INT=20;

	public static final int THIRTY_INT=20;

	public static final int FIFTY_INT=50;

	public static final int INT_255=255;


	public static final String USER_ID_STRING="userId";

	public static final String PARENT_ID_STRING="parentId";

	public static final String SNIPPE_STRING="snippe";

	public static final String BOOK_ID_STRING="bookId";

	public static final String END_TIME_STRING="endTime";

	public static final String NULL_STRING="null";

	public static final String MOBILE_STRING="mobile";

	public static final String PASSWORD_STRING="password";
	/**
	 * fastdfs server ip
	 */
	public static final String FASTDFS_PATH = "fastdfsIp";
	/**
	 * fastdfs server ip address
	 */
	public static final String FASTDFS_SERVER_IP = "http://118.31.46.156";
	/**
	 * elasticsearch server ip address
	 */
	public static final String ELASTICSEARCH_SERVER_IP = "http://47.96.1.66";

	public static final String ACTIVITY_IP = "http://47.96.1.66:8080";

	public static final String PICTUREEXTENTION = "JPG,jpg,PNG,png";

	/**
	 * 章节索引
	 */
	public static final String BOOKCHAPTERDIRECTORYINDEX = "chapterDirectory";
	/**
	 * 所有内容
	 */
	public static final String BOOKCONTENT = "content";

	/**
	 * 每日获取经验上限
	 */
	public static final Integer DAYLIMITEXPRESS=50;

	/**
	 * 书籍来源
	 */
	public enum BookSouce {
		UPLOAD("1", "后台上传"), SPIDER("2", "客户端/搜索上传"),
		PUBLISH("3", "出版"), NONE("4", "无"),
		USERUPLOD("5", "用户自定义上传");
		private String source;
		private String info;

		BookSouce(String source, String info) {
			this.source = source;
			this.info = info;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	public enum BookStatus {
		WAITAUDIT("0", "待审核"),
		NOPASS("1", "不通过"),
		HASUP("2", "已上架"),
		HASDOWN("3", "已下架");


		private String status;
		private String info;

		BookStatus(String status, String info) {
			this.status = status;
			this.info = info;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	public enum AdminIsDisable {
		DISABLE("1", "是"),
		UNDISABLE("0", "否");
		private String isDisable;
		private String info;

		AdminIsDisable(String isDisable, String info) {
			this.isDisable = isDisable;
			this.info = info;
		}

		public String getIsDisable() {
			return isDisable;
		}

		public void setIsDisable(String isDisable) {
			this.isDisable = isDisable;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}


	/**
	 * 广告是否禁用
	 */
	public enum AdvertiseIsForbidden {
		UNFORBIDDEN("0", "不禁用"),
		FORBIDDEN("1", "禁用");

		private String isForbidden;
		private String info;

		AdvertiseIsForbidden(String isForbidden, String info) {
			this.isForbidden = isForbidden;
			this.info = info;
		}

		public String getIsForbidden() {
			return isForbidden;
		}

		public void setIsForbidden(String isForbidden) {
			this.isForbidden = isForbidden;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 经验规则
	 */
	public enum ExpressRule{
		PUBLISHBOOKFLOWEXPRESS("0","发布流书"),
		COMMENTBOOKFLOWEXPRESS("1","评论流书"),
		THUMBUPBOOKFLOWEXPRESS("2","点赞流书"),
		SHAREBOOKFLOWEXPRESS("3","分享流书"),
		DELETEBOOKFLOWEXPRESS("4","删除流书");

		private String type;
		private String info;

		ExpressRule(String type, String info) {
			this.type = type;
			this.info = info;
		}


		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public static String getInfo(String type){
			String info="";
				ExpressRule[] expressRules = ExpressRule.values();
				for (ExpressRule e :
						expressRules) {
					if (StringUtils.equals(e.getType(),type)){
						info=e.getInfo();
					}
				}
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 累计发布流书勋章次数
	 */
	public enum BookFlowCount{
		CUMULATIVEBOOKFLOWCOUNT1("妙笔生花I","10"),
		CUMULATIVEBOOKFLOWCOUNT2("妙笔生花II","100"),
		CUMULATIVEBOOKFLOWCOUNT3("妙笔生花III","300"),
		CUMULATIVEBOOKFLOWBOOK1("博览群书I","3"),
		CUMULATIVEBOOKFLOWBOOK2("博览群书II","10"),
		CUMULATIVEBOOKFLOWBOOK3("博览群书III","50"),
		CONTINUEBOOKFLOWCOUNT1("手不释卷I","3"),
		CONTINUEBOOKFLOWCOUNT2("手不释卷II","7"),
		CONTINUEBOOKFLOWCOUNT3("手不释卷III","14"),
		CONTINUEBOOKFLOWCOUNT4("夜以继日I","30"),
		CONTINUEBOOKFLOWCOUNT5("夜以继日II","50"),
		CONTINUEBOOKFLOWCOUNT6("夜以继日III","100");


		private String type;
		private String count;

		BookFlowCount(String type, String count) {
			this.type = type;
			this.count = count;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}
	}

	/**
	 * 其他流书勋章次数
	 */
	public enum OtherCount{
		CUMULATIVEBOOKFLOWCOMMENTCOUNT1("口若悬河I","10"),
		CUMULATIVEBOOKFLOWCOMMENTCOUNT2("口若悬河I","100"),
		CUMULATIVEBOOKFLOWCOMMENTCOUNT3("口若悬河III","300"),
		CUMULATIVERECEIVEDBOOKFLOWTHUMBCOUNT1("口碑载道I","10"),
		CUMULATIVERECEIVEDBOOKFLOWTHUMBCOUNT2("口碑载道II","100"),
		CUMULATIVERECEIVEDBOOKFLOWTHUMBCOUNT3("口碑载道III","300"),
		CUMULATIVEBOOKFLOWTHUMBCOUNT1("点赞达人I","10"),
		CUMULATIVEBOOKFLOWTHUMBCOUNT2("点赞达人II","100"),
		CUMULATIVEBOOKFLOWTHUMBCOUNT3("点赞达人III","300"),
		CUMULATIVESHAREBOOKFLOWBOOK1("分享达人I","10"),
		CUMULATIVESHAREBOOKFLOWBOOK2("分享达人II","100"),
		CUMULATIVESHAREBOOKFLOWBOOK3("分享达人III","300"),
		CUMULATIVEFOLLOWUSER1("高朋满座I","10"),
		CUMULATIVEFOLLOWUSER2("高朋满座II","100"),
		CUMULATIVEFOLLOWUSER3("高朋满座III","300"),
		CUMULATIVEBEFOLLOWUSER1("众星捧月I","10"),
		CUMULATIVEBEFOLLOWUSER2("众星捧月II","100"),
		CUMULATIVEBEFOLLOWUSER3("众星捧月III","300"),;

		private String type;
		private String count;

		OtherCount(String type, String count) {
			this.type = type;
			this.count = count;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}
	}

	/**
	 * 统计类型规则
	 */
	public enum Statistics{
		CUMULATIVEBOOKFLOW("0","累计发布流书条数"),
		CUMULATIVEBOOKFLOWBOOK("1","累计发布流书本数"),
		CONTINUEBOOKFLOW("2","连续发布流书天数"),
		CUMULATIVEBOOKFLOWCOMMENT("3","累计评论流书条数"),
		CUMULATIVERECEIVEDBOOKFLOWTHUMB("4","累计流书收到点赞次数"),
		CUMULATIVEBOOKFLOWTHUMB("5","累计点赞流书次数"),
		CUMULATIVESHAREBOOKFLOW("6","累计分享流书/书籍次数"),
		CUMULATIVEFOLLOWUSER("7","累计关注用户数量"),
		CUMULATIVEBEFOLLOWUSER("8","累计被其他用户关注数量");

		private String type;
		private String info;

		Statistics(String type, String info) {
			this.type = type;
			this.info = info;
		}


		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public static String getInfo(String type){
			String info="";
			ExpressRule[] expressRules = ExpressRule.values();
			for (ExpressRule e :
					expressRules) {
				if (StringUtils.equals(e.getType(),type)){
					info=e.getInfo();
				}
			}
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

    public enum EXPRESSNUM {
        GRADE_ZERO(0, 0),
        GRADE_ONE(1, 10),
        GRADE_TWO(2, 30),
        GRADE_THREE(3, 300),
        GRADE_FOUR(4, 750),
        GRADE_FIVE(5, 1500),
        GRADE_SIX(6, 3000),
        GRADE_SEVEN(7, 6000),
        GRADE_EIGHT(8, 10000),
        GRADE_NINE(9, 150000),
        GRADE_TEN(10, 225000);
        private Integer type;
        private Integer info;

        EXPRESSNUM(Integer type, Integer info) {
            this.type = type;
            this.info = info;
        }

        public static Integer getInfo(Integer type) {
            for (EXPRESSNUM e : EXPRESSNUM.values()) {
                if (e.getType().equals(type)) {
                    return e.info;
                }
            }
            return null;
        }


        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getInfo() {
            return info;
        }

        public void setInfo(Integer info) {
            this.info = info;
        }
    }

	public static List<String> MEDALNAMESECONDLIST=new ArrayList<>();

	public static List<String> MEDALNAMETHRIDLIST=new ArrayList<>();

	static {
		MEDALNAMESECONDLIST.add("妙笔生花II");
		MEDALNAMETHRIDLIST.add("妙笔生花III");
		MEDALNAMESECONDLIST.add("博览群书II");
		MEDALNAMETHRIDLIST.add("博览群书III");
		MEDALNAMESECONDLIST.add("手不释卷II");
		MEDALNAMETHRIDLIST.add("手不释卷III");
		MEDALNAMESECONDLIST.add("夜以继日II");
		MEDALNAMETHRIDLIST.add("夜以继日III");
		MEDALNAMESECONDLIST.add("口若悬河II");
		MEDALNAMETHRIDLIST.add("口若悬河III");
		MEDALNAMESECONDLIST.add("口碑载道II");
		MEDALNAMETHRIDLIST.add("口碑载道III");
		MEDALNAMESECONDLIST.add("点赞达人II");
		MEDALNAMETHRIDLIST.add("点赞达人III");
		MEDALNAMESECONDLIST.add("分享达人II");
		MEDALNAMETHRIDLIST.add("分享达人III");
		MEDALNAMESECONDLIST.add("高朋满座II");
		MEDALNAMETHRIDLIST.add("高朋满座III");
		MEDALNAMESECONDLIST.add("众星捧月II");
		MEDALNAMETHRIDLIST.add("众星捧月III");
	}

}
