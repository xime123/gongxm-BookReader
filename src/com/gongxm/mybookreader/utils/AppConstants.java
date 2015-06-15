package com.gongxm.mybookreader.utils;

/**
 * ������
 * @author gongxm
 *
 */
public interface AppConstants {

	public static final String SITE_INFO_DB_NAME = "myreader.db"; //���ݿ�����
	public static final int SITE_INFO_DB_VERSION = 1; //���ݿ�汾
	public static final String TABLE_NAME_SITE_INFO = "SITE_INFO"; //������ : ���õ���վ��Ϣ
	public static final String TABLE_NAME_ENABLE_PARSER_SITE="ENABLE_SITE";//����:����������������վ��Ϣ
	
	public static final String[] CATEGORIES={"����","���","����","����","����","�ഺ","��ʷ","����","��Ϸ","����","�ƻ�","����","ͬ��"};
	
	public static final String ENABLE_URL="http://api.dushubus.com/api/siteInfo";//��ȡ���õ���վ
	public static final String CATEGORY_URL="http://api.dushubus.com/recommend/categorizedBooks";//��ȡ�����б�
	public static final String BOOK_DETAIL_URL="http://api.dushubus.com/api/downInfo";//��ȡ�鼮��ϸ��Ϣ
	public static final String BOOK_SEARCH_URL="http://api.dushubus.com/api/search?name=";//�����ؼ���
	public static final String BOOK_INDEX_URL="http://api.dushubus.com/api/renew?listUrl=";//�鼮Ŀ¼���ص�ַ
	public static final int ERROR = 0;//������
	public static final int SUCCESS = 1;//�ɹ���
	
	
	
	/*************����������������վ��Ϣ START ******************/
	public static final String[] hosts={"http://www.00sy.com",
			"http://www.zhuzhudao.com",
			"http://www.800book.net",
			
			"http://www.ifuzhu.com",
			"http://www.81zw.cc",
			"http://www.9552.org",
			"http://haodu5.com",
			"http://www.klxsw.com",
			"http://www.5uzw.com",
			"http://www.dashubao.com",
			"http://www.bayueju.com",
			"http://www.sj131.com",
			"http://www.yssm.org",
			"http://www.yankuai.com",
			"http://www.99zw.cn",
			"http://www.binhuo.com",
			"http://www.lu5.com",
			"http://www.u33.cc",
			"http://www.aszw.com",
			"http://read.shuhaha.com"
			};
	public static final String[] siteNames={"�����Ժ",
		"����С˵��",
		"800С˵��",
		
		"������С˵��",
		"��һ������",
		"�ᰮ��ѧ��",
		"�ö���",
		"����С˵��",
		"����������",
		"�����",
		"���¾�",
		"��ԽС˵��",
		"��ʦ����",
		"�ۿ쿴��",
		"�ž�����",
		"����binhuo",
		"LU5С˵��",
		"����������",
		"����������",
		"������С˵��"
	};
	public static final String[] urlRegs={"href=.{1}\\d+\\.shtml",
		"href=.{0,30}/?\\d{3,}/\\d{3,}/",
		"href=\"http.{0,50}/\\d{3,}/\\d{3,}\\.html",
		
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html",
		"href=.{1}\\d+\\.html"
	};
	public static final String[] startTags={"<p class=\"tl pd8 pd10\">",
		"<div class=\"list\">",
		"<div class=\"ml_ad3\" id=\"zuixin\">",
		
		"<div class=\"list\">",
		"<div align=center>",
		"<!--��ʼѭ�����б�-->",
		"<div class=\"list_box\">",
		"<div align=\"center\"><script",
		"Ŀ¼��AD",
		"<section class=\"ml_main\">",
		"<table border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" class=\"acss\">",
		"���ֹ��",
		"<dl class=\"chapterlist\">",
		"<div id=\"xsbody\">",
		"<!-- Baidu Button END -->",
		"<div class=\"booklist clearfix\">",
		"<div id=\"booklist\">",
		"<div class=\"readerListShow\">",
		"<!-- Baidu Button END -->",
		"<!--��ʼѭ�����б�-->"
	};
	
	public static final String[] endTags={"<div class=\"Clear\">",
		"<div class=\"foot\">",
		"<div class=\"ml_ad4\">",
		
		"<div class=\"gg\">",
		"<table  id=\"bgdiv\" cellspacing=\"0\" cellpadding=\"0\">",
		"<!--��ʼѭ�����б����-->",
		"<div class=\"Tuijian\">",
		"<script type=\"text/javascript\" src=\"/ad/index.js\"></script>",
		"Ŀ¼��AD",
		"<section class=\"tixing\">",
		"<div id=\"adbottom\">",
		"<!-- =statement= -->",
		"<div class=\"notice\"",
		"<div id=\"down\">",
		"<div id=\"adbottom\">",
		"<!--booklist-->",
		"<!--booklist-->",
		"<div class=\"tips\">",
		"<dd class=\"tips\">",
		"<!--��ʼѭ�����б����-->"
	};
	
	public static final String chapterReg=">.{1,50}</a>";
	public static final String extra="";
	public static final int[] siteIds={170,167,
		177,178,162,174,163,150,152,130,87,75,
		165,168,176,151,133,179,171,166
	};
	
	/*************����������������վ��Ϣ END ******************/
	
}
