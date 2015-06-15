package com.gongxm.mybookreader.utils;

/**
 * 常量类
 * @author gongxm
 *
 */
public interface AppConstants {

	public static final String SITE_INFO_DB_NAME = "myreader.db"; //数据库名称
	public static final int SITE_INFO_DB_VERSION = 1; //数据库版本
	public static final String TABLE_NAME_SITE_INFO = "SITE_INFO"; //表名称 : 可用的网站信息
	public static final String TABLE_NAME_ENABLE_PARSER_SITE="ENABLE_SITE";//表名:可以正常解析的网站信息
	
	public static final String[] CATEGORIES={"玄幻","奇幻","武侠","仙侠","都市","青春","历史","军事","游戏","竞技","科幻","灵异","同人"};
	
	public static final String ENABLE_URL="http://api.dushubus.com/api/siteInfo";//获取可用的网站
	public static final String CATEGORY_URL="http://api.dushubus.com/recommend/categorizedBooks";//获取分类列表
	public static final String BOOK_DETAIL_URL="http://api.dushubus.com/api/downInfo";//获取书籍详细信息
	public static final String BOOK_SEARCH_URL="http://api.dushubus.com/api/search?name=";//搜索关键词
	public static final String BOOK_INDEX_URL="http://api.dushubus.com/api/renew?listUrl=";//书籍目录下载地址
	public static final int ERROR = 0;//错误码
	public static final int SUCCESS = 1;//成功码
	
	
	
	/*************可以正常解析的网站信息 START ******************/
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
	public static final String[] siteNames={"零点书院",
		"猪猪岛小说网",
		"800小说网",
		
		"爱腐竹小说网",
		"八一中文网",
		"吾爱文学网",
		"好读网",
		"可乐小说网",
		"无忧中文网",
		"大書包",
		"八月居",
		"穿越小说吧",
		"幼师书盟",
		"眼快看书",
		"九九中文",
		"冰火binhuo",
		"LU5小说网",
		"新悠悠书盟",
		"爱上中文网",
		"書哈哈小说网"
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
		"<!--开始循环卷列表-->",
		"<div class=\"list_box\">",
		"<div align=\"center\"><script",
		"目录上AD",
		"<section class=\"ml_main\">",
		"<table border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" class=\"acss\">",
		"文字广告",
		"<dl class=\"chapterlist\">",
		"<div id=\"xsbody\">",
		"<!-- Baidu Button END -->",
		"<div class=\"booklist clearfix\">",
		"<div id=\"booklist\">",
		"<div class=\"readerListShow\">",
		"<!-- Baidu Button END -->",
		"<!--开始循环卷列表-->"
	};
	
	public static final String[] endTags={"<div class=\"Clear\">",
		"<div class=\"foot\">",
		"<div class=\"ml_ad4\">",
		
		"<div class=\"gg\">",
		"<table  id=\"bgdiv\" cellspacing=\"0\" cellpadding=\"0\">",
		"<!--开始循环卷列表结束-->",
		"<div class=\"Tuijian\">",
		"<script type=\"text/javascript\" src=\"/ad/index.js\"></script>",
		"目录下AD",
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
		"<!--开始循环卷列表结束-->"
	};
	
	public static final String chapterReg=">.{1,50}</a>";
	public static final String extra="";
	public static final int[] siteIds={170,167,
		177,178,162,174,163,150,152,130,87,75,
		165,168,176,151,133,179,171,166
	};
	
	/*************可以正常解析的网站信息 END ******************/
	
}
